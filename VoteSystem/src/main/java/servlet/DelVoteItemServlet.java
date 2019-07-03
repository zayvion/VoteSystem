package servlet;

import service.VoteItemService;
import service.impl.VoteItemServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-02 22:35
 * @Description:
 */
public class DelVoteItemServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        VoteItemService voteItemService = new VoteItemServiceImpl();
        try {
            voteItemService.delVoteItem(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
