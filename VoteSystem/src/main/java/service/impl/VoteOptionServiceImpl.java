package service.impl;

import dao.VoteOptionDao;
import dao.impl.VoteOptionDaoImpl;
import pojo.VoteOption;
import service.VoteOptionService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 18:58
 * @Description:投票选项Service接口实现类
 */
public class VoteOptionServiceImpl implements VoteOptionService {
    @Override
    public int addVoteOption(VoteOption voteOption) throws SQLException {
        VoteOptionDao voteOptionDao = new VoteOptionDaoImpl();
        int i = voteOptionDao.addVoteOption(voteOption);
        return i;
    }

    @Override
    public List<VoteOption> getOptions(int subjectId) throws SQLException {
        VoteOptionDao voteOptionDao = new VoteOptionDaoImpl();
        List<VoteOption> options = new ArrayList<>();
        try {
            options = voteOptionDao.getOptions(subjectId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return options;
    }

    @Override
    public int getIsSelectedNum(int optionId) throws SQLException {
        VoteOptionDao voteOptionDao = new VoteOptionDaoImpl();
        int num = voteOptionDao.getIsSelectedNum(optionId);
        return num;
    }

    @Override
    public int getAllSelectedSum(int subjectId) throws SQLException {
        VoteOptionDao voteOptionDao = new VoteOptionDaoImpl();
        int sum = voteOptionDao.getAllSelectedSum(subjectId);
        return sum;
    }
}
