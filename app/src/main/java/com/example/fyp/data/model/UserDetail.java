package com.example.fyp.data.model;

public class UserDetail {

    String id,name,mobileNumber,city;

    public UserDetail() {
    }

    public UserDetail(String id, String name, String mobileNumber, String city) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
