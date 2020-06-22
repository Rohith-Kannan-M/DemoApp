package com.example.demoapp;

import com.google.gson.annotations.SerializedName;

public class courses {
    @SerializedName("courseid")
    private String courseid;
    @SerializedName("coursename")
    private String coursename;
    @SerializedName("duration")
    private String duration;
    @SerializedName("tutor")
    private String tutor;
    @SerializedName("price")
    private String price;
    @SerializedName("coursepic")
    private String coursepic;


    public courses(String courseid, String coursename, String duration, String tutor, String price, String coursepic) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.duration = duration;
        this.tutor = tutor;
        this.price = price;
        this.coursepic = coursepic;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCoursepic() {
        return coursepic;
    }

    public void setCoursepic(String coursepic) {
        this.coursepic = coursepic;
    }
}
