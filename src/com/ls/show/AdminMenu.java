package com.ls.show;

/**
 * Created by LS on 2017/8/21 15:25.
 * To Be or Not to Be
 */
public class AdminMenu {
    public static void movieAdminMenu(){
        System.out.println("1、添加电影信息");
        System.out.println("2、查看所有电影信息");
        System.out.println("3、查看指定信息");
        System.out.println("4、更新电影信息");
        System.out.println("0、返回上一级");
        System.out.println("请选择");
    }
    public static void cinemaAdminMenu(){
        System.out.println("1、增加影院");
        System.out.println("2、查找影院");
        System.out.println("3、按区域查找影院信息");
        System.out.println("4、显示所有影院信息");
        System.out.println("5、更新影院信息");
        System.out.println("0、返回上一级");
        System.out.println("请选择");
    }
    public static void screeningAdminMenu(){
        System.out.println("1、选择区域添加电影场次");
        System.out.println("2、更新某区域电影场次");
        System.out.println("0、返回上一级");
        System.out.println("请选择");
    }
    public static void ticketAdminMenu(){
        System.out.println("1、影票信息");
        System.out.println("0、返回上一级");
        System.out.println("请选择");
    }
    public static void commnetAdminMenu(){
        System.out.println("1、查看电影评论");
        System.out.println("2、删除电影评论");
        System.out.println("0、返回上一级");
        System.out.println("请选择");
    }
}
