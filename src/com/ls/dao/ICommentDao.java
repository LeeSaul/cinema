package com.ls.dao;

import com.ls.entity.Comment;

import javax.activation.CommandMap;

/**
 * Created by LS on 2017/8/24 11:56.
 * To Be or Not to Be
 */
public interface ICommentDao {
    //�������
    Comment addCommnet(Comment comment);
    //�鿴����
    Comment searchCommnet(Comment comment);
    //ɾ��ָ����Ӱ������
    boolean deleteComment(Comment comment);
}
