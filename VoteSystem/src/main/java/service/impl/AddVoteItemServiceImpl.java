package service.impl;

import dao.AddVoteItemDao;
import dao.impl.AddVoteItemDaoImpl;
import pojo.VoteItemSubject;
import pojo.VoteOption;
import service.AddVoteItemService;

import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 19:41
 * @Description:增加投票题目Service实现类
 */
public class AddVoteItemServiceImpl implements AddVoteItemService {
    @Override
    public void addVoteItem(VoteItemSubject voteItemSubject, VoteOption voteOption) throws SQLException {
        AddVoteItemDao addVoteItemDao = new AddVoteItemDaoImpl();;
        voteItemSubject.setCreate_time(new java.sql.Timestamp(new java.util.Date().getTime()));
        addVoteItemDao.addVoteItem(voteItemSubject,voteOption);
    }
}
