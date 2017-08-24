package com.ls.entity;

/**
 * Created by LS on 2017/8/23 14:36.
 * To Be or Not to Be
 */
public class AllEntity {
    private Address address;
    private Cinema cinema;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    @Override
    public String toString() {
        return "AllEntity{" +
                "address=" + address +
                ", cinema=" + cinema +
                '}';
    }
}
