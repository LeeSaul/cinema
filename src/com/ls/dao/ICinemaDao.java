package com.ls.dao;

import com.ls.entity.Address;
import com.ls.entity.Cinema;

import java.util.List;

/**
 * Created by LS on 2017/8/23 9:15.
 * To Be or Not to Be
 */
public interface ICinemaDao {
    //����ӰԺ��Ϣ
    boolean addCinema(Cinema cinema);

    //ͨ�������ӰԺ��ַ����ַid���鿴ӰԺ��Ϣ
    Cinema searchCinemaNameByAddress(Cinema cinema);

    //����ӰԺ������ӰԺ��Ϣ
    List<Cinema> searchCinemaByName(Cinema cinema);

    //����ӰԺid����ӰԺ��Ϣ��ӰԺ�����֣�ӰԺ�ĵ�ַ
    boolean updateCinemaById(Cinema cinema,int id);

    //����ӰԺid����ӰԺ��Ϣ
    Cinema searchCinemaById(int id);
}
