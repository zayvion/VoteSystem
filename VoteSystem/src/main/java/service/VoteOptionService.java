package service;

import pojo.VoteOption;

import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 18:55
 * @Description:投票选项Service接口
 */
public interface VoteOptionService  {
    /**
     * 增加投票的选项
     *
     * @param voteOption
     * @return int 增加的行数
     * @throws SQLException
     */
    int addVoteOption(VoteOption voteOption) throws SQLException;

}
