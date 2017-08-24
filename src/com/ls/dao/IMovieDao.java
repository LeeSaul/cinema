package com.ls.dao;

import com.ls.entity.Movie;

import java.util.List;

/**
 * Created by LS on 2017/8/23 8:32.
 * To Be or Not to Be
 */
public interface IMovieDao {
    //增加电影信息
    boolean addMovie(Movie movie);
    //查看该电影是否已经存在
    boolean isMovieNameExist(Movie movie);
    //更新电影信息
    boolean updateMovie(Movie movie,String name);
    //查看电影信息
    Movie searchMovie(String movieName);
    //查看所有电影信息
    List<Movie> searchAllMovie();
}
