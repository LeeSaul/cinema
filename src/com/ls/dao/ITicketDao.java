package com.ls.dao;

import com.ls.entity.Ticket;

import java.util.List;

/**
 * Created by LS on 2017/8/24 10:18.
 * To Be or Not to Be
 */
public interface ITicketDao {
    //��Ʊ
    Ticket addTicket(Ticket ticket);
    //�鿴 ָ������ ָ�����ε�ӰƱ��Ϣ
    List<Ticket> searchTicket(Ticket ticket);
    //�жϸ���λ���Ƿ����ˣ�true���Ѿ������� falseδ������
    boolean isExistTicketSeatNum(Ticket ticket);
}
