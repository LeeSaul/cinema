package com.ls.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by LS on 2017/8/21 12:12.
 * To Be or Not to Be
 */
public class Screening implements Serializable{
    private int id;
    private int cinemaId;
    private int movieId;
    private int hallNum; //厅号
    private int seatCapacity; //座位总数
    private int sellNum; //售出票数
    private Timestamp screeningCreateDate; //创建
    private Timestamp screeningStartDate; //开始时间
    private Timestamp screeningEndDate;   //结束时间
    private String screeningStatus;       //场次状态
    private Timestamp screeningCancleDate; //取消时间

    public int getId() {
        return id;
    }

    public Screening() {
    }

    public Screening(int cinemaId, int movieId, int hallNum, int seatCapacity, int sellNum, Timestamp screeningStartDate, Timestamp screeningEndDate, String screeningStatus, Timestamp screeningCancleDate) {
        this.cinemaId = cinemaId;
        this.movieId = movieId;
        this.hallNum = hallNum;
        this.seatCapacity = seatCapacity;
        this.sellNum = sellNum;
        this.screeningStartDate = screeningStartDate;
        this.screeningEndDate = screeningEndDate;
        this.screeningStatus = screeningStatus;
        this.screeningCancleDate = screeningCancleDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getHallNum() {
        return hallNum;
    }

    public void setHallNum(int hallNum) {
        this.hallNum = hallNum;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public int getSellNum() {
        return sellNum;
    }

    public void setSellNum(int sellNum) {
        this.sellNum = sellNum;
    }

    public Timestamp getScreeningCreateDate() {
        return screeningCreateDate;
    }

    public void setScreeningCreateDate(Timestamp screeningCreateDate) {
        this.screeningCreateDate = screeningCreateDate;
    }

    public Timestamp getScreeningStartDate() {
        return screeningStartDate;
    }

    public void setScreeningStartDate(Timestamp screeningStartDate) {
        this.screeningStartDate = screeningStartDate;
    }

    public Timestamp getScreeningEndDate() {
        return screeningEndDate;
    }

    public void setScreeningEndDate(Timestamp screeningEndDate) {
        this.screeningEndDate = screeningEndDate;
    }

    public String getScreeningStatus() {
        return screeningStatus;
    }

    public void setScreeningStatus(String screeningStatus) {
        this.screeningStatus = screeningStatus;
    }

    public Timestamp getScreeningCancleDate() {
        return screeningCancleDate;
    }

    public void setScreeningCancleDate(Timestamp screeningCancleDate) {
        this.screeningCancleDate = screeningCancleDate;
    }

    @Override
    public String toString() {
        return "Screening{" +
                "id=" + id +
                ", cinemaId=" + cinemaId +
                ", movieId=" + movieId +
                ", hallNum=" + hallNum +
                ", seatCapacity=" + seatCapacity +
                ", sellNum=" + sellNum +
                ", screeningCreateDate=" + screeningCreateDate +
                ", screeningStartDate=" + screeningStartDate +
                ", screeningEndDate=" + screeningEndDate +
                ", screeningStatus='" + screeningStatus + '\'' +
                ", screeningCancleDate=" + screeningCancleDate +
                '}';
    }
}
