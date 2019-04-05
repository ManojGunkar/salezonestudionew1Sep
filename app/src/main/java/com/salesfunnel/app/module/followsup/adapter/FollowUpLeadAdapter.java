package com.salesfunnel.app.module.followsup.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.salesfunnel.R;
import com.salesfunnel.apiconnector.model.LeadApi;

import java.util.List;

/**
 * Created by Manoj Kumar on 17-11-2018.
 */
public class FollowUpLeadAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final static int DISPLAYING = 0;
    private final static int LOADING = 1;
    private boolean retryPageLoad = false;

    private String errorMsg;

    private Context mContext;
    private List<LeadApi> mLeads;
    private boolean isLoadingAdded = false;
    private RetryCallback mCallback;

    public FollowUpLeadAdapter(Context context, List<LeadApi> leads) {
        this.mContext = context;
        this.mLeads = leads;
    }

    public void setRetryCallback(RetryCallback retryCallback) {
        this.mCallback = retryCallback;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case DISPLAYING:
                viewHolder = getViewHolder(parent, inflater);
                break;
            case LOADING:
                viewHolder = new FollowUpLeadAdapter.LoadingViewHolder(inflater.inflate(R.layout.item_progress, parent, false));
                break;
        }
        return viewHolder;

    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new LocalViewHolder(inflater.inflate(R.layout.row_lead, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)) {
            case DISPLAYING:
                LocalViewHolder localViewHolder = (LocalViewHolder) holder;
                LeadApi lead = mLeads.get(position);

                String middleName = "";
                if (lead.getMiddleName() != null) {
                    middleName = lead.getMiddleName().equalsIgnoreCase("None") ? "" : lead.getMiddleName();
                }
                String lastName = "";
                if (lead.getLastName() != null) {
                    lastName = lead.getLastName().equalsIgnoreCase("None") ? "" : lead.getLastName();
                }

                localViewHolder.txtMobile.setText(lead.getMobileNumber());
                localViewHolder.txtEmail.setText(lead.getEmail());

                localViewHolder.txtUsername.setText(lead.getFirstName() + " " + middleName + " " + lastName);

                localViewHolder.txtUserStage.setText(lead.getSubLeadStageName());
                localViewHolder.txtDealSize.setText(String.valueOf(lead.getDealSize()));
                String firstWordOfUser = lead.getFirstName().charAt(0) + "";
                localViewHolder.txtUserChar.setText(firstWordOfUser);

                GradientDrawable bgShape = (GradientDrawable) localViewHolder.txtUserChar.getBackground();
                bgShape.setColor(Color.parseColor("#7AFFCC"));
                localViewHolder.txtLastseen.setText(lead.getLastModifiedDate().split("T")[0]);

                break;

            case LOADING:
                LoadingViewHolder loadingVH = (LoadingViewHolder) holder;

                if (retryPageLoad) {
                    loadingVH.llError.setVisibility(View.VISIBLE);
                    loadingVH.progressBar.setVisibility(View.GONE);

                    loadingVH.txtError.setText(
                            errorMsg != null ?
                                    errorMsg :
                                    mContext.getString(R.string.error_msg_unknown));
                } else {
                    loadingVH.llError.setVisibility(View.GONE);
                    loadingVH.progressBar.setVisibility(View.VISIBLE);
                }
                break;
        }

    }

    @Override
    public int getItemCount() {
        return mLeads == null ? 0 : mLeads.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (position == mLeads.size() - 1 && isLoadingAdded) ? LOADING : DISPLAYING;
    }

    public void add(LeadApi lead) {
        mLeads.add(lead);
        notifyItemInserted(mLeads.size() - 1);
    }

    public void addAll(List<LeadApi> leads) {
        for (LeadApi result : leads) {
            add(result);
        }
    }

    public void remove(LeadApi lead) {
        int position = mLeads.indexOf(lead);
        if (position > -1) {
            mLeads.remove(position);
            notifyItemRemoved(position);
        }
    }

    public void clear() {
        isLoadingAdded = false;
        while (getItemCount() > 0) {
            remove(getItem(0));
        }
    }

    public boolean isEmpty() {
        return getItemCount() == 0;
    }

    public void addLoadingFooter() {
        isLoadingAdded = true;
        add(new LeadApi());
    }

    public void removeLoadingFooter() {
        isLoadingAdded = false;

        int position = mLeads.size() - 1;
        if (position >= 0) {
            LeadApi result = getItem(position);

            if (result != null) {
                mLeads.remove(position);
                notifyItemRemoved(position);
            }
        }

    }

    public LeadApi getItem(int position) {
        return mLeads.get(position);
    }

    public void showRetry(boolean show, @Nullable String errorMsg) {
        retryPageLoad = show;
        notifyItemChanged(mLeads.size() - 1);

        if (errorMsg != null) this.errorMsg = errorMsg;
    }

    public interface RetryCallback {
        void retryPageLoad();
    }

    protected class LocalViewHolder extends RecyclerView.ViewHolder {

        private TextView txtUserChar;
        private TextView txtUsername;
        private TextView txtMobile;
        private TextView txtEmail;
        private TextView txtDealSize;
        private TextView txtUserStage;
        private TextView txtLastseen;

        private LinearLayout leadRoot;

        public LocalViewHolder(View view) {
            super(view);
            txtLastseen = view.findViewById(R.id.lastseen);
            txtUserStage = view.findViewById(R.id.userStage);
            txtUserChar = view.findViewById(R.id.userChar);
            txtUsername = view.findViewById(R.id.username);
            txtMobile = view.findViewById(R.id.tv_mobile);
            txtEmail = view.findViewById(R.id.tv_email);
            txtDealSize = view.findViewById(R.id.tv_deal_size);
            leadRoot = view.findViewById(R.id.leadRoot);


        }
    }

    protected class LoadingViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ProgressBar progressBar;
        private ImageButton btnRetry;
        private TextView txtError;
        private LinearLayout llError;

        public LoadingViewHolder(View itemView) {
            super(itemView);

            progressBar = itemView.findViewById(R.id.loadmore_progress);
            btnRetry = itemView.findViewById(R.id.loadmore_retry);
            txtError = itemView.findViewById(R.id.loadmore_errortxt);
            llError = itemView.findViewById(R.id.loadmore_errorlayout);

            btnRetry.setOnClickListener(this);
            llError.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.loadmore_retry:
                case R.id.loadmore_errorlayout:

                    showRetry(false, null);
                    mCallback.retryPageLoad();

                    break;
            }
        }
    }

}
