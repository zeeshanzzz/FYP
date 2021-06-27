package com.example.fyp.data.model;

public class ViewUserFeedBack {

    String id,name,date,feedback;

    public ViewUserFeedBack(String id, String name, String date, String feedback) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.feedback = feedback;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
