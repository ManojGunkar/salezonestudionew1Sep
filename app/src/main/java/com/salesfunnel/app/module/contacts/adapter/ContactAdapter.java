package com.salesfunnel.app.module.contacts.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salesfunnel.R;
import com.salesfunnel.apiconnector.model.LeadApi;

import java.util.List;

/**
 * Created by Manoj Kumar on 17-11-2018.
 */
public class ContactAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private Context mContext;
    private List<LeadApi> mLeads;


    public ContactAdapter(Context context, List<LeadApi> leads) {
        this.mContext = context;
        this.mLeads = leads;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        viewHolder = getViewHolder(parent, inflater);
        return viewHolder;

    }

    @NonNull
    private RecyclerView.ViewHolder getViewHolder(ViewGroup parent, LayoutInflater inflater) {
        return new LocalViewHolder(inflater.inflate(R.layout.row_lead, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

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

        localViewHolder.txtUserStage.setText(lead.getLeadStage());
        localViewHolder.txtDealSize.setText(String.valueOf(lead.getDealSize()));
        String firstWordOfUser = lead.getFirstName().charAt(0) + "";
        localViewHolder.txtUserChar.setText(firstWordOfUser);

        GradientDrawable bgShape = (GradientDrawable) localViewHolder.txtUserChar.getBackground();
        bgShape.setColor(Color.parseColor("#7AFFCC"));
        localViewHolder.txtLastseen.setText(lead.getLastModifiedDate().split("T")[0]);
    }

    @Override
    public int getItemCount() {
        return mLeads == null ? 0 : mLeads.size();
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
}
