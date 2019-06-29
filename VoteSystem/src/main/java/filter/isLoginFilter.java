package filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: zayvion
 * @Date: 2019-06-29 14:55
 * @Description:判断用户是否登录
 */
public class isLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = ( HttpServletRequest)req;
        HttpServletResponse response = ( HttpServletResponse)resp;
        String userFlag = (String) request.getSession().getAttribute("userFlag");
        if (userFlag != null) {
            chain.doFilter(req, resp);
        }else {
            response.sendRedirect("/");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
