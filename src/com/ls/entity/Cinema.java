package com.ls.entity;

import java.sql.Timestamp;

/**
 * Created by LS on 2017/8/21 12:10.
 * To Be or Not to Be
 */
public class Cinema {
    private int id;
    private int addressId;
    private String cinemaName;
    private Timestamp cinemaCreateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public Timestamp getCinemaCreateDate() {
        return cinemaCreateDate;
    }

    public void setCinemaCreateDate(Timestamp cinemaCreateDate) {
        this.cinemaCreateDate = cinemaCreateDate;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id=" + id +
                ", addressId=" + addressId +
                ", cinemaName='" + cinemaName + '\'' +
                ", cinemaCreateDate=" + cinemaCreateDate +
                '}';
    }
}
