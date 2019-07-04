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
        String sql = "INSERT INTO `t_user`(`username`, `password`, `email` , `type`, `status`) VALUES (?, ?, ?, ? ,?)";
        ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3,user.getEmail());
        ps.setInt(4,user.getType());
        ps.setInt(5,user.getStatus());
        try {

             ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
        } finally {
            JDBCUtils.release(conn,ps,rs);
        }
        return id;
    }

    @Override
    public int equalsUser(User user) throws SQLException {
        conn = JDBCUtils.getConn();
        int id = 0;
        String sql = "SELECT *  FROM `t_user` WHERE `username` = ? AND `password` = ? AND `status`= 1  ";
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
            JDBCUtils.release(conn,ps,rs);
        }
        return id;

    }

    @Override
    public boolean isUserRepeat(User user) throws SQLException {
        conn = JDBCUtils.getConn();
        int num = 0;
        String sql = "SELECT  COUNT(*) AS num FROM `t_user` WHERE `username` = ? ";
        ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        rs = ps.executeQuery();
        try {
            if (rs.next()){
                num  = rs.getInt(1);
                if (num > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,ps,rs);
        }
        return false;
    }
}
