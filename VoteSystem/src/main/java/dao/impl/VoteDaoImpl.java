package dao.impl;

import dao.VoteDao;
import pojo.Vote;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-03 08:40
 * @Description:投票操作Dao实现类
 */
public class VoteDaoImpl implements VoteDao {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public void vote(Vote vote) throws SQLException {
        conn = JDBCUtils.getConn();
        String sql = "INSERT INTO `db_vote`.`t_join_vote`( `u_id`, `s_id`, `o_id`) VALUES (?, ?, ?);";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,vote.getU_id());
            ps.setInt(2,vote.getS_id());
            ps.setInt(3,vote.getO_id());

            int num = ps.executeUpdate();

            System.out.println("增加了"+num+"行数据");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.release(conn,ps);
        }

    }
}
