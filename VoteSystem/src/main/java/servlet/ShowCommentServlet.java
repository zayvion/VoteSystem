package servlet;

import com.google.gson.Gson;
import pojo.Comment;
import service.CommentService;
import service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-10 00:01
 * @Description:展示主题下所有评论
 */
public class ShowCommentServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        CommentService commentService = new CommentServiceImpl();
        try {
            List<Comment> comments = commentService.getComments(sid);
            resp.setContentType("application/json;charset=utf-8");
            String json = new Gson().toJson(comments);
            resp.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
