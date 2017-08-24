package com.ls.dao;

import com.ls.entity.Address;
import com.ls.entity.Cinema;

import java.util.List;

/**
 * Created by LS on 2017/8/23 9:15.
 * To Be or Not to Be
 */
public interface ICinemaDao {
    //增加影院信息
    boolean addCinema(Cinema cinema);

    //通过具体的影院地址（地址id）查看影院信息
    Cinema searchCinemaNameByAddress(Cinema cinema);

    //根据影院名查找影院信息
    List<Cinema> searchCinemaByName(Cinema cinema);

    //根据影院id更新影院信息（影院的名字）影院的地址
    boolean updateCinemaById(Cinema cinema,int id);

    //根据影院id查找影院信息
    Cinema searchCinemaById(int id);
}
