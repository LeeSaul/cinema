package com.ls.biz;


import com.ls.entity.Cinema;

import java.util.List;

/**
 * Created by LS on 2017/8/23 11:27.
 * To Be or Not to Be
 */
public interface ICinemaBiz {
    //���ӰԺ
    boolean addCinemaInfo();

    //ͨ��ӰԺ���������и����ֵĵ�ӰԺ
    boolean searchCinemaInfoByName();

    //ͨ����ַ������������е�ӰԺ
    List<Cinema> searchCinemaByAddresses();
    boolean updateCinemaInfoById();
}
