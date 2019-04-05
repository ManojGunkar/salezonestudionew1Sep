package com.salesfunnel.ApiModelBuilder;

import com.salesfunnel.ApiModel.LeadApiModel;
import com.salesfunnel.ApiModel.PropertyApiModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by decimal on 9/9/18.
 */

public class LeadApiModelBuilder {

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

    private UUID LeadId = UUID.randomUUID();
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
    private UUID AssignedToUserId = UUID.randomUUID();
    private String AssignedToUserName = "";
    private String SubLeadStageName = "";
    private UUID LastModifiedBy = UUID.randomUUID();
    private String LastModifiedDate = "";
    private UUID CreatedBy = UUID.randomUUID();
    private String CreatedDate = "";

    private String DateGroup = "";

    public LeadApiModelBuilder setFirstName(String FirstName) {
        this.FirstName = FirstName;
        return this;
    }

    public LeadApiModelBuilder setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
        return this;
    }

    public LeadApiModelBuilder setLastName(String LastName) {
        this.LastName = LastName;
        return this;
    }

    public LeadApiModelBuilder setMobileNumber(String MobileNumber) {
        this.MobileNumber = MobileNumber;
        return this;
    }

    public LeadApiModelBuilder setLeadStage(String LeadStage) {
        this.LeadStage = LeadStage;
        return this;
    }

    public LeadApiModelBuilder setPotential(String Potential) {
        this.Potential = Potential;
        return this;
    }

    public LeadApiModelBuilder setDealSize(double DealSize) {
        this.DealSize = DealSize;
        return this;
    }

    public LeadApiModelBuilder setAgeGroup(String AgeGroup) {
        this.AgeGroup = AgeGroup;return this;

    }

    public LeadApiModelBuilder setLeadSource(String LeadSource) {
        this.LeadSource = LeadSource;
        return this;
    }

    public LeadApiModelBuilder setEmail(String Email) {
        this.Email = Email;
        return this;
    }

    public LeadApiModelBuilder setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
        return this;
    }

    public LeadApiModelBuilder setLeadId(UUID LeadId) {
        this.LeadId = LeadId;
        return this;
    }

    public LeadApiModelBuilder setTitle(String Title) {
        this.Title = Title;
        return this;
    }

    public LeadApiModelBuilder setGender(String Gender) {
        this.Gender = Gender;
        return this;
    }

    public LeadApiModelBuilder setDob(String Dob) {
        this.Dob = Dob;
        return this;
    }

    public LeadApiModelBuilder setAddressLine1(String AddressLine1) {
        this.AddressLine1 = AddressLine1;
        return this;
    }

    public LeadApiModelBuilder setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
        return this;
    }

    public LeadApiModelBuilder setLandmark(String Landmark) {
        this.Landmark = Landmark;
        return this;
    }

    public LeadApiModelBuilder setCity(String City) {
        this.City = City;
        return this;
    }

    public LeadApiModelBuilder setState(String State) {
        this.State = State;
        return this;
    }

    public LeadApiModelBuilder setCountry(String Country) {
        this.Country = Country;
        return this;
    }

    public LeadApiModelBuilder setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
        return this;
    }

    public LeadApiModelBuilder setOccupation(String Occupation) {
        this.Occupation = Occupation;
        return this;
    }

    public LeadApiModelBuilder setCompany(String Company) {
       this. Company = Company;
        return this;
    }

    public LeadApiModelBuilder setJobTitle(String JobTitle) {
        this.JobTitle = JobTitle;
        return this;
    }

    public LeadApiModelBuilder setSalaryPackageAnnual(String SalaryPackageAnnual) {
        this.SalaryPackageAnnual = SalaryPackageAnnual;
        return this;
    }

    public LeadApiModelBuilder setPANNumber(String PANNumber) {
        this.PANNumber = PANNumber;
        return this;
    }

    public LeadApiModelBuilder setBudgetMin(double BudgetMin) {
        this.BudgetMin = BudgetMin;
        return this;
    }

    public LeadApiModelBuilder setBudgetMax(double BudgetMax) {
        this.BudgetMax = BudgetMax;
        return this;
    }

    public LeadApiModelBuilder setExpectedClosureMonth(String ExpectedClosureMonth) {
        this.ExpectedClosureMonth = ExpectedClosureMonth;
        return this;
    }

    public LeadApiModelBuilder setExpectedClosuerYear(String ExpectedClosuerYear) {
        this.ExpectedClosuerYear = ExpectedClosuerYear;
        return this;
    }

    public LeadApiModelBuilder setReferredByBroker(boolean ReferredByBroker) {
        this.ReferredByBroker = ReferredByBroker;
        return this;
    }

    public LeadApiModelBuilder setBrokerName(String BrokerName) {
        this.BrokerName = BrokerName;
        return this;
    }

    public LeadApiModelBuilder setBrokerMobile(String BrokerMobile) {
        this.BrokerMobile = BrokerMobile;
        return this;
    }

    public LeadApiModelBuilder setBrokerEmail(String BrokerEmail) {
        this.BrokerEmail = BrokerEmail;
        return this;
    }

    public LeadApiModelBuilder setActive(boolean IsActive) {
        this.IsActive = IsActive;
        return this;
    }

    public LeadApiModelBuilder setNotes(String Notes) {
        this.Notes = Notes;
        return this;
    }

    public LeadApiModelBuilder setProperties(ArrayList<PropertyApiModel> Properties) {
        this.Properties = Properties;
        return this;

    }

    public LeadApiModelBuilder setAssignedToUserId(UUID AssignedToUserId) {
        this.AssignedToUserId = AssignedToUserId;
        return this;
    }

    public LeadApiModelBuilder setAssignedToUserName(String AssignedToUserName) {
        this.AssignedToUserName = AssignedToUserName;
        return this;
    }

    public LeadApiModelBuilder setSubLeadStageName(String SubLeadStageName) {
        this.SubLeadStageName = SubLeadStageName;
        return this;
    }

    public LeadApiModelBuilder setLastModifiedBy(UUID LastModifiedBy) {
        this.LastModifiedBy = LastModifiedBy;
        return this;
    }

    public LeadApiModelBuilder setLastModifiedDate(String LastModifiedDate) {
        this.LastModifiedDate = LastModifiedDate;
        return this;
    }

    public LeadApiModelBuilder setCreatedBy(UUID CreatedBy) {
        this.CreatedBy = CreatedBy;
        return this;
    }

    public LeadApiModelBuilder setCreatedDate(String CreatedDate) {
        this.CreatedDate = CreatedDate;
        return this;
    }

    public LeadApiModelBuilder setDateGroup(String DateGroup) {
        this.DateGroup = DateGroup;
        return this;
    }

    public LeadApiModel getLeadApiModel(){

        return new LeadApiModel(FirstName,MiddleName,  LastName, MobileNumber, LeadStage, Potential,
                DealSize, AgeGroup, LeadSource,Email, PhoneNumber,LeadId, Title, Gender, Dob, AddressLine1,
                AddressLine2,Landmark,City, State, Country,PostalCode, Occupation, Company,JobTitle,
                SalaryPackageAnnual,PANNumber, BudgetMin, BudgetMax, ExpectedClosureMonth, ExpectedClosuerYear,
                ReferredByBroker,BrokerName, BrokerMobile,BrokerEmail,IsActive, Notes,Properties,AssignedToUserId,
                AssignedToUserName,SubLeadStageName,LastModifiedBy,LastModifiedDate,CreatedBy,CreatedDate, DateGroup);

    }
}
