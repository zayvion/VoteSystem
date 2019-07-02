package service;

import pojo.VoteItem;
import pojo.VoteItemSubject;
import pojo.VoteOption;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 19:39
 * @Description:增加投票题目Service
 */
public interface VoteItemService {
    /**
     * 更新投票题目
     *
     * @param voteItemSubject
     * @return
     * @throws SQLException
     */
    void updateVoteItem(VoteItemSubject voteItemSubject, List<VoteOption> options) throws SQLException;

    /**
     * 增加投票题目
     *
     * @param voteItemSubject
     * @param voteOption
     * @throws SQLException
     */
    void addVoteItem(VoteItemSubject voteItemSubject, VoteOption voteOption) throws SQLException;
}
