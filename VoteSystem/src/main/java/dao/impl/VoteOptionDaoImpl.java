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
}
