package com.example.fyp.data.model;

public class ApproveBusiness {

    String id,name,email,workType,city,address,license_no,status="";

    public ApproveBusiness() {
    }

    public ApproveBusiness(String id, String name, String email, String workType, String city, String address, String license_no, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.workType = workType;
        this.city = city;
        this.address = address;
        this.license_no = license_no;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLicense_no() {
        return license_no;
    }

    public void setLicense_no(String license_no) {
        this.license_no = license_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
