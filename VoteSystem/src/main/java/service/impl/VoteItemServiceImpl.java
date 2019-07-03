package service.impl;

import dao.VoteItemDao;
import dao.impl.VoteItemDaoImpl;
import pojo.VoteItemSubject;
import pojo.VoteOption;
import service.VoteItemService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 19:41
 * @Description:增加投票题目Service实现类
 */
public class VoteItemServiceImpl implements VoteItemService {
    @Override
    public void updateVoteItem(VoteItemSubject voteItemSubject, List<VoteOption> options) throws SQLException {
        VoteItemDao voteItemDao = new VoteItemDaoImpl();
        voteItemSubject.setUpdate_time(new java.sql.Timestamp(new java.util.Date().getTime()));
        voteItemDao.updateVoteItem(voteItemSubject,options);
    }

    @Override
    public void addVoteItem(VoteItemSubject voteItemSubject, VoteOption voteOption) throws SQLException {
        VoteItemDao addVoteItemDao = new VoteItemDaoImpl();;
        voteItemSubject.setCreate_time(new java.sql.Timestamp(new java.util.Date().getTime()));
        addVoteItemDao.addVoteItem(voteItemSubject,voteOption);
    }

    @Override
    public void delVoteItem(int id) throws SQLException {
        VoteItemDao voteItemDao = new VoteItemDaoImpl();
        voteItemDao.delVoteItem(id);
    }
}
