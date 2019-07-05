package servlet;

import com.google.gson.Gson;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-05 11:36
 * @Description:获取用户信息servlet
 */
public class GetUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserService userService = new UserServiceImpl();
        try {
            User user = userService.getUser(id);
            String json = new Gson().toJson(user);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
