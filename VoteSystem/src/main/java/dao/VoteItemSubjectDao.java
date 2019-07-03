package dao;


import pojo.VoteItemSubject;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-06-29 19:33
 * @Description:投票主题Dao接口
 */
public interface VoteItemSubjectDao {
    /**
     * 新建投票主题
     *
     * @param voteItemSubject
     * @return Long id 主键
     * @throws SQLException
     */
    Long addVoteItem(VoteItemSubject voteItemSubject) throws SQLException;

    /**
     * 取出所有投票主题
     *
     * @return List<VoteItem> 投票列表
     * @throws SQLException
     */
    List<VoteItemSubject> getAllVoteItem(int id) throws SQLException;

    /**
     * 取单条投票主题
     *
     * @return
     * @throws SQLException
     */
    VoteItemSubject getVoteItemSubject(VoteItemSubject voteItemSubject) throws SQLException;
}
