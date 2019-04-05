package com.salesfunnel.ApiModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Ankita on 28/8/18.
 */

public class LeadApiModel {

    private String FirstName = "";
    private String MiddleName = "";
    private String LastName = "";
    private String MobileNumber = "";
    private String LeadStage = "";    // FinalStatus
    private String Potential = "";    // SubStatus
    private double DealSize;
    private String AgeGroup = "";
    private String LeadSource = "";
    private String Email = "";
    private String PhoneNumber = "";

    private UUID LeadId;
    private String Title = "";
    private String Gender = "";
    private String Dob = "";
    private String AddressLine1 = "";
    private String AddressLine2 = "";
    private String Landmark = "";
    private String City = "";
    private String State = "";
    private String Country = "";
    private String PostalCode = "";
    private String Occupation = "";
    private String Company = "";
    private String JobTitle = "";
    private String SalaryPackageAnnual = "";
    private String PANNumber = "";
    private double BudgetMin;
    private double BudgetMax;
    private String ExpectedClosureMonth = "";
    private String ExpectedClosuerYear = "";
    private boolean ReferredByBroker;
    private String BrokerName = "";
    private String BrokerMobile = "";
    private String BrokerEmail = "";
    private boolean IsActive;
    private String Notes = "";
    private ArrayList<PropertyApiModel> Properties = new ArrayList<>();
    private UUID AssignedToUserId;
    private String AssignedToUserName = "";
    private String SubLeadStageName = "";
    private UUID LastModifiedBy;
    private String LastModifiedDate = "";
    private UUID CreatedBy;
    private String CreatedDate = "";

    private String DateGroup = "";


    public LeadApiModel(String FirstName, String MiddleName, String LastName, String MobileNumber, String LeadStage, String Potential,
                        double DealSize, String AgeGroup, String LeadSource, String Email, String PhoneNumber, UUID LeadId, String Title, String Gender,
                        String Dob, String AddressLine1, String AddressLine2, String Landmark,String City, String State,
                        String Country, String PostalCode, String Occupation, String Company,String JobTitle, String SalaryPackageAnnual,
                        String PANNumber, double BudgetMin, double BudgetMax,String ExpectedClosureMonth,String ExpectedClosuerYear,
                        boolean ReferredByBroker,String BrokerName, String BrokerMobile,String BrokerEmail, boolean IsActive,
                        String Notes,ArrayList<PropertyApiModel> Properties, UUID AssignedToUserId, String AssignedToUserName, String SubLeadStageName,
                        UUID LastModifiedBy,String LastModifiedDate,UUID CreatedBy, String CreatedDate, String DateGroup) {

        this.FirstName = FirstName;
        this.MiddleName = MiddleName;
        this.LastName = LastName;
        this.MobileNumber = MobileNumber;
        this.LeadStage = LeadStage;
        this.Potential = Potential;
        this.DealSize = DealSize;
        this.AgeGroup = AgeGroup;
        this.LeadSource = LeadSource;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.LeadId = LeadId;
        this.Title = Title;
        this.Gender = Gender;
        this.Dob = Dob;
        this.AddressLine1 = AddressLine1;
        this.AddressLine2 = AddressLine2;
        this.Landmark = Landmark;
        this.City = City;
        this.State = State;
        this.Country = Country;
        this.PostalCode = PostalCode;
        this.Occupation = Occupation;
        this.Company = Company;
        this.JobTitle = JobTitle;
        this.SalaryPackageAnnual = SalaryPackageAnnual;
        this.PANNumber = PANNumber;
        this.BudgetMin = BudgetMin;
        this.BudgetMax = BudgetMax;
        this.ExpectedClosureMonth = ExpectedClosureMonth;
        this.ExpectedClosuerYear = ExpectedClosuerYear;
        this.ReferredByBroker = ReferredByBroker;
        this.BrokerName = BrokerName;
        this.BrokerMobile = BrokerMobile;
        this.BrokerEmail = BrokerEmail;
        this.IsActive = IsActive;
        this.Notes = Notes;
        this.Properties = Properties;
        this.AssignedToUserId = AssignedToUserId;
        this.AssignedToUserName = AssignedToUserName;
        this.SubLeadStageName = SubLeadStageName;
        this.LastModifiedBy = LastModifiedBy;
        this.LastModifiedDate = LastModifiedDate;
        this.CreatedBy = CreatedBy;
        this.CreatedDate = CreatedDate;
        this.DateGroup = DateGroup;
    }

}
