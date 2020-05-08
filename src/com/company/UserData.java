package com.company;

import java.io.Serializable;

public class UserData implements Serializable {
    private String login;
    private String password;
    private String address;
    private String telephoneNumber;

    public UserData() {
    }

    public UserData(String login, String password, String address, String telephoneNumber) {
        this.login = login;
        this.password = password;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
