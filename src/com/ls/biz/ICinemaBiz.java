package com.ls.biz;


import com.ls.entity.Cinema;

import java.util.List;

/**
 * Created by LS on 2017/8/23 11:27.
 * To Be or Not to Be
 */
public interface ICinemaBiz {
    //添加影院
    boolean addCinemaInfo();

    //通过影院名查找所有该名字的电影院
    boolean searchCinemaInfoByName();

    //通过地址查找区域该所有的影院
    List<Cinema> searchCinemaByAddresses();
    boolean updateCinemaInfoById();
}
