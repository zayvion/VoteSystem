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
 * @Date: 2019-06-29 08:53
 * @Description:用户注册Servlet
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        try {
            int id = userService.addUser(user).intValue();
            req.getSession().setAttribute("userid",id);
            req.setAttribute("msg", "注册成功，请登录！");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("插入失败！");
        }
    }
}
