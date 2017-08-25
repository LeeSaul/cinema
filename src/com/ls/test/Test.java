package com.ls.test;

import com.ls.biz.*;
import com.ls.biz.impl.*;
import com.ls.entity.Cinema;
import com.ls.entity.Movie;
import com.ls.show.AdminMenu;
import com.ls.show.MainMenu;
import com.ls.utils.Input;

import java.util.List;

/**
 * Created by LS on 2017/8/21 10:18.
 * To Be or Not to Be
 */
public class Test {
    public static void main(String[] args) {
        IAdminBiz adminBizImpl=new AdminBizImpl();
        IUserBiz userBizImpl=new UserBizImpl();
        IMovieBiz movieBiz=new MovieBizImpl();
        ICinemaBiz cinemaBiz=new CinemaBizImpl();
        IAddressBiz addressBiz=new AddressBizImpl();
        IAllEntityBiz allEntityBiz=new AllEntityBizImpl(); //�������ʹ�ô˶���
        IScreeningBiz screeningBiz=new ScreeningBizImpl();

        MainMenu.welcome();
        while (true) {
            MainMenu.mMenu();
            switch (Input.getInteger()){
                //����Ա��¼
                case 1:
                    boolean isLogin = adminBizImpl.adminLogin();
                    if (isLogin) {
                        //����ģ��
                        while (true){
                            AdminMenu.screeningAdminMenu();
                            int num=Input.getInteger();
                            switch (num){
                                case 1:
                                    //ѡ��������ӵ�Ӱ����
                                    boolean isAddScreening = screeningBiz.isAddScreening();
                                    if (isAddScreening){
                                        System.out.println("��ӵ�Ӱ");
                                    }
                                    break;
                                case 2:
                                    //����ĳ�����Ӱ����
                                    boolean b = screeningBiz.updateScreening();
                                    System.out.println("����"+b);
                                    break;
                                case 3:
                                    //
                                    break;
                                case 0:
                                    //0������һ��
                                    break;
                                default:
                                    System.out.println("�������");
                                    break;
                            }
                            break;
                        }


                        //ӰԺģ��
                        while (true){
                            AdminMenu.cinemaAdminMenu();
                            int num=Input.getInteger();
                            switch (num){
                                //��ӵ�ӰԺ��Ϣ
                                case 1:
                                    boolean b = cinemaBiz.addCinemaInfo();
                                    if (b){
                                        System.out.println("��ӳɹ�");
                                    }else {
                                        System.out.println("���ʧ��");
                                    }
                                    break;

                                //���ҵ�ӰԺ
                                case 2:
                                    boolean b1 = cinemaBiz.searchCinemaInfoByName();
                                    System.out.println(b1);
                                    if (!b1){
                                        System.out.println("�����ڸ�ӰԺ");
                                    }
                                    break;

                                //��������ҵ�ӰԺ��Ϣ
                                case 3:
                                    List<Cinema> cinemas = cinemaBiz.searchCinemaByAddresses();
                                    if (cinemas!=null){
                                        for (Cinema cinema : cinemas) {
                                            System.out.println(cinema);
                                        }
                                    }
                                    System.out.println("�����򲻴��ڵ�ӰԺ");
                                    break;

                                //��ʾ���е�ӰԺ��Ϣ
                                case 4:
                                    allEntityBiz.searchCinemaNameAndAddress();
                                    break;
                                //����ӰԺ��Ϣ
                                case 5:
                                    boolean b3 = cinemaBiz.updateCinemaInfoById();
                                    if (b3){
                                        System.out.println("���³ɹ�");
                                    }else {
                                        System.out.println("����ʧ��");
                                    }
                                    break;
                                //������һ��
                                case 0:
                                    break;
                                default:
                                    System.out.println("�������");
                                    break;
                            }
                            if (num==0){
                                break;
                            }
                        }
                        //��Ӱģ��
                        while (true) {
                            AdminMenu.movieAdminMenu();
                            int num = Input.getInteger();
                            switch (num) {
                                //��ӵ�Ӱ��Ϣ
                                case 1:
                                    movieBiz.addMovieInfo();
                                    break;
                                //�鿴���е�Ӱ��Ϣ
                                case 2:
                                    List<Movie> movies = movieBiz.searchAllMovies();
                                    if (movies==null){
                                        System.out.println("�������κε�Ӱ��Ϣ");
                                    }else {
                                        for (Movie movie : movies) {
                                            System.out.println(movie);
                                        }
                                    }
                                    break;
                                //�鿴ָ����Ϣ
                                case 3:
                                    Movie movie = movieBiz.searchMovieInfo();
                                    if (movie==null){
                                        System.out.println("�����ڸõ�Ӱ");
                                    }else {
                                        System.out.println(movie);
                                    }
                                    break;
                                //���µ�Ӱ��Ϣ
                                case 4:
                                    boolean b = movieBiz.updateMovieInfo();
                                    if (b){
                                        System.out.println("���³ɹ�");
                                    }else {
                                        System.out.println("����ʧ��");
                                    }
                                    break;
                                //������һ��
                                case 0:
                                    break;
                                default:
                                    System.out.println("�������");
                                    break;
                            }
                            if (num == 0) {
                                break;
                            }
                        }
                    }
                    System.out.println("��¼ʧ��");
                    break;
                case 2:
                    System.out.println("1���˺ŵ�¼");
                    System.out.println("2���ֻ��ŵ�¼");
                    System.out.println("0��������һ��");
                    while (true) {
                        int num=Input.getInteger();
                        switch (num){
                            case 1:
                                System.out.println(userBizImpl.userLoginByName());
                                break;
                            case 2:
                                 System.out.println(userBizImpl.userLoginByPhone());
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("�������");
                                break;
                        }
                        if (num==0){
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println(userBizImpl.userRegister());
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("�������,����������");
                    break;
            }
        }
    }
}
