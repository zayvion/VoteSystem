package dao.impl;

import dao.CommentDao;
import pojo.Comment;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-09 23:11
 * @Description:评论Dao实现类
 */
public class CommentDaoImpl implements CommentDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public void addComment(Comment comment) throws SQLException {
        conn = JDBCUtils.getConn();
        String sql = "INSERT INTO`t_comment`(`uid`, `sid`, `nick_name`, `content`, `publish_time`) VALUES (?, ?, ?, ?, ?)";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,comment.getUid());
            ps.setInt(2,comment.getSid());
            ps.setString(3,comment.getNickName());
            ps.setString(4, comment.getContent());
            ps.setDate(5, new java.sql.Date(new java.util.Date().getTime()));
            int num = ps.executeUpdate();

            System.out.println("增加了"+num+"行数据");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,ps,rs);
        }

    }

    @Override
    public List<Comment> getComments(int sid) throws SQLException {
        conn = JDBCUtils.getConn();
        List<Comment> list = new ArrayList<>();
        String sql = "SELECT * FROM `t_comment` WHERE `sid` = ? ORDER BY `id` DESC";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,sid);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int uid = rs.getInt("uid");
                String nick_name = rs.getString("nick_name");
                String content = rs.getString("content");
                Date publish_time = rs.getDate("publish_time");
                Comment comment = new Comment(id, uid, sid, nick_name, content, publish_time);
                list.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,ps,rs);
        }
        return list;

    }
}
