package dao;

import pojo.VoteOption;

import java.sql.SQLException;

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
}
