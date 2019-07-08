package service;

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
    List<VoteItemSubject> getAllVoteItemSubject( int id ) throws SQLException;

    /**
     * 取单条投票主题
     *
     * @return
     * @throws SQLException
     */
    VoteItemSubject getVoteItemSubject(VoteItemSubject voteItemSubject) throws SQLException;
    /**
     * 判断是否参加过投票
     * @param sid uid
     * @return boolean
     * @throws SQLException
     */
    boolean isJoin(int sid,int uid) throws SQLException;

    /**
     * 获取参加投票的人次
     *
     * @param sid
     * @return
     * @throws SQLException
     */
    int getJoinNum (int sid) throws SQLException;

    /**
     * 获取选项个数
     *
     * @param sid
     * @return
     * @throws SQLException
     */
    int getOptionNum (int sid) throws SQLException;

    /**
     * 按条件取出对应Subject
     * @param id
     * @return List<VoteItemSubject>
     * @throws SQLException
     */
    List<VoteItemSubject> getSearchVoteItem(int id, String condition) throws SQLException;


}
