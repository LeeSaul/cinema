package com.ls.dao;

import com.ls.entity.AllEntity;

import java.util.List;

/**
 * Created by LS on 2017/8/23 15:05.
 * To Be or Not to Be
 */
public interface IAllEntityDao {
    //查看所有影院信息
    List<AllEntity> searchAllCinema();
    //
}
