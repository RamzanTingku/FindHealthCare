package com.example.ramzan.findhospital.Pharmecy.Model;

public class Pharmecy {

    private String pharmecyName;
    private String address;
    private String link;

    public Pharmecy(String pharmecyName, String address, String link) {
        this.pharmecyName = pharmecyName;
        this.address = address;
        this.link = link;
    }

    public String getPharmecyName() {
        return pharmecyName;
    }

    public void setPharmecyName(String pharmecyName) {
        this.pharmecyName = pharmecyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
