package com.ls.test;

import com.ls.biz.IAllEntityBiz;
import com.ls.biz.impl.AllEntityBizImpl;
import com.ls.dao.IScreeningDao;
import com.ls.dao.ITicketDao;
import com.ls.dao.dbimpl.AddressDaoImpl;
import com.ls.dao.dbimpl.ITicketDaoImpl;
import com.ls.dao.dbimpl.ScreeningDaoImpl;
import com.ls.entity.Address;
import com.ls.entity.Screening;
import com.ls.entity.Ticket;

import java.sql.Timestamp;

/**
 * Created by LS on 2017/8/22 22:06.
 * To Be or Not to Be
 */
public class BigDTest {
    public static void main(String[] args) {
//        Timestamp start=new Timestamp(System.currentTimeMillis());
//        Timestamp end=new Timestamp(System.currentTimeMillis());
//        Timestamp cancle=new Timestamp(System.currentTimeMillis());
//        String startS = "2017-08-09 12:00:01";
//        String endS = "2017-08-09 12:00:00";
//        String cancleS = "2017-08-09 12:00:00";
//        start=Timestamp.valueOf(startS);
//        end=Timestamp.valueOf(endS);
//        cancle=Timestamp.valueOf(cancleS);
//        System.out.println(start);
//        Screening screening=new Screening(1,1,1,50,0,start,end,"true",cancle);
//        IScreeningDao screeningDao=new ScreeningDaoImpl();
//        Screening addScreening = screeningDao.addScreening(screening);
        Ticket ticket=new Ticket();
        ticket.setScreeningId(1);
        ticket.setUserId(1);
        ticket.setSeatNum(1);
        ITicketDao ticketDao=new ITicketDaoImpl();
        boolean b = ticketDao.isExistTicketSeatNum(ticket);
        System.out.println(b);
    }
}
