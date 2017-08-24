package com.ls.dao.dbimpl;

import com.ls.dao.IMovieDao;
import com.ls.entity.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/8/23 8:34.
 * To Be or Not to Be
 */
public class MovieDaoImpl extends BaseDao implements IMovieDao{
    @Override
    public boolean addMovie(Movie movie) {
        List parms = new ArrayList();
        String sql = "insert into movie(movie_name,movie_type,movie_price,movie_caption)" +
                " values(?,?,?,?)";
        parms.add(movie.getMovieName());
        parms.add(movie.getMovieType());
        parms.add(movie.getMoviePrice());
        parms.add(movie.getMovieCaption());
        boolean isAdd = update(sql, parms);//增加电影是否成功
        return isAdd;
    }

    @Override
    public boolean isMovieNameExist(Movie movie) {
        List parms=new ArrayList();
        String sql="select * from movie where movie_name=?";
        parms.add(movie.getMovieName());
        List<Movie> list = query(sql, parms,Movie.class);
        //true 存在该电影名
        if (list!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateMovie(Movie movie, String movieName) {
        List parms = new ArrayList();
        String sql = "update movie set movie_name=?,movie_type=?,movie_price=?,movie_caption=? where movie_name=?";
        parms.add(movie.getMovieName());
        parms.add(movie.getMovieType());
        parms.add(movie.getMoviePrice());
        parms.add(movie.getMovieCaption());
        parms.add(movieName);
        boolean isUpdate = update(sql, parms);//修改电影是否成功
        return isUpdate;
    }

    @Override
    public Movie searchMovie(String movieName) {
        List parms = new ArrayList();
        String sql = "select * from movie where movie_name=?";
        parms.add(movieName);
        List<Movie> list = query(sql, parms, Movie.class);
        if (list != null) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Movie> searchAllMovie() {
        String sql = "select * from movie";
        List<Movie> list = query(sql, null, Movie.class);
        return list;
    }
}
