package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-06-29 08:51
 * @Description:
 */
public class UserServiceImpl implements UserService {
    @Override
    public Long addUser(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        //对user对象进行补全，默认type=0为用户，status=1为正常状态
        user.setType(1);
        user.setStatus(1);
        Long id = userDao.addUser(user);
        return  id ;
    }

    @Override
    public int equalsUser(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        int id = userDao.equalsUser(user);
        return id;
    }

    @Override
    public boolean isUserRepeat(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        boolean isrepeat = userDao.isUserRepeat(user);
        return isrepeat;
    }
}
