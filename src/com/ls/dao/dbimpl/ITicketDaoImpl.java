package com.ls.dao.dbimpl;

import com.ls.dao.ITicketDao;
import com.ls.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/8/24 10:22.
 * To Be or Not to Be
 */
public class ITicketDaoImpl extends BaseDao implements ITicketDao{
    @Override
    public Ticket addTicket(Ticket ticket) {
        List parms = new ArrayList();
        String sql = "insert into ticket(screening_id,user_id,seat_num)" +
                " values(?,?,?)";
//        String sql2="select * from address where address_province=? AND address_city=? AND address_county=? AND address_road=?";
        parms.add(ticket.getScreeningId());
        parms.add(ticket.getUserId());
        parms.add(ticket.getSeatNum());
        boolean isAdd = update(sql, parms);//增加影票是否成功
        return null;
    }

    @Override
    public List<Ticket> searchTicket(Ticket ticket) {
        List parms = new ArrayList();
        String sql = "select seat_num from ticket where screening_id=? AND user_id=?";
//        String sql2="select * from address where address_province=? AND address_city=? AND address_county=? AND address_road=?";
        parms.add(ticket.getScreeningId());
        parms.add(ticket.getUserId());
        parms.add(ticket.getSeatNum());
        List list = query(sql, parms, Ticket.class);
        if (list!=null){
            //返回所有已选的号
            return list;
        }
        return null;
    }

    @Override
    public boolean isExistTicketSeatNum(Ticket ticket) {
        List parms = new ArrayList();
        String sql = "select * from ticket where screening_id=? AND user_id=? AND seat_num=?";
//        String sql2="select * from address where address_province=? AND address_city=? AND address_county=? AND address_road=?";
        parms.add(ticket.getScreeningId());
        parms.add(ticket.getUserId());
        parms.add(ticket.getSeatNum());
        List list = query(sql, parms, Ticket.class);
        if (list!=null){
            //这张票已经被选
            return true;
        }
        return false;
    }
}
