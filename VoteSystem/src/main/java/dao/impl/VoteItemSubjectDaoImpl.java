package dao.impl;

import dao.VoteItemSubjectDao;
import pojo.VoteItemSubject;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 16:39
 * @Description:投票主题Dao接口实现类
 */
public class VoteItemSubjectDaoImpl implements VoteItemSubjectDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public Long addVoteItem(VoteItemSubject voteItemSubject) throws SQLException {
        conn = JDBCUtils.getConn();
        Long id = 0l;
        int num = 0;
        String sql = "INSERT INTO `t_vote_subject`(`title`, `type`, `oper_user`,`create_date`, `update_date`) VALUES (?, ?, ?, ?, ?)";
        ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ps.setInt(2,voteItemSubject.getType());
        ps.setString(1,voteItemSubject.getTitle());
        ps.setInt(3,voteItemSubject.getOper_user());
        ps.setTimestamp(4, (Timestamp) voteItemSubject.getCreate_time());
        ps.setTimestamp(5, (Timestamp) voteItemSubject.getUpdate_time());
        try {
            num = ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                id  = rs.getLong(1);
            }
            System.out.println("增加了"+num+"行数据"+";主键为"+id);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,ps);
        }

        return id;
    }

    @Override
    public List<VoteItemSubject> getAllVoteItem() throws SQLException {
        conn = JDBCUtils.getConn();
        List<VoteItemSubject> list = new ArrayList<>();
        String sql = "SELECT * FROM `t_vote_subject` ORDER BY `id` DESC LIMIT 0,1000";
        ps = conn.prepareStatement(sql);
        try {
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int type = rs.getInt("type");
                int userid = rs.getInt("oper_user");
                Timestamp create_time = rs.getTimestamp("create_date");
                Timestamp update_time = rs.getTimestamp("update_date");
                VoteItemSubject voteItemSubject = new VoteItemSubject(id,title, type, userid,create_time, update_time);
                list.add(voteItemSubject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,ps);
        }
        return list;
    }

    @Override
    public VoteItemSubject getVoteItemSubject(VoteItemSubject voteItemSubject) throws SQLException {
        conn = JDBCUtils.getConn();
        List<VoteItemSubject> list = new ArrayList<>();
        String sql = "SELECT * FROM `t_vote_subject` WHERE `id`=?";
        ps = conn.prepareStatement(sql);
        try {
            ps.setInt(1,voteItemSubject.getId());
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int oper_user = rs.getInt("oper_user");
                int type = rs.getInt("type");
                Timestamp create_time = rs.getTimestamp("create_date");
                Timestamp update_time = rs.getTimestamp("update_date");
                voteItemSubject.setTitle(title);
                voteItemSubject.setType(type);
                voteItemSubject.setCreate_time(create_time);
                voteItemSubject.setUpdate_time(update_time);
                voteItemSubject.setOper_user(oper_user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,ps);
        }
        return voteItemSubject;
    }
}
