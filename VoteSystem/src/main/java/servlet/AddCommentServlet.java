package servlet;

import dao.CommentDao;
import dao.impl.CommentDaoImpl;
import pojo.Comment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-09 23:22
 * @Description:添加新评论
 */
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commentContent = req.getParameter("comment_content");
        String userFlag = (String) req.getSession().getAttribute("userFlag");
        int sid = Integer.parseInt(req.getParameter("sid"));
        int userid = (int) req.getSession().getAttribute("userid");
        CommentDao commentDao = new CommentDaoImpl();
        try {
            commentDao.addComment(new Comment(userid,sid,userFlag,commentContent,null));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
