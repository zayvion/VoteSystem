package servlet;

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
 * @Date: 2019-07-05 15:04
 * @Description:修改用户信息和删除用户信息Servlet
 */
public class UpdataUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        UserService userService = new UserServiceImpl();
        User user = new User();
        //修改用户信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        int status = Integer.parseInt(req.getParameter("status"));
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setId(id);
        user.setStatus(status);
        try {
            userService.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
