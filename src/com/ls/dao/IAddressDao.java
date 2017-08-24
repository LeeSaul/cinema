package com.ls.dao;

import com.ls.entity.Address;

import java.util.List;

/**
 * Created by LS on 2017/8/23 11:00.
 * To Be or Not to Be
 */
public interface IAddressDao {
    //����ӰԺ��ַ
    Address addAddress(Address address);

    //ͨ��ĳһ����ַ�鿴�������е�ӰԺ
    List<Address> searchAddress(Address address);

    List<Address> searchAddressbyId(Address address);
    //����ӰԺ��Ϣ
    boolean updateAddress(Address address,int id);

    //�鿴��ӰԺ�Ƿ��Ѿ�����
    boolean isAddressExist(Address address);

    //�鿴����ӰԺ��Ϣ
    List<Address> searchAllCinema();
}
