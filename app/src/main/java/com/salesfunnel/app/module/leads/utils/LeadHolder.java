package com.salesfunnel.app.module.leads.utils;

import android.content.Context;

import com.salesfunnel.apiconnector.model.LeadApi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manoj Kumar on 19-11-2018.
 * Copyright (C) 2018. Global Delight Technologies Pvt. Ltd. All rights reserved.
 */
public class LeadHolder {

    private List<LeadApi> mLeads=new ArrayList<>();

    private static LeadHolder instance = null;
    public static LeadHolder getInstance() {
        if (instance == null) {
            instance = new LeadHolder();
        }
        return instance;
    }

    private LeadHolder() {
    }

    public void saveLeads(List<LeadApi> leads){
        this.mLeads=leads;
    }

    public List<LeadApi> getLeads(){
        return this.mLeads;
    }
}
