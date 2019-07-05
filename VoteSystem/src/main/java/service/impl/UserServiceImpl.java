package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import pojo.User;
import service.UserService;

import java.sql.SQLException;
import java.util.List;

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

    @Override
    public List<User> getAllusers() throws SQLException {
        UserDao userDao = new UserDaoImpl();
        List<User> list = userDao.getAllusers();
        return list;
    }

    @Override
    public User getUser(int id) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUser(id);
        return user;
    }

    @Override
    public void updateUser(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        userDao.updateUser(user);
    }

    @Override
    public void delUser(int id) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        userDao.delUser(id);
    }
}
