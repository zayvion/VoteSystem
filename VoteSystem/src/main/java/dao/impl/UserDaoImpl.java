package dao.impl;

import dao.UserDao;
import pojo.User;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void addUser(User user) throws SQLException {
        conn = JDBCUtils.getConn();
        String sql = "INSERT INTO `t_user`(`username`, `password`, `type`, `status`) VALUES (?, ?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setInt(3,user.getType());
        ps.setInt(4,user.getStatus());
        try {
            int num = ps.executeUpdate();
            System.out.println("增加了"+num+"条数据");
        } finally {
            JDBCUtils.release(conn,ps);
        }
    }

    @Override
    public int equalsUser(User user) throws SQLException {
        conn = JDBCUtils.getConn();
        int num =0;
        String sql = "SELECT COUNT(*) AS `num` FROM `t_user` WHERE `username` = ? AND `password` = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        rs = ps.executeQuery();
        if (rs.next()){
            num = rs.getInt("num");
            return num;
        }
        return num;

    }
}
