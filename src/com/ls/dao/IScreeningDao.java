package com.ls.dao;

import com.ls.entity.Screening;

/**
 * Created by LS on 2017/8/24 8:00.
 * To Be or Not to Be
 */
public interface IScreeningDao {
    //添加场次信息
    Screening addScreening(Screening screening);

    //查看指定区域 指定电影的场次信息
    Screening searchScreening(Screening screening);

    //更新指定区域 指定电影的场次信息
    Screening updateScreening(Screening screening);

}
