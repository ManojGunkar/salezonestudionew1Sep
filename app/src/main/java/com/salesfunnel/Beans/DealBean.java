package com.salesfunnel.Beans;

/**
 * Created by krishan on 24/06/2018 AD.
 */

public class DealBean {

    private String title , compName , stage, price , time, id;
    public DealBean(String title , String compName , String stage , String price , String time, String id){
        this.time = time;
        this.title = title;
        this.compName = compName;
        this.price = price;
        this.stage = stage;
        this.id = id;
    }

    public String getId(){return this.id;}
    public String getPrice(){return this.price;}
    public String getTime(){return this.time;}
    public String getTitle(){return this.title;}
    public String getStage(){return this.stage;}
    public String getCompName(){return this.compName;}
}
