package servlet;

import dao.VoteItemDao;
import dao.impl.VoteItemDaoImpl;
import pojo.VoteItemSubject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-03 08:42
 * @Description:
 */
public class VoteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        VoteItemDao voteItemDao = new VoteItemDaoImpl();
        VoteItemSubject subject = new VoteItemSubject();
        req.setAttribute("id",id);
        req.getRequestDispatcher("vote_oper.jsp").forward(req,resp);
    }
}
