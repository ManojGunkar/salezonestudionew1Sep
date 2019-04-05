package com.salesfunnel.Beans;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class LeadBean {

    private String name , job , stage , location , lastseen , call , mail , id , notes, dealSize;

    public LeadBean(String name , String job , String stage , String location , String lastseen, String call , String mail, String id,
                    String notes, String dealSize){
        this.name = name ;
        this.job = job;
        this.stage = stage;
        this.location = location;
        this.lastseen = lastseen;
        this.call = call;
        this.id = id;
        this.mail = mail;
        this.notes = notes;
        this.dealSize = dealSize;
    }

    public String getNotes(){return this.notes;}
    public String getPhone(){return this.call;}
    public String getMail(){return this.mail;}
    public String getId(){return this.id;}
    public String getLastseen(){return this.lastseen;}
    public String getLocation(){return this.location;}
    public String getJob(){return this.job;}
    public String getStage(){return this.stage;}
    public String getName(){return this.name;}
    public String getDealSize() {return this.dealSize;}
}
