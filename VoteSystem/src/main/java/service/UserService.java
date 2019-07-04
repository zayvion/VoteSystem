package service;

import pojo.User;

import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-06-29 08:49
 * @Description:用户接口
 */
public interface UserService {
    /**
     * 增加用户
     *
     * @param user
     * @throws SQLException
     */
    Long addUser(User user) throws SQLException;

    /**
     * 查找用户，比较用户名和密码
     *
     * @param user
     * @return id
     * @throws SQLException
     */
    int equalsUser(User user) throws SQLException;

    /**
     * 判断用户是否重复
     *
     * @param user
     * @return true 表示重复 false表示未重复
     * @throws SQLException
     */
    boolean isUserRepeat(User user) throws SQLException;
}
