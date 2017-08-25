package com.ls.test;

import com.ls.utils.Input;

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
//        Ticket ticket=new Ticket();
//        ticket.setScreeningId(1);
//        ticket.setUserId(1);
//        ticket.setSeatNum(1);
//        ITicketDao ticketDao=new TicketDaoImpl();
//        boolean b = ticketDao.isExistTicketSeatNum(ticket);
//        System.out.println(b);
        String startS;
        Timestamp start=new Timestamp(System.currentTimeMillis());
        while (true) {
            try {
                System.out.println("请输入开始时间(格式例如：2017-08-01 12:00:00)");
                startS= Input.getString();
                start=Timestamp.valueOf(startS);
                System.out.println(start);
//                screening.setScreeningStartDate(start);
                break;
            } catch (Exception e) {
                System.out.println("输入格式有问题");
            }
        }
    }
}
