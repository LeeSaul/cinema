package com.ls.biz;

import com.ls.entity.Screening;

import java.util.List;

/**
 * Created by LS on 2017/8/24 8:02.
 * To Be or Not to Be
 */
public interface IScreeningBiz {
    //��ӳ�����Ϣ����ҪӰԺid�͵�Ӱid��
    Boolean isAddScreening();
    Boolean updateScreening();
    List<Screening> searchScreeningByAddresses();
}
