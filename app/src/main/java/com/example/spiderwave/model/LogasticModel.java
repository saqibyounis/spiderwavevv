package com.example.spiderwave.model;

public class LogasticModel {

    String dropaddress;
    String pickaddress;
    String phone;
    String time;
    String date;

    public LogasticModel(String dropaddress, String pickaddress, String phone, String time, String date) {
        this.dropaddress = dropaddress;
        this.pickaddress = pickaddress;
        this.phone = phone;
        this.time = time;
        this.date = date;
    }

    public String getDropaddress() {
        return dropaddress;
    }

    public void setDropaddress(String dropaddress) {
        this.dropaddress = dropaddress;
    }

    public String getPickaddress() {
        return pickaddress;
    }

    public void setPickaddress(String pickaddress) {
        this.pickaddress = pickaddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
