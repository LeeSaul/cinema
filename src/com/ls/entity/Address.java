package com.ls.entity;

/**
 * Created by LS on 2017/8/21 12:05.
 * To Be or Not to Be
 */
public class Address {
    private int id;
    private String addressProvince;
    private String addressCity;
    private String addressCounty;
    private String addressRoad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCounty() {
        return addressCounty;
    }

    public void setAddressCounty(String addressCounty) {
        this.addressCounty = addressCounty;
    }

    public String getAddressRoad() {
        return addressRoad;
    }

    public void setAddressRoad(String addressRoad) {
        this.addressRoad = addressRoad;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressProvince='" + addressProvince + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressCounty='" + addressCounty + '\'' +
                ", addressRoad='" + addressRoad + '\'' +
                '}';
    }
}
