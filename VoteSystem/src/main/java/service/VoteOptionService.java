package service;

import pojo.VoteOption;

import java.sql.SQLException;
import java.util.List;

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
    /**
     * 获取一道题的所有选项
     *
     * @return id
     * @throws SQLException
     */
    List<VoteOption> getOptions (int subjectId) throws SQLException;

    /**
     * 获取一个选项多少人选中
     *
     * @param optionId
     * @return
     * @throws SQLException
     */
    int getIsSelectedNum(int optionId) throws SQLException;
    /**
     * 计算一个主题所有选项被选中多少次
     *
     * @param subjectId
     * @return
     * @throws SQLException
     */
    int getAllSelectedSum(int subjectId) throws SQLException;

}
