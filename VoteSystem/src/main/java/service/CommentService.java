package service;

import pojo.Comment;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-09 23:18
 * @Description:评论Service接口类
 */
public interface CommentService {
    /**
     * 添加评论
     * @param comment
     * @throws SQLException
     */
    void addComment (Comment comment) throws SQLException;
    /**
     * 取出一个主题下所有评论
     * @param sid
     * @throws SQLException
     */
    List<Comment> getComments (int sid) throws SQLException;
}
