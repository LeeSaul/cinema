package com.ls.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by LS on 2017/8/21 10:07.
 * To Be or Not to Be
 */
public class Movie implements Serializable{
    private int id;
    private String movieName;
    private String movieType;
    private BigDecimal moviePrice;
    private String movieCaption; //电影说明
    private Timestamp movieCreateDate;

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public BigDecimal getMoviePrice() {
        return moviePrice;
    }

    public void setMoviePrice(BigDecimal moviePrice) {
        this.moviePrice = moviePrice;
    }

    public String getMovieCaption() {
        return movieCaption;
    }

    public void setMovieCaption(String movieCaption) {
        this.movieCaption = movieCaption;
    }

    public Timestamp getMovieCreateDate() {
        return movieCreateDate;
    }

    public void setMovieCreateDate(Timestamp movieCreateDate) {
        this.movieCreateDate = movieCreateDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                ", movieType='" + movieType + '\'' +
                ", moviePrice=" + moviePrice +
                ", movieCaption='" + movieCaption + '\'' +
                ", movieCreateDate=" + movieCreateDate +
                '}';
    }
}
