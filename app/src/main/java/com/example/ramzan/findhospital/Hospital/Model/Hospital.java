package com.example.ramzan.findhospital.Hospital.Model;

public class Hospital {

    private String hospitalName;
    private String address;
    private String link;

    public Hospital(String hospitalName, String address, String link) {
        this.hospitalName = hospitalName;
        this.address = address;
        this.link = link;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
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
