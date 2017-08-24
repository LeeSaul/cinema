package com.ls.dao;

import com.ls.entity.Movie;

import java.util.List;

/**
 * Created by LS on 2017/8/23 8:32.
 * To Be or Not to Be
 */
public interface IMovieDao {
    //���ӵ�Ӱ��Ϣ
    boolean addMovie(Movie movie);
    //�鿴�õ�Ӱ�Ƿ��Ѿ�����
    boolean isMovieNameExist(Movie movie);
    //���µ�Ӱ��Ϣ
    boolean updateMovie(Movie movie,String name);
    //�鿴��Ӱ��Ϣ
    Movie searchMovie(String movieName);
    //�鿴���е�Ӱ��Ϣ
    List<Movie> searchAllMovie();
}
