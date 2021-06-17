package com.raven.model;

public class Model_Register {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Model_Register(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Model_Register() {
    }

    private String userName;
    private String password;
}
