package com.chan;

public class Bean {

    private String mUser;
    private String mPassword;

    public Bean(String user, String password) {
        mUser = user;
        mPassword = password;
    }

    public String getUser() {
        return mUser;
    }

    public void setUser(String user) {
        mUser = user;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }
}
