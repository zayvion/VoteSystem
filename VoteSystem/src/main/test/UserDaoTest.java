import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.junit.Test;
import pojo.User;

import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-06-29 08:42
 * @Description:
 */
public class UserDaoTest {

    @Test
    public void testAdd() throws SQLException {
        UserDao dao = new UserDaoImpl();
        User user = new User("user1","psw1",1,1);
        dao.addUser(user);
    }

    @Test
    public void testEquals() throws SQLException {
        UserDao dao = new UserDaoImpl();
        User user = new User("admin","admn");
        System.out.println( dao.equalsUser(user));
    }
}
