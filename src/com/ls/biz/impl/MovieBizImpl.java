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

    //���
    @Override
    public boolean addMovieInfo() {
        Movie movie = input();
        boolean isMovieAdd=movieDao.addMovie(movie);
        if (isMovieAdd){
            System.out.println("��ӵ�Ӱ��Ϣ�ɹ�");
        }
        return isMovieAdd;
    }

    //�޸ĵ�Ӱ��Ϣ
    @Override
    public boolean updateMovieInfo() {
        Movie movie=new Movie();
        String name;
        boolean isUpdateMovie=false;
        while (true) {
            System.out.println("������Ҫ���µĵ�Ӱ��");
            name= Input.getString();
            movie = movieDao.searchMovie(name);
            if (movie!=null){
                movie = input();
                System.out.println("�Ƿ����y/n");
                if (Input.getString().equals("yes")||(Input.getString().equals("y"))){
                    movieDao.updateMovie(movie, name);
                    return true;
                }
                return false;
            }
            System.out.println("�����ڸõ�Ӱ��");
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
            System.out.println("�������Ӱ��");
            name=Input.getString();
            movie.setMovieName(name);
            boolean movieNameExist =movieDao.isMovieNameExist(movie);
            //movieNameExist true ���ڸõ�Ӱ�� false �����ڸõ�Ӱ��,�������
            if (!movieNameExist){
                break;
            }
            System.out.println("�Ѵ��ڸõ�Ӱ��");
//            if (inputTimes==3){
//                System.out.println("��������֮���˳�ע�����");
//                return null;
//            }
        }
        System.out.println("����������");
        type=Input.getString();
        movie.setMovieType(type);
        System.out.println("������۸�");
        price=Input.getDecimal();
        movie.setMoviePrice(price);
        System.out.println("�������Ӱ˵��");
        caption=Input.getString();
        movie.setMovieCaption(caption);
        return movie;
    }

    //��ѯ������Ӱ��Ϣ
    @Override
    public Movie searchMovieInfo(){
        Movie movie=new Movie();
        String name=null;
        System.out.println("�������Ӱ��");
        name=Input.getString();
        Movie isSearchMovie = movieDao.searchMovie(name);
        if (isSearchMovie==null){
            return null;
        }
        return isSearchMovie;
    }

    //��ѯ���еĵ�Ӱ��Ϣ
    @Override
    public List<Movie> searchAllMovies() {
        List<Movie> movies = movieDao.searchAllMovie();
        if (movies==null){
            return null;
        }
        return movies;
    }

    //�鿴���е�Ӱ��Ϣ
    public Movie getMovie(){
        List<Movie> movies = searchAllMovies();
        //��ʾ���еĵ�Ӱ
        if (movies!=null){
            System.out.println("---��Ӱ�б�---");
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }else {
            System.out.println("�����ڵ�Ӱ��Ϣ");
            return null;
        }
        Movie movie;
        int inputMovieTimes=0; //�������
        while (true) {
            inputMovieTimes++;
            movie = searchMovieInfo();
            if (movie!=null){
                break;
            }
            System.out.println("��Ӱ��������");
            if (inputMovieTimes==3){
                System.out.println("ʧ�ܴ������࣬���˳�");
                return null;
            }
        }
        return movie;
    }
}
