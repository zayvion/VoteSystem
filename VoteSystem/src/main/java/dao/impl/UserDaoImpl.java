package dao.impl;

import dao.UserDao;
import pojo.User;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-06-29 08:28
 * @Description:用户Dao实现类
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

    @Override
    public List<User> getAllusers() throws SQLException {
        conn = JDBCUtils.getConn();
        List<User> list = new ArrayList<>();
        String sql = "SELECT *  FROM `t_user` WHERE `type`= 1";
        ps = conn.prepareStatement(sql);
        rs = ps.executeQuery();
        try {
            while (rs.next()){
                int id  = rs.getInt("id");
                String username = rs.getString("username");
                String emaiL = rs.getString("emaiL");
                int status = rs.getInt("status");
                User user = new User();
                user.setUsername(username);
                user.setStatus(status);
                user.setId(id);
                user.setEmail(emaiL);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,ps,rs);
        }
        return list;
    }

    @Override
    public User getUser(int id) throws SQLException {
        conn = JDBCUtils.getConn();
        User user = new User();
        String sql = "SELECT *  FROM `t_user` WHERE `type`= 1 AND `id`= ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,id);
        rs = ps.executeQuery();
        try {
            while (rs.next()){
                String username = rs.getString("username");
                String emaiL = rs.getString("emaiL");
                String password = rs.getString("password");
                int status = rs.getInt("status");
                user.setUsername(username);
                user.setStatus(status);
                user.setId(id);
                user.setEmail(emaiL);
                user.setPassword(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,ps,rs);
        }
        return user;
    }

    @Override
    public void updateUser(User user) throws SQLException {
        conn = JDBCUtils.getConn();
        String sql = "UPDATE `t_user` SET `username` = ?, `password` = ?, `email` = ? ,`status`= ? WHERE `id` = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setString(3,user.getEmail());
        ps.setInt(4,user.getStatus());
        ps.setInt(5,user.getId());

        try {
            int num = ps.executeUpdate();
            System.out.println("修改了"+num+"行数据");

        } finally {
            JDBCUtils.release(conn,ps,rs);
        }

    }

    @Override
    public void delUser(int id) throws SQLException {
        conn = JDBCUtils.getConn();
        String sql = "UPDATE `t_user` SET `status` = 0 WHERE `id` = ?";
        ps = conn.prepareStatement(sql);
       ps.setInt(1,id);
        try {
            int num = ps.executeUpdate();
            System.out.println("修改了"+num+"行数据");

        } finally {
            JDBCUtils.release(conn,ps,rs);
        }
    }
}
