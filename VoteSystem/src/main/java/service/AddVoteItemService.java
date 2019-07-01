package service;

import pojo.VoteItemSubject;
import pojo.VoteOption;

import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 19:39
 * @Description:增加投票题目Service
 */
public interface AddVoteItemService {
    /**
     * 进行投票的联表插入
     * @throws SQLException
     */
    void addVoteItem(VoteItemSubject voteItemSubject , VoteOption voteOption) throws SQLException;
}
