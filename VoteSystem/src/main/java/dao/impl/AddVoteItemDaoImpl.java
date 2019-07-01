package dao.impl;

import dao.AddVoteItemDao;
import pojo.VoteItemSubject;
import pojo.VoteOption;
import utils.JDBCUtils;

import java.sql.*;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 19:25
 * @Description:增加投票题目Dao实现类
 */
public class AddVoteItemDaoImpl implements AddVoteItemDao {
    private Connection conn = null;
    private PreparedStatement ps1 = null;
    private PreparedStatement ps2 = null;
    private ResultSet rs = null;

    @Override
    public void addVoteItem(VoteItemSubject voteItemSubject , VoteOption voteOption) throws SQLException {
        conn = JDBCUtils.getConn();
        Long id =0l;
        conn.setAutoCommit(false);
        String sql1 = "INSERT INTO `t_vote_subject`(`title`, `type`, `create_date`, `update_date`) VALUES (?, ?, ?,?)";
        String sql2 = "INSERT INTO `t_vote_option`(`option`, `s_id`) VALUES (?, ?)";
        try {
            ps1 = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ps1.setInt(2,voteItemSubject.getType());
            ps1.setString(1,voteItemSubject.getTitle());
            ps1.setTimestamp(3, (Timestamp) voteItemSubject.getCreate_time());
            ps1.setTimestamp(4, (Timestamp) voteItemSubject.getUpdate_time());
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
        }

    }
}
