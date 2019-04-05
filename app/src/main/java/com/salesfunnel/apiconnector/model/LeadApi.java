package com.salesfunnel.apiconnector.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by Manoj Kumar on 17-11-2018.
 * Copyright (C) 2018. Global Delight Technologies Pvt. Ltd. All rights reserved.
 */
public class LeadApi {

    @SerializedName("leadId")
    @Expose
    private String leadId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("middleName")
    @Expose
    private String middleName;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("addressLine1")
    @Expose
    private String addressLine1;
    @SerializedName("addressLine2")
    @Expose
    private String addressLine2;
    @SerializedName("landmark")
    @Expose
    private String landmark;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("postalCode")
    @Expose
    private String postalCode;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("potential")
    @Expose
    private String potential;
    @SerializedName("leadStage")
    @Expose
    private String leadStage;
    @SerializedName("leadSource")
    @Expose
    private String leadSource;
    @SerializedName("occupation")
    @Expose
    private String occupation;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("jobTitle")
    @Expose
    private String jobTitle;
    @SerializedName("salaryPackageAnnual")
    @Expose
    private String salaryPackageAnnual;
    @SerializedName("panNumber")
    @Expose
    private String panNumber;
    @SerializedName("ageGroup")
    @Expose
    private String ageGroup;
    @SerializedName("budgetMin")
    @Expose
    private String budgetMin;
    @SerializedName("budgetMax")
    @Expose
    private String budgetMax;
    @SerializedName("dealSize")
    @Expose
    private long dealSize;
    @SerializedName("expectedClosureMonth")
    @Expose
    private String expectedClosureMonth;
    @SerializedName("expectedClosuerYear")
    @Expose
    private String expectedClosuerYear;
    @SerializedName("referredByBroker")
    @Expose
    private Boolean referredByBroker;
    @SerializedName("brokerName")
    @Expose
    private String brokerName;
    @SerializedName("brokerMobile")
    @Expose
    private String brokerMobile;
    @SerializedName("brokerEmail")
    @Expose
    private String brokerEmail;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("properties")
    @Expose
    private List<PropertyApi> properties = null;
    @SerializedName("assignedToUserId")
    @Expose
    private String assignedToUserId;
    @SerializedName("assignedToUserName")
    @Expose
    private String assignedToUserName;
    @SerializedName("subLeadStageName")
    @Expose
    private String subLeadStageName;
    @SerializedName("lastModifiedBy")
    @Expose
    private String lastModifiedBy;
    @SerializedName("lastModifiedDate")
    @Expose
    private String lastModifiedDate;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("createdDate")
    @Expose
    private String createdDate;
    @SerializedName("dateGroup")
    @Expose
    private String dateGroup;
    @SerializedName("followupDateTime")
    @Expose
    private String followupDateTime;
    @SerializedName("nextFollowupDateTime")
    @Expose
    private String nextFollowupDateTime;
    @SerializedName("meetingDateTime")
    @Expose
    private String meetingDateTime;
    @SerializedName("meetingStatus")
    @Expose
    private String meetingStatus;
    @SerializedName("followUpRemark")
    @Expose
    private String followUpRemark;

    @SerializedName("totalLeadCount")
    @Expose
    private int totalLeadCount;

    public String getLeadId() {
        return leadId;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPotential() {
        return potential;
    }

    public void setPotential(String potential) {
        this.potential = potential;
    }

    public String getLeadStage() {
        return leadStage;
    }

    public void setLeadStage(String leadStage) {
        this.leadStage = leadStage;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSalaryPackageAnnual() {
        return salaryPackageAnnual;
    }

    public void setSalaryPackageAnnual(String salaryPackageAnnual) {
        this.salaryPackageAnnual = salaryPackageAnnual;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getBudgetMin() {
        return budgetMin;
    }

    public void setBudgetMin(String budgetMin) {
        this.budgetMin = budgetMin;
    }

    public String getBudgetMax() {
        return budgetMax;
    }

    public void setBudgetMax(String budgetMax) {
        this.budgetMax = budgetMax;
    }

    public long getDealSize() {
        return dealSize;
    }

    public void setDealSize(long dealSize) {
        this.dealSize = dealSize;
    }

    public String getExpectedClosureMonth() {
        return expectedClosureMonth;
    }

    public void setExpectedClosureMonth(String expectedClosureMonth) {
        this.expectedClosureMonth = expectedClosureMonth;
    }

    public String getExpectedClosuerYear() {
        return expectedClosuerYear;
    }

    public void setExpectedClosuerYear(String expectedClosuerYear) {
        this.expectedClosuerYear = expectedClosuerYear;
    }

    public Boolean getReferredByBroker() {
        return referredByBroker;
    }

    public void setReferredByBroker(Boolean referredByBroker) {
        this.referredByBroker = referredByBroker;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getBrokerMobile() {
        return brokerMobile;
    }

    public void setBrokerMobile(String brokerMobile) {
        this.brokerMobile = brokerMobile;
    }

    public String getBrokerEmail() {
        return brokerEmail;
    }

    public void setBrokerEmail(String brokerEmail) {
        this.brokerEmail = brokerEmail;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<PropertyApi> getProperties() {
        return properties;
    }

    public void setProperties(List<PropertyApi> properties) {
        this.properties = properties;
    }

    public String getAssignedToUserId() {
        return assignedToUserId;
    }

    public void setAssignedToUserId(String assignedToUserId) {
        this.assignedToUserId = assignedToUserId;
    }

    public String getAssignedToUserName() {
        return assignedToUserName;
    }

    public void setAssignedToUserName(String assignedToUserName) {
        this.assignedToUserName = assignedToUserName;
    }

    public String getSubLeadStageName() {
        return subLeadStageName;
    }

    public void setSubLeadStageName(String subLeadStageName) {
        this.subLeadStageName = subLeadStageName;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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

    public String getDateGroup() {
        return dateGroup;
    }

    public void setDateGroup(String dateGroup) {
        this.dateGroup = dateGroup;
    }

    public String getFollowupDateTime() {
        return followupDateTime;
    }

    public void setFollowupDateTime(String followupDateTime) {
        this.followupDateTime = followupDateTime;
    }

    public String getNextFollowupDateTime() {
        return nextFollowupDateTime;
    }

    public void setNextFollowupDateTime(String nextFollowupDateTime) {
        this.nextFollowupDateTime = nextFollowupDateTime;
    }

    public String getMeetingDateTime() {
        return meetingDateTime;
    }

    public void setMeetingDateTime(String meetingDateTime) {
        this.meetingDateTime = meetingDateTime;
    }

    public String getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(String meetingStatus) {
        this.meetingStatus = meetingStatus;
    }

    public String getFollowUpRemark() {
        return followUpRemark;
    }

    public void setFollowUpRemark(String followUpRemark) {
        this.followUpRemark = followUpRemark;
    }


    public int getTotalLeadCount() {
        return totalLeadCount;
    }

    public void setTotalLeadCount(int totalLeadCount) {
        this.totalLeadCount = totalLeadCount;
    }
}
