package service.impl;



import dao.VoteItemSubjectDao;
import dao.impl.VoteItemSubjectDaoImpl;
import pojo.VoteItemSubject;
import service.VoteItemSubjectService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 10:00
 * @Description:投票ItemSubjectService接口实现类
 */
public class VoteItemSubjectServiceImpl implements VoteItemSubjectService {

    @Override
    public Long addVoteItemSubject(VoteItemSubject voteItemSubject) throws SQLException {
        Long id = 0l;
        VoteItemSubjectDao voteItemSubjectDao = new VoteItemSubjectDaoImpl();
        voteItemSubject.setCreate_time(new java.sql.Timestamp(new java.util.Date().getTime()));
        int num = 0;
        try {
            id = voteItemSubjectDao.addVoteItem(voteItemSubject);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public List<VoteItemSubject> getAllVoteItemSubject() throws SQLException {
        VoteItemSubjectDao voteItemSubjectDao = new VoteItemSubjectDaoImpl();
        List<VoteItemSubject> list = voteItemSubjectDao.getAllVoteItem();
        return list;
    }

    @Override
    public VoteItemSubject getVoteItemSubjectById(VoteItemSubject voteItemSubject) throws SQLException {
        return null;
    }
}
