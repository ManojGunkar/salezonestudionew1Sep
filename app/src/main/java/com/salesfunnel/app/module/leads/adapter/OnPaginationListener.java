package com.salesfunnel.app.module.leads.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Manoj Kumar on 17-11-2018.
 */
public abstract class OnPaginationListener extends RecyclerView.OnScrollListener {
    protected abstract void loadMoreContent();
    public abstract int getTotalPageCount();
    public abstract boolean isLastPage();
    public abstract boolean isLoading();

    LinearLayoutManager layoutManager;

    public OnPaginationListener(LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int visibleItemCount = layoutManager.getChildCount();
        int totalItemCount = layoutManager.getItemCount();
        int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();

        int totatPageCount=getTotalPageCount();
        boolean load=isLoading();
        boolean lastpage=isLastPage();

        if (!isLoading() && !isLastPage()) {
            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                    && firstVisibleItemPosition >= 0) {
                loadMoreContent();
            }
        }

//        if (!isLoading()&&!isLastPage()) {
//            if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount) {
//              loadMoreContent();
//            }
//        }
    }
}
