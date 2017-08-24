package com.ls.dao;

import com.ls.entity.Ticket;

import java.util.List;

/**
 * Created by LS on 2017/8/24 10:18.
 * To Be or Not to Be
 */
public interface ITicketDao {
    //购票
    Ticket addTicket(Ticket ticket);
    //查看 指定区域 指定场次的影票信息
    List<Ticket> searchTicket(Ticket ticket);
    //判断该座位号是否有人，true是已经被购买 false未被购买
    boolean isExistTicketSeatNum(Ticket ticket);
}
