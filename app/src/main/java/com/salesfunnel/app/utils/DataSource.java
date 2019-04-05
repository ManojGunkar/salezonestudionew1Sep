package com.salesfunnel.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by krishan on 28/05/2018 AD.
 */

public class DataSource {
    Context ctx;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public DataSource(Context ctx){
        this.ctx = ctx;
        pref = ctx.getApplicationContext().getSharedPreferences("MyPref", 0);
        editor = pref.edit();
    }

    public void saveValues(String key , String value){
        editor.putString(key , value);
        editor.commit();
    }

    public String getValue(String key){
        if(pref!= null)
           return pref.getString(key ,"");
        return "";
    }

    public void deleteKey(String key){
        editor.remove(key);
        editor.commit();
    }

    public void deleteAll(){
        editor.clear();
        editor.commit();
    }


}
