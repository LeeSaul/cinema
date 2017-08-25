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

    /// /��ӳ�����Ϣ����ҪӰԺid�͵�Ӱid��
    @Override
    public Boolean isAddScreening() {
        Screening addScreening=null;
        Movie movie = movieBiz.getMovie();
        if (movie==null){
            return false;
        }

        List<Cinema> cinemas  = cinemaBiz.searchCinemaByAddresses();
        if (cinemas==null){
            System.out.println("�����򲻴��ڵ�ӰԺ");
            return false;
        }
//        int inputAddressTimes=0; //�������
//        while (true) {
//            inputAddressTimes++;
//            cinemas = cinemaBiz.searchCinemaByAddresses();
//            if (cinemas!=null){
//                break;
//            }
//            System.out.println("�����򲻴��ڵ�ӰԺ");
//            if (inputAddressTimes==3){
//                System.out.println("ʧ�ܴ������࣬���˳�");
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
        System.out.println("����������");
        screening.setHallNum(Input.getInteger());
        System.out.println("��������λ����");
        screening.setSeatCapacity(Input.getInteger());
//        �۳�ƱΪ0
//        System.out.println("���������۳�Ʊ��");
        screening.setSellNum(0);
        while (true) {
            String startS;
            Timestamp start;
            while (true) {
                try {
                    System.out.println("�����뿪ʼʱ��(��ʽ���磺2017-08-01 12:00:00)");
                    startS=scanner.nextLine();
                    start=Timestamp.valueOf(startS);
                    screening.setScreeningStartDate(start);
                    break;
                } catch (Exception e) {
                    System.out.println("�����ʽ������");
                }
            }
            String endS;
            Timestamp end;
            while (true){
                try {
                    System.out.println("���������ʱ��(��ʽ���磺2017-08-01 12:00:00)");
                    endS=scanner.nextLine();
                    end=Timestamp.valueOf(endS);
                    screening.setScreeningEndDate(end);
                    break;
                } catch (Exception e) {
                    System.out.println("�����ʽ������");
                }
            }
            String cancleS;
            Timestamp cancle;
            while (true){
                try {
                    System.out.println("������ȡ��ʱ��(ʱ���ʽ���磺2017-08-01 12:00:00)");
                    cancleS=scanner.nextLine();
                    cancle=Timestamp.valueOf(cancleS);
                    screening.setScreeningCancleDate(cancle);
                    break;
                } catch (Exception e) {
                    System.out.println("�����ʽ������");
                }
            }
            if (screening.getScreeningStartDate().getTime()<screening.getScreeningEndDate().getTime()
                    &&screening.getScreeningCancleDate().getTime()<screening.getScreeningStartDate().getTime()){
                break;
            }
            System.out.println("���棺�������󣨿�ʼʱ��ӦС�ڽ���ʱ�䣬����ȡ��ʱ��Ӧ�ڿ�ʼǰһ��ʱ�䣩");
        }
        System.out.println("�����볡��״̬(����/��ȡ��)");
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
            System.out.println("�����򲻴��ڵ�ӰԺ");
            return false;
        }
        updateScreening.setMovieId(movie.getId());
        updateScreening.setCinemaId(cinemas.get(0).getId());
        Screening searchScreening = screeningDao.searchScreening(updateScreening);
        if (searchScreening==null){
            System.out.println("������û���κε�Ӱ����");
            return false;
        }else {
            System.out.println("���������е�Ӱ����");
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

    //�鿴ָ����������г���
    @Override
    public List<Screening> searchScreeningByAddresses() {
        List<Screening> screeningOfAear=new ArrayList<>();
        Screening screening=new Screening();
        List<Cinema> cinemas  = cinemaBiz.searchCinemaByAddresses();
        if (cinemas==null){
            System.out.println("�����򲻴��ڵ�ӰԺ");
            return null;
        }
        for (Cinema cinema : cinemas) {
            screening.setCinemaId(cinema.getId());
            List<Screening> screenings = screeningDao.searchAllScreeningByArea(screening);
            System.out.println("ӰԺ����"+cinema.getCinemaName());
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
