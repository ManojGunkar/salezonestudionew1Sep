package com.salesfunnel.ApiModel;

/**
 * Created by Ankita on 28/8/18.
 */

public class CrmUserApiModel {

    private String UserName;
    private String UserPassword;

    public CrmUserApiModel(String UserName, String UserPassword) {
        this.UserName = UserName;
        this.UserPassword = UserPassword;
    }

    public String getUsername() {
        return UserName;
    }

    public void setUsername(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return UserPassword;
    }

    public void setPassword(String password) {
        this.UserPassword = UserPassword;
    }
}
