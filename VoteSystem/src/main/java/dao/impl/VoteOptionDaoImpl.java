package dao.impl;

import dao.VoteItemSubjectDao;
import dao.VoteOptionDao;
import pojo.VoteItemSubject;
import pojo.VoteOption;
import utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-01 17:58
 * @Description:投票选项Dao接口实现类
 */
public class VoteOptionDaoImpl implements VoteOptionDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public int addVoteOption(VoteOption voteOption) throws SQLException {
        conn = JDBCUtils.getConn();
        int num = 0;
        String sql = "INSERT INTO `t_vote_option`(`option`, `s_id`) VALUES (?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(2,voteOption.getS_id());
        ps.setString(1, voteOption.getOption());
        try {
            num = ps.executeUpdate();
            System.out.println("增加了"+num+"行数据");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,ps);
        }
        return num;
    }

    @Override
    public List<VoteOption> getOptions(VoteItemSubject voteItemSubject) throws SQLException {
        conn = JDBCUtils.getConn();
        List<VoteOption> list = new ArrayList<>();
        String sql = "SELECT * FROM `t_vote_option` WHERE `s_id`=?";
        ps = conn.prepareStatement(sql);
        try {
            ps.setInt(1,voteItemSubject.getId());
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String option = rs.getString("option");
                int s_id = rs.getInt("s_id");
                VoteOption voteOption = new VoteOption();
                voteOption.setId(id);
                voteOption.setOption(option);
                voteOption.setS_id(s_id);
                list.add(voteOption);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,ps);
        }
        return list;
    }
}
