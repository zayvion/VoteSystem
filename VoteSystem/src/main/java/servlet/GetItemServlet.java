package servlet;

import com.google.gson.Gson;
import dao.VoteItemDao;
import dao.impl.VoteItemDaoImpl;
import pojo.VoteItem;
import pojo.VoteItemSubject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-02 11:45
 * @Description:
 */
public class GetItemServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        VoteItemDao voteItemDao = new VoteItemDaoImpl();
        VoteItemSubject subject = new VoteItemSubject();
        subject.setId(id);
        try {
            VoteItem item = voteItemDao.getVoteItem(subject);
            //转换成json格式传到页面
            String json = new Gson().toJson(item);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
