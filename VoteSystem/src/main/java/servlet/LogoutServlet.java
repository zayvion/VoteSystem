package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: zayvion
 * @Date: 2019-06-29 15:21
 * @Description:登出servlet
 */
public class LogoutServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        StringBuffer url = req.getRequestURL();
        resp.sendRedirect(url.substring(0,url.lastIndexOf("/")));
    }
}
