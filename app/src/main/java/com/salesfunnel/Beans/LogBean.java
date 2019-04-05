package com.salesfunnel.Beans;

/**
 * Created by krishan on 24/06/2018 AD.
 */

public class LogBean {

    private String type , outcome , notes , time , id;

    public LogBean(String type , String outcome , String notes , String time , String id){
        this.type = type;
        this.outcome = outcome;
        this.notes = notes;
        this.time = time;
        this.id = id;
    }

    public String getType(){return this.type;}
    public String getOutCome(){return this.outcome;}
    public String getNotes(){return this.notes;}
    public String getTime(){return this.time;}
    public String getId(){return this.id;}
}
