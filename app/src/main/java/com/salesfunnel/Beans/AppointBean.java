package com.salesfunnel.Beans;

/**
 * Created by krishan on 23/06/2018 AD.
 */

public class AppointBean {

    public String title, author , dateTime , id;
    public AppointBean(String title , String author , String dateTime, String id){
        this.title = title;
        this.author = author;
        this.dateTime = dateTime;
        this.id = id;
    }

    public String getAppointTitle(){return this.title;}
    public String getAuthor(){return this.author;}
    public String getDateTime(){return this.dateTime;}
    public String getId(){return this.id;}
}

