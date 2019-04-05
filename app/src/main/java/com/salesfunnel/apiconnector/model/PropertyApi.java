package com.salesfunnel.apiconnector.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Manoj Kumar on 17-11-2018.
 * Copyright (C) 2018. Global Delight Technologies Pvt. Ltd. All rights reserved.
 */
public class PropertyApi {

    @SerializedName("propertyId")
    @Expose
    private String propertyId;
    @SerializedName("propertyType")
    @Expose
    private String propertyType;
    @SerializedName("propertyName")
    @Expose
    private String propertyName;
    @SerializedName("sideFacing")
    @Expose
    private String sideFacing;
    @SerializedName("areaMin")
    @Expose
    private String areaMin;
    @SerializedName("areaMax")
    @Expose
    private String areaMax;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("bedrooms")
    @Expose
    private Integer bedrooms;
    @SerializedName("bathrooms")
    @Expose
    private Integer bathrooms;
    @SerializedName("furnished")
    @Expose
    private String furnished;
    @SerializedName("constructionType")
    @Expose
    private String constructionType;
    @SerializedName("constructionCompletionYears")
    @Expose
    private String constructionCompletionYears;
    @SerializedName("ageOfConstruction")
    @Expose
    private Integer ageOfConstruction;
    @SerializedName("floorNumber")
    @Expose
    private Integer floorNumber;
    @SerializedName("balconies")
    @Expose
    private Integer balconies;
    @SerializedName("price")
    @Expose
    private Integer price;
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
    @SerializedName("distanceFromHospital")
    @Expose
    private String distanceFromHospital;
    @SerializedName("distanceFromSchool")
    @Expose
    private String distanceFromSchool;
    @SerializedName("distanceFromRailwayStation")
    @Expose
    private String distanceFromRailwayStation;
    @SerializedName("distanceFromAirport")
    @Expose
    private String distanceFromAirport;
    @SerializedName("distanceFromCityCenter")
    @Expose
    private String distanceFromCityCenter;
    @SerializedName("transactionType")
    @Expose
    private String transactionType;
    @SerializedName("leaseOutMonthlyRent")
    @Expose
    private String leaseOutMonthlyRent;
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
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
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("requirementType")
    @Expose
    private String requirementType;
    @SerializedName("budgetMin")
    @Expose
    private String budgetMin;
    @SerializedName("budgetMax")
    @Expose
    private String budgetMax;
    @SerializedName("purpose")
    @Expose
    private String purpose;
    @SerializedName("sourceOfFund")
    @Expose
    private String sourceOfFund;
    @SerializedName("unitNumber")
    @Expose
    private String unitNumber;
    @SerializedName("tower")
    @Expose
    private String tower;

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getSideFacing() {
        return sideFacing;
    }

    public void setSideFacing(String sideFacing) {
        this.sideFacing = sideFacing;
    }

    public String getAreaMin() {
        return areaMin;
    }

    public void setAreaMin(String areaMin) {
        this.areaMin = areaMin;
    }

    public String getAreaMax() {
        return areaMax;
    }

    public void setAreaMax(String areaMax) {
        this.areaMax = areaMax;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    public Integer getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getFurnished() {
        return furnished;
    }

    public void setFurnished(String furnished) {
        this.furnished = furnished;
    }

    public String getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(String constructionType) {
        this.constructionType = constructionType;
    }

    public String getConstructionCompletionYears() {
        return constructionCompletionYears;
    }

    public void setConstructionCompletionYears(String constructionCompletionYears) {
        this.constructionCompletionYears = constructionCompletionYears;
    }

    public Integer getAgeOfConstruction() {
        return ageOfConstruction;
    }

    public void setAgeOfConstruction(Integer ageOfConstruction) {
        this.ageOfConstruction = ageOfConstruction;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getBalconies() {
        return balconies;
    }

    public void setBalconies(Integer balconies) {
        this.balconies = balconies;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public String getDistanceFromHospital() {
        return distanceFromHospital;
    }

    public void setDistanceFromHospital(String distanceFromHospital) {
        this.distanceFromHospital = distanceFromHospital;
    }

    public String getDistanceFromSchool() {
        return distanceFromSchool;
    }

    public void setDistanceFromSchool(String distanceFromSchool) {
        this.distanceFromSchool = distanceFromSchool;
    }

    public String getDistanceFromRailwayStation() {
        return distanceFromRailwayStation;
    }

    public void setDistanceFromRailwayStation(String distanceFromRailwayStation) {
        this.distanceFromRailwayStation = distanceFromRailwayStation;
    }

    public String getDistanceFromAirport() {
        return distanceFromAirport;
    }

    public void setDistanceFromAirport(String distanceFromAirport) {
        this.distanceFromAirport = distanceFromAirport;
    }

    public String getDistanceFromCityCenter() {
        return distanceFromCityCenter;
    }

    public void setDistanceFromCityCenter(String distanceFromCityCenter) {
        this.distanceFromCityCenter = distanceFromCityCenter;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getLeaseOutMonthlyRent() {
        return leaseOutMonthlyRent;
    }

    public void setLeaseOutMonthlyRent(String leaseOutMonthlyRent) {
        this.leaseOutMonthlyRent = leaseOutMonthlyRent;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
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

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getSourceOfFund() {
        return sourceOfFund;
    }

    public void setSourceOfFund(String sourceOfFund) {
        this.sourceOfFund = sourceOfFund;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getTower() {
        return tower;
    }

    public void setTower(String tower) {
        this.tower = tower;
    }

}
