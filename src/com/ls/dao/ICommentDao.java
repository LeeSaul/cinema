package com.ls.dao;

import com.ls.entity.Comment;

import javax.activation.CommandMap;

/**
 * Created by LS on 2017/8/24 11:56.
 * To Be or Not to Be
 */
public interface ICommentDao {
    //添加评论
    Comment addCommnet(Comment comment);
    //查看评论
    Comment searchCommnet(Comment comment);
    //删除指定电影的评论
    boolean deleteComment(Comment comment);
}
