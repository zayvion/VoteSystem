import dao.impl.VoteOptionDaoImpl;
import org.junit.Test;

import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-03 20:09
 * @Description:
 */
public class VoteOptionDaoTest {

    @Test
    public void getOptions(){
        VoteOptionDaoImpl voteOptionDao = new VoteOptionDaoImpl();
        try {
            int num = voteOptionDao.getIsSelectedNum(47);
            System.out.println(num);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
