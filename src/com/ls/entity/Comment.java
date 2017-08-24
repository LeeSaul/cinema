package com.ls.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by LS on 2017/8/21 12:24.
 * To Be or Not to Be
 */
public class Comment implements Serializable{
    private int id;
    private int userId;
    private int movieId;
    private int ticketId;
    private String userComment;
    private int commentScore; //ÆÀ·Ö1 2 3 4 5
    private Timestamp commentUpdateDate;

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public int getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(int commentScore) {
        this.commentScore = commentScore;
    }

    public Timestamp getCommentUpdateDate() {
        return commentUpdateDate;
    }

    public void setCommentUpdateDate(Timestamp commentUpdateDate) {
        this.commentUpdateDate = commentUpdateDate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userId=" + userId +
                ", movieId=" + movieId +
                ", ticketId=" + ticketId +
                ", userComment='" + userComment + '\'' +
                ", commentScore=" + commentScore +
                ", commentUpdateDate=" + commentUpdateDate +
                '}';
    }
}
