package com.example.demo;

public class Ansat {
    private String name;
    private String lastName;
    private String stilling;
    private String userName;
    private String password;
    private int phoneNr;

    public Ansat(String name, String lastName, String stilling, String userName, String password, int phoneNr) {
        this.name = name;
        this.lastName = lastName;
        this.stilling = stilling;
        this.userName = userName;
        this.password = password;
        this.phoneNr = phoneNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStilling() {
        return stilling;
    }

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

    public int getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(int phoneNr) {
        this.phoneNr = phoneNr;
    }
}
