package com.ls.biz;

import com.ls.entity.Movie;

import java.util.List;

/**
 * Created by LS on 2017/8/23 8:39.
 * To Be or Not to Be
 */
public interface IMovieBiz {
    boolean addMovieInfo();
    boolean updateMovieInfo();
    Movie searchMovieInfo();
    List<Movie> searchAllMovies();
    Movie getMovie();
}
