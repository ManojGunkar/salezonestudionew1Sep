package com.salesfunnel.Beans;

/**
 * Created by krishan on 23/06/2018 AD.
 */

public class NoteBean {

    public String text, author , time , id;
    public NoteBean(String text , String author , String time, String id){
        this.text = text;
        this.author = author;
        this.time = time;
        this.id = id;
    }

    public String getText(){return this.text;}
    public String getAuthor(){return this.author;}
    public String getTime(){return this.time;}
    public String getId(){return this.id;}
}

