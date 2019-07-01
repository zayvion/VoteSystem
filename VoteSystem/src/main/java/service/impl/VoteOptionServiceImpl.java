package service.impl;

import dao.VoteOptionDao;
import dao.impl.VoteOptionDaoImpl;
import pojo.VoteOption;
import service.VoteOptionService;

import java.sql.SQLException;

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
}
