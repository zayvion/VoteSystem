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
 * @Date: 2019-06-29 09:28
 * @Description:用户登陆Servlet
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //用户状态码，0管理员，1用户
        int num = new Integer(req.getParameter("usertype"));
        try {
            int id = userService.equalsUser(new User(username, password));
            if (id != 0) {

                //若用户登陆，则将用户标识放到session中
                req.getSession().setAttribute("userFlag", username);
                req.getSession().setAttribute("userid", id);
                resp.sendRedirect("main.jsp");
            } else {
                req.setAttribute("msg", "用户名或密码错误，请重新输入！");
                req.getRequestDispatcher("/").forward(req, resp);
            }

            /*switch (id !=null){
                case "1":
                    int num = userService.equalsUser(new User(username, password));
                    if (num == 1){
                        //若用户登陆，则将用户标识放到session中
                        req.getSession().setAttribute("userFlag",username);
                        resp.sendRedirect("main.jsp");
                    }else {
                        req.setAttribute("msg","用户名或密码错误，请重新输入！");
                        req.getRequestDispatcher("/").forward(req,resp);
                    }
                    break;
                    default:
                        req.setAttribute("msg","未知错误，请重试！");
                        req.getRequestDispatcher("/").forward(req,resp);
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
