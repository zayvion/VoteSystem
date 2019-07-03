package service;

import pojo.Vote;

import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-03 13:13
 * @Description:投票操作Service
 */
public interface VoteService {
    /**
     * 进行投票操作
     *
     * @param vote
     * @throws SQLException
     */
    void vote(Vote vote) throws SQLException;
}
