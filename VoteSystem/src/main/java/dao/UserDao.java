package dao;

import pojo.User;

import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-06-29 08:17
 * @Description:用户Dao接口
 */
public interface UserDao {
    /**
     * 增加用户
     *
     * @param user
     * @throws SQLException
     */
    void addUser(User user) throws SQLException;

    /**
     * 查找用户，比较用户名和密码
     *
     * @param user
     * @return num =1代表有匹配行
     * @throws SQLException
     */
    int equalsUser(User user) throws SQLException;

}
