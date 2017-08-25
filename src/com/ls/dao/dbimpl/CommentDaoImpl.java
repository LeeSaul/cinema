package com.ls.dao.dbimpl;

import com.ls.dao.ICommentDao;
import com.ls.entity.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LS on 2017/8/24 11:57.
 * To Be or Not to Be
 */
public class CommentDaoImpl extends BaseDao implements ICommentDao{
    @Override
    public Comment addCommnet(Comment comment) {
        //�������
        List parms = new ArrayList();
        String sql = "insert into comment(user_id,movie_id,ticket_id,user_comment,comment_score)" +
                " values(?,?,?,?,?)";
        String sql2="select * from comment where user_id=? AND movie_id=? AND ticket_id=? AND user_comment=? AND comment_score=?";
        parms.add(comment.getUserId());
        parms.add(comment.getMovieId());
        parms.add(comment.getTicketId());
        parms.add(comment.getUserComment());
        parms.add(comment.getCommentScore());
        boolean isAdd = update(sql, parms);//����ӰԺ�Ƿ�ɹ�
        //���������۳ɹ�����ô��������������Ϣ
        if (isAdd){
            List<Comment> list = query(sql2, parms, Comment.class);
            return list.get(0);
        }
        return null;
    }

    @Override
    public Comment searchCommnet(Comment comment) {
        //�鿴ĳ����Ӱ��������
        List parms = new ArrayList();
        String sql="select * from comment where movie_id=?";
        parms.add(comment.getMovieId());
        List<Comment> list = query(sql, parms, Comment.class);
        if (list!=null){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean deleteComment(Comment comment) {
        //ɾ��������Ϣ
        List parms = new ArrayList();
        String sql="delete from comment where ticket_id=?";
        parms.add(comment.getTicketId());
        boolean isDelete = update(sql, parms);
        if (isDelete){
            //ɾ���ɹ�
            return true;
        }
        return false;
    }
}
