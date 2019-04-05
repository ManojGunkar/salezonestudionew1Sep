package com.salesfunnel.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.salesfunnel.apiconnector.model.CrmUserApi;


/**
 * Created by Manoj Kumar on 18-11-2018.
 */
public class UserCredentials {

    public final static String KEY_USERID = "KEY_USERID";
    public final static String KEY_FNAME = "KEY_FNAME";
    public final static String KEY_LNAME = "KEY_LNAME";
    public final static String KEY_DOB = "KEY_DOB";
    public final static String KEY_EMAIL = "KEY_EMAIL";
    public final static String KEY_MOBILE = "KEY_MOBILE";


    public static final int MODE = Context.MODE_PRIVATE;
    private final static String USER_CREDENTIALS = "USER_CREDENTIALS";
    private static UserCredentials credentials;
    private Context mContext;
    private SharedPreferences mSharedPreferences;

    private UserCredentials(Context context) {
        this.mContext = context;
        this.mSharedPreferences = context.getSharedPreferences(USER_CREDENTIALS, MODE);

    }

    public static UserCredentials getCredentials(Context context) {
        if (credentials == null) credentials = new UserCredentials(context);
        return credentials;
    }

    private SharedPreferences.Editor getEditor() {
        return mSharedPreferences.edit();
    }

    public void storeLogin(CrmUserApi details) {
        SharedPreferences.Editor editor = getEditor();
        if (details!=null){
            editor.putString(KEY_USERID, details.getUserId());
            editor.putString(KEY_FNAME, details.getFirstName());
            editor.putString(KEY_LNAME, details.getLastName());
            editor.putString(KEY_MOBILE, details.getMobileNumber());
            editor.putString(KEY_DOB, details.getDob());
            editor.putString(KEY_EMAIL, details.getEmail());
        }else {
            editor.putString(KEY_USERID, null);
            editor.putString(KEY_FNAME, null);
            editor.putString(KEY_LNAME, null);
            editor.putString(KEY_MOBILE, null);
            editor.putString(KEY_DOB, null);
            editor.putString(KEY_EMAIL, null);
        }

        editor.apply();
    }

    public CrmUserApi getUserDetails(){
        String userId=mSharedPreferences.getString(KEY_USERID,null);
        String firstName=mSharedPreferences.getString(KEY_FNAME,null);
        String lastName=mSharedPreferences.getString(KEY_LNAME,null);
        String mobile=mSharedPreferences.getString(KEY_MOBILE,null);
        String dob=mSharedPreferences.getString(KEY_DOB,null);
        String email=mSharedPreferences.getString(KEY_EMAIL,null);

        CrmUserApi crmUserApi=new CrmUserApi();
        crmUserApi.setUserId(userId);
        crmUserApi.setFirstName(firstName);
        crmUserApi.setLastName(lastName);
        crmUserApi.setMobileNumber(mobile);
        crmUserApi.setDob(dob);
        crmUserApi.setEmail(email);

        return crmUserApi;
    }

    public boolean isUserLogged() {
        return mSharedPreferences.contains(KEY_USERID) ? true : false;
    }

}
