package service.impl;

import dao.VoteDao;
import dao.impl.VoteDaoImpl;
import pojo.Vote;
import service.VoteService;

import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-03 13:15
 * @Description:投票操作Service实现类
 */
public class VoteServiceImpl implements VoteService {
    @Override
    public void vote(Vote vote) throws SQLException {
        VoteDao voteDao = new VoteDaoImpl();
        voteDao.vote(vote);
    }
}
