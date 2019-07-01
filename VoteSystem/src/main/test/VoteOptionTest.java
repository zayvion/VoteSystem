import org.junit.Test;
import pojo.VoteOption;
import service.VoteOptionService;
import service.impl.VoteOptionServiceImpl;

import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 19:14
 * @Description:
 */
public class VoteOptionTest {
    @Test
    public void testVoteOption() throws SQLException {
        VoteOptionService voteOptionService = new VoteOptionServiceImpl();
        voteOptionService.addVoteOption(new VoteOption("qq",2));
    }
}
