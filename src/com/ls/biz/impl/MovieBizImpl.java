package com.ls.biz.impl;

import com.ls.biz.IMovieBiz;
import com.ls.dao.IMovieDao;
import com.ls.dao.dbimpl.MovieDaoImpl;
import com.ls.entity.Movie;
import com.ls.utils.Input;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by LS on 2017/8/23 8:38.
 * To Be or Not to Be
 */
public class MovieBizImpl implements IMovieBiz{

    IMovieDao movieDao;
    public MovieBizImpl() {
        movieDao=new MovieDaoImpl();
    }

    //添加
    @Override
    public boolean addMovieInfo() {
        Movie movie = input();
        boolean isMovieAdd=movieDao.addMovie(movie);
        if (isMovieAdd){
            System.out.println("添加电影信息成功");
        }
        return isMovieAdd;
    }

    //修改电影信息
    @Override
    public boolean updateMovieInfo() {
        Movie movie=new Movie();
        String name;
        boolean isUpdateMovie=false;
        while (true) {
            System.out.println("请输入要更新的电影名");
            name= Input.getString();
            movie = movieDao.searchMovie(name);
            if (movie!=null){
                movie = input();
                System.out.println("是否更新y/n");
                if (Input.getString().equals("yes")||(Input.getString().equals("y"))){
                    movieDao.updateMovie(movie, name);
                    return true;
                }
                return false;
            }
            System.out.println("不存在该电影名");
        }
    }

    public Movie input(){
        Movie movie=new Movie();
        String name=null;
        String type=null;
        BigDecimal price;
        String caption=null;
//        int inputTimes=0;
        while (true) {
//            inputTimes++;
            System.out.println("请输入电影名");
            name=Input.getString();
            movie.setMovieName(name);
            boolean movieNameExist =movieDao.isMovieNameExist(movie);
            //movieNameExist true 存在该电影名 false 不存在该电影名,可以添加
            if (!movieNameExist){
                break;
            }
            System.out.println("已存在该电影名");
//            if (inputTimes==3){
//                System.out.println("输入三次之后退出注册界面");
//                return null;
//            }
        }
        System.out.println("请输入类型");
        type=Input.getString();
        movie.setMovieType(type);
        System.out.println("请输入价格");
        price=Input.getDecimal();
        movie.setMoviePrice(price);
        System.out.println("请输入电影说明");
        caption=Input.getString();
        movie.setMovieCaption(caption);
        return movie;
    }

    //查询单条电影信息
    @Override
    public Movie searchMovieInfo(){
        Movie movie=new Movie();
        String name=null;
        System.out.println("请输入电影名");
        name=Input.getString();
        Movie isSearchMovie = movieDao.searchMovie(name);
        if (isSearchMovie==null){
            return null;
        }
        return isSearchMovie;
    }

    //查询所有的电影信息
    @Override
    public List<Movie> searchAllMovies() {
        List<Movie> movies = movieDao.searchAllMovie();
        if (movies==null){
            return null;
        }
        return movies;
    }

    //查看所有电影信息
    public Movie getMovie(){
        List<Movie> movies = searchAllMovies();
        //显示已有的电影
        if (movies!=null){
            System.out.println("---电影列表---");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }else {
            System.out.println("不存在电影信息");
            return null;
        }
        Movie movie;
        int inputMovieTimes=0; //输入次数
        while (true) {
            inputMovieTimes++;
            movie = searchMovieInfo();
            if (movie!=null){
                break;
            }
            System.out.println("电影名不存在");
            if (inputMovieTimes==3){
                System.out.println("失败次数过多，已退出");
                return null;
            }
        }
        return movie;
    }
}
