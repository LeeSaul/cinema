package com.ls.dao.dbimpl;

import com.ls.dao.IScreeningDao;
import com.ls.entity.Screening;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/8/24 8:01.
 * To Be or Not to Be
 */
public class ScreeningDaoImpl extends BaseDao implements IScreeningDao{
    @Override
    public Screening addScreening(Screening screening) {
        List parms = new ArrayList();
        String sql = "insert into screening(cinema_id,movie_id," +
                "hall_num,seat_capacity," +
                "sell_num,screening_start_date,screening_end_date," +
                "screening_status,screening_cancle_date)" +
                " values(?,?,?,?,?,?,?,?,?)";
        String sql2="select * from screening where cinema_id=? AND movie_id=? AND hall_num=? " +
                "AND seat_capacity=? AND sell_num=? " +
                "AND screening_start_date=? AND screening_end_date=?" +
                " AND screening_status=? AND screening_cancle_date=?";
        parms.add(screening.getCinemaId());
        parms.add(screening.getMovieId());
        parms.add(screening.getHallNum());
        parms.add(screening.getSeatCapacity());
        parms.add(screening.getSellNum());
        parms.add(screening.getScreeningStartDate());
        parms.add(screening.getScreeningEndDate());
        parms.add(screening.getScreeningStatus());
        parms.add(screening.getScreeningCancleDate());
        boolean isAdd = update(sql, parms);//增加场次是否成功
        //添加成功之后返还添加的信息
        System.out.println(isAdd);
        if (isAdd){
            List<Screening> list = query(sql2, parms, Screening.class);
            return list.get(0);
        }
        return null;
    }

    @Override
    public Screening searchScreening(Screening screening) {
        List parms = new ArrayList();
        String sql="select * from screening where cinema_id=? AND movie_id=?";
        parms.add(screening.getCinemaId());
        parms.add(screening.getMovieId());
        List<Screening> list = query(sql, parms, Screening.class);
        if (list!=null){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Screening> searchAllScreeningByArea(Screening screening) {
        List parms = new ArrayList();
        String sql="select * from screening where cinema_id=?";
        parms.add(screening.getCinemaId());
        List<Screening> list = query(sql, parms, Screening.class);
        if (list!=null){
            return list;
        }
        return null;
    }

    @Override
    public Screening updateScreening(Screening screening) {
        List parms = new ArrayList();
        String sql="update screening set hall_num=?," +
                "seat_capacity=?,sell_num=?,screening_start_date=?," +
                "screening_end_date=?,screening_status=?," +
                "screening_cancle_date=? where cinema_id=? AND movie_id=?";
        String sql2="select * from screening where hall_num=? AND seat_capacity=? AND sell_num=? " +
                "AND screening_start_date=? AND screening_end_date=? " +
                "AND screening_status=? AND screening_cancle_date=?" +
                " AND cinema_id=? AND movie_id=?";
        parms.add(screening.getHallNum());
        parms.add(screening.getSeatCapacity());
        parms.add(screening.getSellNum());
        parms.add(screening.getScreeningStartDate());
        parms.add(screening.getScreeningEndDate());
        parms.add(screening.getScreeningStatus());
        parms.add(screening.getScreeningCancleDate());
        parms.add(screening.getCinemaId());
        parms.add(screening.getMovieId());
        boolean isUpdate = update(sql, parms);
        if (isUpdate){
            List<Screening> list = query(sql2, parms, Screening.class);
            return list.get(0);
        }
        return null;
    }
}
