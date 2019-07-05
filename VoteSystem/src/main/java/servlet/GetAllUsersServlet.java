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
import java.util.List;

/**
 * @Auther: zayvion
 * @Date: 2019-07-05 09:38
 * @Description:
 */
public class GetAllUsersServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        try {
            List<User> list = userService.getAllusers();
            Gson gson = new Gson();
            String json = gson.toJson(list);
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write(json);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
