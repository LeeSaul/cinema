package com.ls.dao;

import com.ls.entity.Screening;

/**
 * Created by LS on 2017/8/24 8:00.
 * To Be or Not to Be
 */
public interface IScreeningDao {
    //��ӳ�����Ϣ
    Screening addScreening(Screening screening);

    //�鿴ָ������ ָ����Ӱ�ĳ�����Ϣ
    Screening searchScreening(Screening screening);

    //����ָ������ ָ����Ӱ�ĳ�����Ϣ
    Screening updateScreening(Screening screening);

}
