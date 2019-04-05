package com.salesfunnel.app.module.contacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.salesfunnel.R;
import com.salesfunnel.apiconnector.model.LeadApi;
import com.salesfunnel.apiconnector.presenter.ApiPresenter;
import com.salesfunnel.app.module.contacts.adapter.ContactAdapter;
import com.salesfunnel.app.module.leads.utils.LeadHolder;
import com.salesfunnel.app.utils.AppConstants;
import com.salesfunnel.app.utils.DataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manoj Kumar on 19-11-2018.
 */
public class ContactFragmentTab extends Fragment {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    private List<LeadApi> mLeads = new ArrayList<>();
    private ContactAdapter mAdapter;

    private LinearLayout errorLayout;
    private Button btnRetry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mProgressBar = view.findViewById(R.id.progress);

        errorLayout = view.findViewById(R.id.error_layout);
        btnRetry = view.findViewById(R.id.error_btn_retry);

        btnRetry.setOnClickListener(v -> fetchAllLeads());

        mProgressBar.setVisibility(View.VISIBLE);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new ContactAdapter(getActivity(), mLeads) {
        };
        mRecyclerView.setAdapter(mAdapter);

        mLeads= LeadHolder.getInstance().getLeads();
        if (mLeads.size()==0){
            fetchAllLeads();
        }else {
            mProgressBar.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
            mAdapter.notifyDataSetChanged();
        }

    }

    private void fetchAllLeads() {
        String crmUserId = new DataSource(getActivity()).getValue(AppConstants.USERID);
        ApiPresenter.getInstance(getActivity()).getAllLeads(crmUserId, 1, 50, result -> {
            if (result.isSuccess()) {
                hideErrorView();
                mProgressBar.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);
                mLeads = result.get();
                LeadHolder.getInstance().saveLeads(mLeads);
                mAdapter.notifyDataSetChanged();
            }else {
                showErrorView();
            }

        });
    }

    private void showErrorView() {
        if (errorLayout.getVisibility() == View.GONE) {
            mRecyclerView.setVisibility(View.GONE);
            errorLayout.setVisibility(View.VISIBLE);
            mProgressBar.setVisibility(View.GONE);
        }
    }

    private void hideErrorView() {
        if (errorLayout.getVisibility() == View.VISIBLE) {
            errorLayout.setVisibility(View.GONE);
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

}
