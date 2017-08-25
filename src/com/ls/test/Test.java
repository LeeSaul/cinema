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
        IAllEntityBiz allEntityBiz=new AllEntityBizImpl(); //多表联查使用此对象
        IScreeningBiz screeningBiz=new ScreeningBizImpl();

        MainMenu.welcome();
        while (true) {
            MainMenu.mMenu();
            switch (Input.getInteger()){
                //管理员登录
                case 1:
                    boolean isLogin = adminBizImpl.adminLogin();
                    if (isLogin) {
                        //场次模块
                        while (true){
                            AdminMenu.screeningAdminMenu();
                            int num=Input.getInteger();
                            switch (num){
                                case 1:
                                    //选择区域添加电影场次
                                    boolean isAddScreening = screeningBiz.isAddScreening();
                                    if (isAddScreening){
                                        System.out.println("添加电影");
                                    }
                                    break;
                                case 2:
                                    //更新某区域电影场次
                                    boolean b = screeningBiz.updateScreening();
                                    System.out.println("更新"+b);
                                    break;
                                case 3:
                                    //
                                    break;
                                case 0:
                                    //0返回上一级
                                    break;
                                default:
                                    System.out.println("输入错误");
                                    break;
                            }
                            break;
                        }


                        //影院模块
                        while (true){
                            AdminMenu.cinemaAdminMenu();
                            int num=Input.getInteger();
                            switch (num){
                                //添加电影院信息
                                case 1:
                                    boolean b = cinemaBiz.addCinemaInfo();
                                    if (b){
                                        System.out.println("添加成功");
                                    }else {
                                        System.out.println("添加失败");
                                    }
                                    break;

                                //查找电影院
                                case 2:
                                    boolean b1 = cinemaBiz.searchCinemaInfoByName();
                                    System.out.println(b1);
                                    if (!b1){
                                        System.out.println("不存在该影院");
                                    }
                                    break;

                                //按区域查找电影院信息
                                case 3:
                                    List<Cinema> cinemas = cinemaBiz.searchCinemaByAddresses();
                                    if (cinemas!=null){
                                        for (Cinema cinema : cinemas) {
                                            System.out.println(cinema);
                                        }
                                    }
                                    System.out.println("该区域不存在电影院");
                                    break;

                                //显示所有电影院信息
                                case 4:
                                    allEntityBiz.searchCinemaNameAndAddress();
                                    break;
                                //更新影院信息
                                case 5:
                                    boolean b3 = cinemaBiz.updateCinemaInfoById();
                                    if (b3){
                                        System.out.println("更新成功");
                                    }else {
                                        System.out.println("更新失败");
                                    }
                                    break;
                                //返回上一级
                                case 0:
                                    break;
                                default:
                                    System.out.println("输入错误");
                                    break;
                            }
                            if (num==0){
                                break;
                            }
                        }
                        //电影模块
                        while (true) {
                            AdminMenu.movieAdminMenu();
                            int num = Input.getInteger();
                            switch (num) {
                                //添加电影信息
                                case 1:
                                    movieBiz.addMovieInfo();
                                    break;
                                //查看所有电影信息
                                case 2:
                                    List<Movie> movies = movieBiz.searchAllMovies();
                                    if (movies==null){
                                        System.out.println("不存在任何电影信息");
                                    }else {
                                        for (Movie movie : movies) {
                                            System.out.println(movie);
                                        }
                                    }
                                    break;
                                //查看指定信息
                                case 3:
                                    Movie movie = movieBiz.searchMovieInfo();
                                    if (movie==null){
                                        System.out.println("不存在该电影");
                                    }else {
                                        System.out.println(movie);
                                    }
                                    break;
                                //更新电影信息
                                case 4:
                                    boolean b = movieBiz.updateMovieInfo();
                                    if (b){
                                        System.out.println("更新成功");
                                    }else {
                                        System.out.println("更新失败");
                                    }
                                    break;
                                //返回上一级
                                case 0:
                                    break;
                                default:
                                    System.out.println("输入错误");
                                    break;
                            }
                            if (num == 0) {
                                break;
                            }
                        }
                    }
                    System.out.println("登录失败");
                    break;
                case 2:
                    System.out.println("1、账号登录");
                    System.out.println("2、手机号登录");
                    System.out.println("0、返回上一级");
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
                                System.out.println("输入错误");
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
                    System.out.println("输入错误,请重新输入");
                    break;
            }
        }
    }
}
