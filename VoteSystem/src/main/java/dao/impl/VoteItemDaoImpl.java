package dao.impl;

import dao.VoteItemDao;
import dao.VoteItemSubjectDao;
import dao.VoteOptionDao;
import pojo.VoteItem;
import pojo.VoteItemSubject;
import pojo.VoteOption;
import utils.JDBCUtils;

import java.sql.*;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 19:25
 * @Description:增加投票题目Dao实现类
 */
public class VoteItemDaoImpl implements VoteItemDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private PreparedStatement ps1 = null;
    private PreparedStatement ps2 = null;
    private PreparedStatement ps3 = null;
    private ResultSet rs = null;

    @Override
    public void addVoteItem(VoteItemSubject voteItemSubject , VoteOption voteOption) throws SQLException {
        conn = JDBCUtils.getConn();
        Long id =0l;
        conn.setAutoCommit(false);
        String sql1 = "INSERT INTO `t_vote_subject`(`title`, `type`, `oper_user`,`create_date`, `update_date`) VALUES (?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO `t_vote_option`(`option`, `s_id`) VALUES (?, ?)";
        try {
            ps1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps1.setInt(2,voteItemSubject.getType());
            ps1.setString(1,voteItemSubject.getTitle());
            ps1.setInt(3,voteItemSubject.getOper_user());
            ps1.setTimestamp(4, (Timestamp) voteItemSubject.getCreate_time());
            ps1.setTimestamp(5, (Timestamp) voteItemSubject.getUpdate_time());
            ps1.executeUpdate();
            rs = ps1.getGeneratedKeys();
            if(rs.next()){
                id  = rs.getLong(1);
            }

            ps2 = conn.prepareStatement(sql2);
            voteOption.setS_id(Integer.parseInt(id.toString()));
            ps2.setInt(2,voteOption.getS_id());
            ps2.setString(1, voteOption.getOption());
            ps2.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,ps1);
            JDBCUtils.release(conn,ps2);
        }

    }

    @Override
    public VoteItem getVoteItem(VoteItemSubject voteItemSubject) throws SQLException {
        VoteItem voteItem = new VoteItem();
        VoteItemSubjectDao voteItemSubjectDao = new VoteItemSubjectDaoImpl();
        VoteItemSubject subject = voteItemSubjectDao.getVoteItemSubject(voteItemSubject);
        VoteOptionDao voteOptionDao = new VoteOptionDaoImpl();
        List<VoteOption> optionList = voteOptionDao.getOptions(voteItemSubject.getId());

        voteItem.setOptions(optionList);
        voteItem.setId(subject.getId());
        voteItem.setType(subject.getType());
        voteItem.setTitle(subject.getTitle());
        voteItem.setCreate_date(subject.getCreate_time());
        voteItem.setUpdate_date(subject.getUpdate_time());
        return voteItem;
    }

    @Override
    public void updateVoteItem(VoteItemSubject voteItemSubject,List<VoteOption> options) throws SQLException {
        conn = JDBCUtils.getConn();
        Long id =0l;
        conn.setAutoCommit(false);
        String sql1 ="UPDATE `t_vote_subject` SET `title` = ?, `type` = ? ,`oper_user`= ?,`update_date` = ? WHERE id = ? ";
        String sql2 ="UPDATE `t_vote_option` SET `option` = ? WHERE id = ?";
        try {
            ps1 = conn.prepareStatement(sql1);
            ps1.setString(1, voteItemSubject.getTitle());
            ps1.setInt(2, voteItemSubject.getType());
            ps1.setInt(3,voteItemSubject.getOper_user());
            ps1.setTimestamp(4, (Timestamp) voteItemSubject.getUpdate_time());
            ps1.setInt(5, voteItemSubject.getId());
            ps1.executeUpdate();
            for(VoteOption option : options){
                ps2 = conn.prepareStatement(sql2);
                ps2.setString(1, option.getOption());
                ps2.setInt(2,option.getId());
                ps2.executeUpdate();
                conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            JDBCUtils.release(conn,ps1);
            JDBCUtils.release(conn,ps2);
        }
    }

    @Override
    public void delVoteItem(int id) throws SQLException {
        conn = JDBCUtils.getConn();
        conn.setAutoCommit(false);
        String sql1 ="DELETE FROM `t_vote_option` WHERE `s_id` =  ?";
        String sql2 ="DELETE FROM `t_vote_subject` WHERE `id` =  ?";
        String sql3 ="DELETE FROM `t_join_vote` WHERE `s_id` =  ?";
        try {
            ps1 = conn.prepareStatement(sql1);
            ps1.setInt(1, id);
            int num1 = ps1.executeUpdate();
            ps2 = conn.prepareStatement(sql2);
            ps2.setInt(1, id);
            int num2 = ps2.executeUpdate();
            ps3 = conn.prepareStatement(sql3);
            ps3.setInt(1, id);
            int num3 = ps3.executeUpdate();
            conn.commit();
            System.out.println("删除"+num1+num2+num3+"行");
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            JDBCUtils.release(conn,ps1);
            JDBCUtils.release(conn,ps2);
            JDBCUtils.release(conn,ps3);
        }
    }
}
