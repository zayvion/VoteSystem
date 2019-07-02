package dao;

import pojo.VoteItem;
import pojo.VoteItemSubject;
import pojo.VoteOption;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 19:22
 * @Description:增加投票题目Dao
 */
public interface VoteItemDao {
    /**
     * 进行投票的联表插入
     *
     * @throws SQLException
     */
    void addVoteItem(VoteItemSubject voteItemSubject, VoteOption voteOption) throws SQLException;

    /**
     * 取整个题目
     *
     * @param voteItemSubject
     * @return VoteItem
     * @throws SQLException
     */
    VoteItem getVoteItem(VoteItemSubject voteItemSubject) throws SQLException;

    /**
     * 修改投票题目
     *
     * @param voteItemSubject
     * @return void
     * @throws SQLException
     */
    void updateVoteItem(VoteItemSubject voteItemSubject, List<VoteOption> options) throws SQLException;

}
