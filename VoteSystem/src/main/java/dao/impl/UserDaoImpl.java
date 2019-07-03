package dao.impl;

import dao.UserDao;
import pojo.User;
import utils.JDBCUtils;

import java.sql.*;

/**
 * @Auther: zayvion
 * @Date: 2019-06-29 08:28
 * @Description:
 */
public class UserDaoImpl implements UserDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public Long addUser(User user) throws SQLException {
        Long id = 0l;
        conn = JDBCUtils.getConn();
        String sql = "INSERT INTO `t_user`(`username`, `password`, `type`, `status`) VALUES (?, ?, ?, ?)";
        ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setInt(3,user.getType());
        ps.setInt(4,user.getStatus());
        try {

             ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
        } finally {
            JDBCUtils.release(conn,ps);
        }
        return id;
    }

    @Override
    public int equalsUser(User user) throws SQLException {
        conn = JDBCUtils.getConn();
        int id = 0;
        String sql = "SELECT *  FROM `t_user` WHERE `username` = ? AND `password` = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        rs = ps.executeQuery();
        try {
            if (rs.next()){
                id  = rs.getInt("id");
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,ps);
        }
        return id;

    }
}
