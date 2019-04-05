package com.salesfunnel.apiconnector.contoller;

import com.salesfunnel.apiconnector.model.CrmUserApi;
import com.salesfunnel.apiconnector.model.LeadApi;
import com.salesfunnel.apiconnector.model.LeadStatusApi;
import com.salesfunnel.apiconnector.model.PropertyApi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Manoj Kumar on 16-11-2018.
 * Copyright (C) 2018. Global Delight Technologies Pvt. Ltd. All rights reserved.
 */
public class ApiRequestController {

    private static final String BASE_API = "https://leadapidemo.azurewebsites.net/";

    private static final String CRM_USER_API = "api/CrmUser/";
    private static final String LEAD_API = "api/Lead/";
    private static final String LEAD_STATUS_API = "api/LeadStatusLookup/";
    private static final String PROPERTY_API = "api/Property/";
    private static final String TASK_API = "api/Tasks/";
    private static final String FOLLOW_UP_API = "Followup/";

    private static final String LOGIN_API = "Login";
    private static final String USER_EXISTS = "UserExists/";
    private static final String ALL = "All/";
    private static final String SAVE = "Save";
    private static final String DELETE = "Delete/";
    private static final String SEARCH = "Search";
    private static final String EDIT_UPDATE = "Edit";


    private final static HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    public static RequestCallback requestCallback;
    private static OkHttpClient client;


    public static RequestCallback getClient() {

        if (client == null) {
            client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();
        }

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return retrofit.create(RequestCallback.class);
    }

    public interface RequestCallback {

        //CrmUserApi

        @POST(CRM_USER_API + LOGIN_API)
        Call<CrmUserApi> login(@Body CrmUserApi body);

        @GET(CRM_USER_API + USER_EXISTS + "{username}")
        Call<Boolean> isUserExists(@Path(value = "username", encoded = true) String username);

        @GET(CRM_USER_API + ALL + "{crmUserId}")
        Call<List<CrmUserApi>> getAllCrmUsers(@Path(value = "crmUserId", encoded = true) String crmUserId);

        @GET(CRM_USER_API + "{crmUserId}")
        Call<LeadApi> getCrmUserById(@Path(value = "crmUserId", encoded = true) String crmUserId);

        @POST(CRM_USER_API + SAVE)
        Call<CrmUserApi> createCrmUser(@Body CrmUserApi body);

        @POST(CRM_USER_API + EDIT_UPDATE)
        Call<CrmUserApi> updateCrmUser(@Body CrmUserApi body);

        @POST(CRM_USER_API + DELETE + "{id}")
        Call<CrmUserApi> deleteCrmUser(@Path(value = "id", encoded = true) String id);

        @POST(CRM_USER_API + SEARCH)
        Call<CrmUserApi> searchCrmUser(@Body CrmUserApi body);

        //LeadApi

        @GET(LEAD_API + ALL + "{id}/{offset}/{limit}")
        Call<List<LeadApi>> getAllLead(
                @Path(value = "id", encoded = true) String crmUserId,
                @Path(value = "offset", encoded = true) String offSet,
                @Path(value = "limit", encoded = true) String limit);

        @GET(LEAD_API + ALL + "{id}/" + FOLLOW_UP_API + "{offset}/{limit}")
        Call<List<LeadApi>> getFollowupLeads(
                @Path(value = "id", encoded = true) String crmUserId,
                @Path(value = "offset", encoded = true) String offSet,
                @Path(value = "limit", encoded = true) String limit);


        @GET(LEAD_API + "{id}")
        Call<LeadApi> getLeadById(@Path(value = "id", encoded = true) String leadId);

        @POST(LEAD_API + SAVE)
        Call<LeadApi> createLead(@Body LeadApi body);

        @POST(LEAD_API + EDIT_UPDATE)
        Call<LeadApi> updateLead(@Body LeadApi body);

        @POST(LEAD_API + DELETE + "{id}")
        Call<LeadApi> deleteLead(@Path(value = "id", encoded = true) String leadId);

        @POST(LEAD_API + SEARCH)
        Call<LeadApi> searchLead(@Body LeadApi body);

        @POST(LEAD_API + "GetLeadReport")
        Call<LeadApi> getLeadReport(@Body LeadApi body);

        @GET(LEAD_STATUS_API + ALL + "{id}")
        Call<List<LeadStatusApi>> getAllLeadStatus(@Path(value = "id", encoded = true) String leadStatusId);

        @GET(LEAD_STATUS_API + ALL + "{id}")
        Call<List<LeadStatusApi>> getLeadStatus(@Path(value = "id", encoded = true) String leadStatusId);

        //PropertyApi

        @GET(PROPERTY_API + ALL)
        Call<List<PropertyApi>> getAllProperty();

        @GET(PROPERTY_API + "{id}")
        Call<PropertyApi> getPropertyById(@Path(value = "id", encoded = true) String propertyId);

        @POST(PROPERTY_API + SAVE)
        Call<PropertyApi> createProperty(@Body PropertyApi body);

        @POST(PROPERTY_API + EDIT_UPDATE)
        Call<PropertyApi> updateProperty(@Body PropertyApi body);

        @POST(PROPERTY_API + DELETE + "{id}")
        Call<PropertyApi> deleteProperty(@Path(value = "id", encoded = true) String propertyId);

        //TaskApi


    }

}
