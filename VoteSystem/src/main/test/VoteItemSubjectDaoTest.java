import org.junit.Test;
import pojo.VoteItemSubject;
import service.VoteItemSubjectService;
import service.impl.VoteItemSubjectServiceImpl;

import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 17:08
 * @Description:
 */
public class VoteItemSubjectDaoTest {
    @Test
    public void testSubjectAdd(){
        VoteItemSubjectService itemService = new VoteItemSubjectServiceImpl();
        try {
            itemService.addVoteItemSubject(new VoteItemSubject("最喜欢的歌曲",0,new java.sql.Timestamp(new java.util.Date().getTime()),new java.sql.Timestamp(new java.util.Date().getTime())));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
