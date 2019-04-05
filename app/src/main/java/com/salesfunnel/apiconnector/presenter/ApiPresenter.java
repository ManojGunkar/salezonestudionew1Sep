package com.salesfunnel.apiconnector.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.salesfunnel.apiconnector.contoller.ApiRequestController;
import com.salesfunnel.apiconnector.model.CrmUserApi;
import com.salesfunnel.apiconnector.model.LeadApi;
import com.salesfunnel.apiconnector.model.LeadStatusApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Manoj Kumar on 04-11-2018.
 * Copyright (C) 2018. Global Delight Technologies Pvt. Ltd. All rights reserved.
 */
public class ApiPresenter {

    public interface CompletionHandler <T> {
        void onComplete(Result<T> result);
    }

    private static ApiPresenter instance;
    private Context mContext;

    private ApiRequestController.RequestCallback mClientCallback;

    private Handler mMainHandler = new Handler(Looper.getMainLooper());

    private ApiPresenter(Context context) {
        this.mContext = context.getApplicationContext();
        mClientCallback = ApiRequestController.getClient();
    }

    public static ApiPresenter getInstance(Context context) {
        if (instance == null) instance = new ApiPresenter(context);
        return instance;
    }



    public void logIn(CrmUserApi requestBody, CompletionHandler<CrmUserApi> callback){
        Call<CrmUserApi> call = mClientCallback.login(requestBody);
        call.enqueue(new Callback<CrmUserApi>() {
            @Override
            public void onResponse(Call<CrmUserApi> call, Response<CrmUserApi> response) {
                if (response.isSuccessful()) {
                    mMainHandler.post(()-> callback.onComplete(Result.success(response.body())));
                } else {
                    mMainHandler.post(()-> callback.onComplete(Result.error(response.code(), response.message())));
                }
            }

            @Override
            public void onFailure(Call<CrmUserApi> call, Throwable t) {
                mMainHandler.post(()-> callback.onComplete(Result.error(-1, t.getMessage())));
            }
        });

    }

    public void getAllLeads(String crmUserId ,int offset,int limit, CompletionHandler<List<LeadApi>> callback){
        Call<List<LeadApi>> call = mClientCallback.getAllLead(crmUserId,String.valueOf(offset),String.valueOf(limit));
        call.enqueue(new Callback<List<LeadApi>>() {
            @Override
            public void onResponse(Call<List<LeadApi>> call, Response<List<LeadApi>> response) {
                if (response.isSuccessful()) {
                    mMainHandler.post(()-> callback.onComplete(Result.success(response.body())));
                } else {
                    mMainHandler.post(()-> callback.onComplete(Result.error(response.code(), response.message())));
                }
            }
            @Override
            public void onFailure(Call<List<LeadApi>> call, Throwable t) {
                mMainHandler.post(()-> callback.onComplete(Result.error(-1, t.getMessage())));
            }
        });

    }

    public void getFollowUpLeads(String crmUserId ,int offset,int limit, CompletionHandler<List<LeadApi>> callback){
        Call<List<LeadApi>> call = mClientCallback.getFollowupLeads(crmUserId,String.valueOf(offset),String.valueOf(limit));
        call.enqueue(new Callback<List<LeadApi>>() {
            @Override
            public void onResponse(Call<List<LeadApi>> call, Response<List<LeadApi>> response) {
                if (response.isSuccessful()) {
                    mMainHandler.post(()-> callback.onComplete(Result.success(response.body())));
                } else {
                    mMainHandler.post(()-> callback.onComplete(Result.error(response.code(), response.message())));
                }
            }
            @Override
            public void onFailure(Call<List<LeadApi>> call, Throwable t) {
                mMainHandler.post(()-> callback.onComplete(Result.error(-1, t.getMessage())));
            }
        });

    }

    public void getLeadStatus(String statusId,CompletionHandler<List<LeadStatusApi>> callback){
        Call<List<LeadStatusApi>> call=mClientCallback.getLeadStatus(statusId);
        call.enqueue(new Callback<List<LeadStatusApi>>() {
            @Override
            public void onResponse(Call<List<LeadStatusApi>> call, Response<List<LeadStatusApi>> response) {
                if (response.isSuccessful()) {
                    mMainHandler.post(()-> callback.onComplete(Result.success(response.body())));
                } else {
                    mMainHandler.post(()-> callback.onComplete(Result.error(response.code(), response.message())));
                }
            }

            @Override
            public void onFailure(Call<List<LeadStatusApi>> call, Throwable t) {
                mMainHandler.post(()-> callback.onComplete(Result.error(-1, t.getMessage())));
            }
        });
    }

}
