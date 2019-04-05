package com.salesfunnel.Beans;

/**
 * Created by krishan on 17/06/2018 AD.
 */

public class ContactBean {

    private String name , job , amount , location , lastseen , call , mail , id;

    public ContactBean(String name , String job , String amount , String location , String lastseen, String call , String mail, String id){
        this.name = name ;
        this.job = job;
        this.amount = amount;
        this.location = location;
        this.lastseen = lastseen;
        this.call = call;
        this.id = id;
        this.mail = mail;
    }


    public String getPhone(){return this.call;}
    public String getMail(){return this.mail;}
    public String getId(){return this.id;}
    public String getLastseen(){return this.lastseen;}
    public String getLocation(){return this.location;}
    public String getJob(){return this.job;}
    public String getAmount(){return this.amount;}
    public String getName(){return this.name;}
}
