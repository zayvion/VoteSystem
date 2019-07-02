import dao.VoteItemDao;
import dao.impl.VoteItemDaoImpl;
import org.junit.Test;
import pojo.VoteItem;
import pojo.VoteItemSubject;
import pojo.VoteOption;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 20:40
 * @Description:
 */
public class voteItemTest {

    @Test
    public void testGetItem(){
        VoteItemSubject subject = new VoteItemSubject();
        subject.setId(1);
        VoteItemDaoImpl voteItemDao = new VoteItemDaoImpl();
        try {
            VoteItem item = voteItemDao.getVoteItem(subject);
            System.out.println(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void update(){
        VoteItemSubject subject = new VoteItemSubject(1,"最好用的聊天工具",1,new java.sql.Timestamp(new java.util.Date().getTime()),new java.sql.Timestamp(new java.util.Date().getTime()));
        ArrayList<VoteOption> list = new ArrayList<>();
        list.add(new VoteOption(1,"黄云",1));
        list.add(new VoteOption(2,"xxx",1));
        VoteItemDao voteItemDao = new VoteItemDaoImpl();
        try {
            voteItemDao.updateVoteItem(subject, list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
