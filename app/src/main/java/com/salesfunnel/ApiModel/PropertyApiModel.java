package com.salesfunnel.ApiModel;

import java.util.UUID;

/**
 * Created by decimal on 28/8/18.
 */

public class PropertyApiModel {

    public UUID PropertyId = UUID.randomUUID();
    public String PropertyType = "";
    public String PropertyName = "";
    public String SideFacing = "";
    public String AreaMin = "";
    public String AreaMax = "";
    public String Unit = "";
    public int Bedrooms;
    public int Bathrooms;
    public String Furnished = "";
    public String ConstructionType = "";
    public String ConstructionCompletionYears = "";
    public int AgeOfConstruction;
    public int FloorNumber;
    public int Balconies;
    public double Price;
    public String AddressLine1 = "";
    public String AddressLine2 = "";
    public String Landmark = "";
    public String City = "";
    public String State = "";
    public String Country = "";
    public String PostalCode = "";
    public double DistanceFromHospital;
    public double DistanceFromSchool;
    public double DistanceFromRailwayStation;
    public double DistanceFromAirport;
    public double DistanceFromCityCenter;
    public String TransactionType = "";
    public double LeaseOutMonthlyRent;
    public boolean IsActive;
    public UUID LastModifiedBy = UUID.randomUUID();
    public String LastModifiedDate = "";
    public UUID CreatedBy = UUID.randomUUID();
    public String CreatedDate = "";
    public String Category = "";
    public String RequirementType = "";
    public double BudgetMin;
    public double BudgetMax;
    public String Purpose = "";
    public String SourceOfFund = "";
    public String UnitNumber = "";
    public String Tower = "";
}
