package service.impl;


import dao.VoteItemSubjectDao;
import dao.impl.VoteItemSubjectDaoImpl;
import pojo.VoteItemSubject;
import service.VoteItemSubjectService;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 10:00
 * @Description:投票ItemSubjectService接口实现类
 */
public class VoteItemSubjectServiceImpl implements VoteItemSubjectService {
    Connection conn =null;
    PreparedStatement ps =null;
    ResultSet rs = null;

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
    public List<VoteItemSubject> getAllVoteItemSubject(int id) throws SQLException {
        VoteItemSubjectDao voteItemSubjectDao = new VoteItemSubjectDaoImpl();
        List<VoteItemSubject> list = voteItemSubjectDao.getAllVoteItem(id);
        return list;
    }

    @Override
    public VoteItemSubject getVoteItemSubject(VoteItemSubject voteItemSubject) throws SQLException {
        VoteItemSubjectDao voteItemSubjectDao = new VoteItemSubjectDaoImpl();
        VoteItemSubject subject = voteItemSubjectDao.getVoteItemSubject(voteItemSubject);
        return subject;
    }


    @Override
    public boolean isJoin(int sid, int uid) throws SQLException {
        int num = 0;
        conn = JDBCUtils.getConn();
        String sql = "SELECT COUNT(*) FROM t_join_vote WHERE `u_id`=? AND s_id =?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,uid);
        ps.setInt(2,sid);
        rs = ps.executeQuery();
        while (rs.next()) {
            num = rs.getInt(1);
        }
        if (num > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getJoinNum(int sid) throws SQLException {
        int num = 0;
        conn = JDBCUtils.getConn();
        String sql = "SELECT COUNT(*) FROM t_join_vote WHERE s_id =?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,sid);
        rs = ps.executeQuery();
        while (rs.next()) {
            num = rs.getInt(1);
        }
        return num;
    }

    @Override
    public int getOptionNum(int sid) throws SQLException {
        int num = 0;
        conn = JDBCUtils.getConn();
        String sql = "SELECT COUNT(*) FROM t_vote_option WHERE s_id =?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1,sid);
        rs = ps.executeQuery();
        while (rs.next()) {
            num = rs.getInt(1);
        }
        return num;
    }
}
