package com.salesfunnel.app.module.leads;

import android.os.Bundle;
import android.os.Handler;
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
import com.salesfunnel.apiconnector.contoller.ApiRequestController;
import com.salesfunnel.apiconnector.model.LeadApi;
import com.salesfunnel.apiconnector.presenter.ApiPresenter;
import com.salesfunnel.app.module.leads.adapter.LeadAdapter;
import com.salesfunnel.app.module.leads.adapter.OnPaginationListener;
import com.salesfunnel.app.module.leads.utils.LeadHolder;
import com.salesfunnel.app.utils.AppConstants;
import com.salesfunnel.app.utils.DataSource;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Manoj Kumar on 17-11-2018.
 * Copyright (C) 2018. Global Delight Technologies Pvt. Ltd. All rights reserved.
 */
public class LeadFragmentTab extends Fragment {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    private LinearLayout errorLayout;
    private Button btnRetry;
    private TextView txtError;

    private int leadLimit = 50;
    private int totalPage = 0;
    private int currentPage = 1;
    private boolean isLoading = false;
    private boolean isLastPage = false;

    private List<LeadApi> mLeads = new ArrayList<>();
    private LeadAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mProgressBar = view.findViewById(R.id.progress);
        mProgressBar.setVisibility(View.VISIBLE);
        errorLayout = view.findViewById(R.id.error_layout);
        btnRetry = view.findViewById(R.id.error_btn_retry);
        txtError = view.findViewById(R.id.error_txt_cause);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        btnRetry.setOnClickListener(view1 -> fetchAllLeads());

        mAdapter = new LeadAdapter(getActivity(), mLeads);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setRetryCallback(() -> fetchAllLeads());

        mRecyclerView.addOnScrollListener(new OnPaginationListener(llm) {
            @Override
            protected void loadMoreContent() {
                isLoading = true;
                currentPage = currentPage + 1;

                new Handler().postDelayed(() -> fetchAllLeads(), 1000);
            }

            @Override
            public int getTotalPageCount() {
                return totalPage - 1;
            }

            @Override
            public boolean isLastPage() {
                return isLastPage;
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }
        });
        fetchAllLeads();
    }

    private void fetchAllLeads() {
        hideErrorView();
        String crmUserId = new DataSource(getActivity()).getValue(AppConstants.USERID);
        ApiPresenter.getInstance(getActivity()).getAllLeads(crmUserId, currentPage, leadLimit, result -> {
            if (result.isSuccess()) {
                mProgressBar.setVisibility(View.GONE);
                mRecyclerView.setVisibility(View.VISIBLE);

                if (isLoading)
                    mAdapter.removeLoadingFooter();
                isLoading = false;

                mLeads = result.get();
                totalPage = mLeads.get(0).getTotalLeadCount();
                totalPage = totalPage / leadLimit;

                LeadHolder.getInstance().saveLeads(mLeads);

                mAdapter.addAll(mLeads);
                mAdapter.notifyDataSetChanged();

                if (currentPage <= totalPage) mAdapter.addLoadingFooter();
                else isLastPage = true;
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
