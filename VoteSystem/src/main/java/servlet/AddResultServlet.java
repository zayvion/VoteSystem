package servlet;

import pojo.Vote;
import service.VoteService;
import service.impl.VoteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-03 11:37
 * @Description:
 */
public class AddResultServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int type = Integer.parseInt(req.getParameter("type"));
        VoteService voteService = new VoteServiceImpl();
        System.out.println(type);
        if (type == 0) {
            int s_id = Integer.parseInt(req.getParameter("s_id"));
            int o_id = Integer.parseInt(req.getParameter("o_id"));
            int userid = Integer.parseInt(req.getParameter("userid"));
            Vote vote = new Vote();
            vote.setO_id(o_id);
            vote.setS_id(s_id);
            vote.setU_id(userid);
            try {
                voteService.vote(vote);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if (type == 1){
            int s_id = Integer.parseInt(req.getParameter("s_id"));
            int userid = Integer.parseInt(req.getParameter("userid"));
            int length = Integer.parseInt(req.getParameter("length"));
            for (int i = 0;i<length;i++){
                Vote vote = new Vote();
                vote.setO_id(Integer.parseInt(req.getParameter("o_id["+i+"][value]")));
                vote.setS_id(s_id);
                vote.setU_id(userid);
                try {
                    voteService.vote(vote);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        }
    }
