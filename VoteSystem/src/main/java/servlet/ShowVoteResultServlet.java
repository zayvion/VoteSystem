package servlet;

import pojo.VoteItemSubject;
import service.VoteItemSubjectService;
import service.impl.VoteItemSubjectServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-02 23:01
 * @Description:
 */
public class ShowVoteResultServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        VoteItemSubject sub = new VoteItemSubject(id);
        VoteItemSubjectService voteItemSubjectService = new VoteItemSubjectServiceImpl();
        try {
            VoteItemSubject subject = voteItemSubjectService.getVoteItemSubject(sub);
            req.setAttribute("endTime",sub.getEffective_time());
            req.setAttribute("title", subject.getTitle());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("vote_result.jsp").forward(req, resp);
    }
}
