package dao;

import pojo.VoteItemSubject;
import pojo.VoteOption;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 17:56
 * @Description:投票选项Dao接口
 */
public interface VoteOptionDao {
    /**
     * 增加投票的选项
     *
     * @param voteOption
     * @return int 增加的行数
     * @throws SQLException
     */
    int addVoteOption(VoteOption voteOption) throws SQLException;

    /**
     * 获取一道题的所有选项
     *
     * @param voteItemSubject
     * @return
     * @throws SQLException
     */
    List<VoteOption> getOptions (VoteItemSubject voteItemSubject) throws SQLException;
}
