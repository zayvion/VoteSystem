package dao;

import pojo.Vote;

import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-03 08:38
 * @Description:投票操作Dao
 */
public interface VoteDao {
    /**
     * 进行投票操作
     *
     * @param vote
     * @throws SQLException
     */
    void vote(Vote vote) throws SQLException;


}
