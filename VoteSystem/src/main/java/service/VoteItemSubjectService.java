package service;

import pojo.VoteItemSubject;
import pojo.VoteItemSubject;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 09:59
 * @Description:投票ItemService接口
 */
public interface VoteItemSubjectService {
    /**
     * 新建投票主题
     *
     * @param voteItemSubject
     * @return long id 主键返回
     * @throws SQLException
     */
    Long addVoteItemSubject(VoteItemSubject voteItemSubject) throws SQLException;

    /**
     * 取出所有投票主题
     *
     * @return List<VoteItem> 投票列表
     * @throws SQLException
     */
    List<VoteItemSubject> getAllVoteItemSubject() throws SQLException;

    /**
     * 取单条投票主题
     *
     * @return
     * @throws SQLException
     */
    VoteItemSubject getVoteItemSubjectById(VoteItemSubject voteItemSubject) throws SQLException;
}
