package com.example.demo;

public class Ansat {

    private String stilling;
    private String userName;
    private String password;


    public Ansat(String stilling, String userName, String password) {

        this.stilling = stilling;
        this.userName = userName;
        this.password = password;

    }


    public String getStilling() { return stilling; }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

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


}
