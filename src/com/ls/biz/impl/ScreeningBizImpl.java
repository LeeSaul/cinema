package com.ls.biz.impl;

import com.ls.biz.IAddressBiz;
import com.ls.biz.ICinemaBiz;
import com.ls.biz.IMovieBiz;
import com.ls.biz.IScreeningBiz;
import com.ls.dao.IScreeningDao;
import com.ls.dao.dbimpl.ScreeningDaoImpl;
import com.ls.entity.Cinema;
import com.ls.entity.Movie;
import com.ls.entity.Screening;
import com.ls.utils.Input;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by LS on 2017/8/24 8:02.
 * To Be or Not to Be
 */
public class ScreeningBizImpl implements IScreeningBiz{
    public static Scanner scanner=new Scanner(System.in);

    IScreeningDao screeningDao;
    IAddressBiz addressBiz;
    ICinemaBiz cinemaBiz;
    IMovieBiz movieBiz;

    public ScreeningBizImpl() {
        screeningDao=new ScreeningDaoImpl();
        addressBiz=new AddressBizImpl();
        cinemaBiz=new CinemaBizImpl();
        movieBiz=new MovieBizImpl();
    }

    /// /添加场次信息（需要影院id和电影id）
    @Override
    public Boolean isAddScreening() {
        Screening addScreening=null;
        Movie movie = movieBiz.getMovie();
        if (movie==null){
            return false;
        }

        List<Cinema> cinemas  = cinemaBiz.searchCinemaByAddresses();
        if (cinemas==null){
            System.out.println("该区域不存在电影院");
            return false;
        }
//        int inputAddressTimes=0; //输入次数
//        while (true) {
//            inputAddressTimes++;
//            cinemas = cinemaBiz.searchCinemaByAddresses();
//            if (cinemas!=null){
//                break;
//            }
//            System.out.println("该区域不存在电影院");
//            if (inputAddressTimes==3){
//                System.out.println("失败次数过多，已退出");
//                return false;
//            }
//        }
        Screening screening=input();
        for (Cinema cinema : cinemas) {
            System.out.println(cinema);
            screening.setCinemaId(cinema.getId());
            screening.setMovieId(movie.getId());
            addScreening = screeningDao.addScreening(screening);
        }
        if (addScreening!=null){
            return true;
        }
        return false;
    }


    public static Screening input(){
        Screening screening=new Screening();
        System.out.println("请输入厅号");
        screening.setHallNum(Input.getInteger());
        System.out.println("请输入座位总数");
        screening.setSeatCapacity(Input.getInteger());
//        售出票为0
//        System.out.println("请输入已售出票数");
        screening.setSellNum(0);
        while (true) {
            String startS;
            Timestamp start;
            while (true) {
                try {
                    System.out.println("请输入开始时间(格式例如：2017-08-01 12:00:00)");
                    startS=scanner.nextLine();
                    start=Timestamp.valueOf(startS);
                    screening.setScreeningStartDate(start);
                    break;
                } catch (Exception e) {
                    System.out.println("输入格式有问题");
                }
            }
            String endS;
            Timestamp end;
            while (true){
                try {
                    System.out.println("请输入结束时间(格式例如：2017-08-01 12:00:00)");
                    endS=scanner.nextLine();
                    end=Timestamp.valueOf(endS);
                    screening.setScreeningEndDate(end);
                    break;
                } catch (Exception e) {
                    System.out.println("输入格式有问题");
                }
            }
            String cancleS;
            Timestamp cancle;
            while (true){
                try {
                    System.out.println("请输入取消时间(时间格式例如：2017-08-01 12:00:00)");
                    cancleS=scanner.nextLine();
                    cancle=Timestamp.valueOf(cancleS);
                    screening.setScreeningCancleDate(cancle);
                    break;
                } catch (Exception e) {
                    System.out.println("输入格式有问题");
                }
            }
            if (screening.getScreeningStartDate().getTime()<screening.getScreeningEndDate().getTime()
                    &&screening.getScreeningCancleDate().getTime()<screening.getScreeningStartDate().getTime()){
                break;
            }
            System.out.println("警告：输入有误（开始时间应小于结束时间，场次取消时间应在开始前一段时间）");
        }
        System.out.println("请输入场次状态(正常/已取消)");
        screening.setScreeningStatus(Input.getString());
        return screening;
    }
    public Boolean updateScreening(){
        Screening updateScreening=new Screening();
        Movie movie = movieBiz.getMovie();
        if (movie==null){
            return false;
        }
        List<Cinema> cinemas  = cinemaBiz.searchCinemaByAddresses();
        if (cinemas==null){
            System.out.println("该区域不存在电影院");
            return false;
        }
        updateScreening.setMovieId(movie.getId());
        updateScreening.setCinemaId(cinemas.get(0).getId());
        Screening searchScreening = screeningDao.searchScreening(updateScreening);
        if (searchScreening==null){
            System.out.println("该区域没有任何电影场次");
            return false;
        }else {
            System.out.println("该区域所有电影场次");
            System.out.println(searchScreening);
        }
        Screening screening=input();
        Screening upScreening=null;
        for (Cinema cinema : cinemas) {
            System.out.println(cinema);
            screening.setCinemaId(cinema.getId());
            screening.setMovieId(movie.getId());
            upScreening = screeningDao.updateScreening(screening);
        }
        if (upScreening!=null){
            return true;
        }
        return false;
    }

    //查看指定区域的所有场次
    @Override
    public List<Screening> searchScreeningByAddresses() {
        List<Screening> screeningOfAear=new ArrayList<>();
        Screening screening=new Screening();
        List<Cinema> cinemas  = cinemaBiz.searchCinemaByAddresses();
        if (cinemas==null){
            System.out.println("该区域不存在电影院");
            return null;
        }
        for (Cinema cinema : cinemas) {
            screening.setCinemaId(cinema.getId());
            List<Screening> screenings = screeningDao.searchAllScreeningByArea(screening);
            System.out.println("影院名："+cinema.getCinemaName());
            if (screenings!=null) {
                for (Screening screening1 : screenings) {
                    screeningOfAear.add(screening1);
                    System.out.println(screening1);
                }
            }
        }
        return screeningOfAear;
    }

}
