package service.impl;

import dao.CommentDao;
import dao.impl.CommentDaoImpl;
import pojo.Comment;
import service.CommentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-09 23:19
 * @Description:评论Service接口类
 */
public class CommentServiceImpl implements CommentService {
    @Override
    public void addComment(Comment comment) throws SQLException {
        CommentDao commentDao = new CommentDaoImpl();
        commentDao.addComment(comment);
    }

    @Override
    public List<Comment> getComments(int sid) throws SQLException {
        CommentDao commentDao = new CommentDaoImpl();
        List<Comment> list = commentDao.getComments(sid);
        return list;
    }
}
