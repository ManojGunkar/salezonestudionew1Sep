package com.salesfunnel.Beans;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class AccountBean {

    private String orgname , loc , ownername , time , price , id , call;

    public AccountBean(String orgname , String loc , String ownername , String time , String price , String id , String call){
        this.orgname = orgname;
        this.loc = loc;
        this.ownername = ownername;
        this.time = time;
        this.price = price;
        this.id = id;
        this.call = call;
    }

    public String getOrgName(){return this.orgname;}
    public String getLocations(){return this.loc;}
    public String getOwnerName(){return this.ownername;}
    public String getTime(){return this.time;}
    public String getPrice(){return this.price;}
    public String getId(){return this.id;}
    public String getCall(){return this.call;}

}
