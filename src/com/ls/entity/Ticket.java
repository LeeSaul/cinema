package com.ls.entity;

import java.sql.Timestamp;

/**
 * Created by LS on 2017/8/21 12:21.
 * To Be or Not to Be
 */
public class Ticket {
    private int id;
    private int screeningId;   //场次id
    private int userId;
    private int seatNum;    //座位号（唯一）
    private Timestamp ticketCreateDate; //影票创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public Timestamp getTicketCreateDate() {
        return ticketCreateDate;
    }

    public void setTicketCreateDate(Timestamp ticketCreateDate) {
        this.ticketCreateDate = ticketCreateDate;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", screeningId=" + screeningId +
                ", userId=" + userId +
                ", seatNum=" + seatNum +
                ", ticketCreateDate=" + ticketCreateDate +
                '}';
    }
}

