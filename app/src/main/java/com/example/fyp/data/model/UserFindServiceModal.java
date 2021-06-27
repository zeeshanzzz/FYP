package com.example.fyp.data.model;

public class UserFindServiceModal {

    private String id,
            mechenicName,
            email,
            workType,
            city,
            address,
            phoneNumber;

    public UserFindServiceModal() {
    }

    public UserFindServiceModal(String id, String mechenicName, String email, String workType, String city, String address, String phoneNumber) {
        this.id = id;
        this.mechenicName = mechenicName;
        this.email = email;
        this.workType = workType;
        this.city = city;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMechenicName() {
        return mechenicName;
    }

    public void setMechenicName(String mechenicName) {
        this.mechenicName = mechenicName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
