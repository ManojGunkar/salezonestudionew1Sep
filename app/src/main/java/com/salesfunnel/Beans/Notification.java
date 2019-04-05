package com.salesfunnel.Beans;

/**
 * Created by krishan on 19/06/2018 AD.
 */

public class Notification {

    String title , body , time  , id;
    public Notification(String title , String body , String time , String id){
        this.title = title;
        this.body = body;
        this.time = time;
        this.id = id;
    }

    public String getTitle(){return this.title;}
    public String getBody(){return this.body;}
    public String getTime(){return this.time;}
    public String getId(){return this.id;}

}
