package com.salesfunnel.apiconnector.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manoj Kumar on 17-11-2018.
 * Copyright (C) 2018. Global Delight Technologies Pvt. Ltd. All rights reserved.
 */
public class LeadStatusApi {

    @SerializedName("leadStatusId")
    @Expose
    private Integer leadStatusId;
    @SerializedName("leadStatusName")
    @Expose
    private String leadStatusName;
    @SerializedName("parentLeadStatusId")
    @Expose
    private Integer parentLeadStatusId;
    @SerializedName("sortOrder")
    @Expose
    private Integer sortOrder;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;

    public Integer getLeadStatusId() {
        return leadStatusId;
    }

    public void setLeadStatusId(Integer leadStatusId) {
        this.leadStatusId = leadStatusId;
    }

    public String getLeadStatusName() {
        return leadStatusName;
    }

    public void setLeadStatusName(String leadStatusName) {
        this.leadStatusName = leadStatusName;
    }

    public Integer getParentLeadStatusId() {
        return parentLeadStatusId;
    }

    public void setParentLeadStatusId(Integer parentLeadStatusId) {
        this.parentLeadStatusId = parentLeadStatusId;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
