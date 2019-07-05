package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: zayvion
 * @Date: 2019-07-04 23:52
 * @Description:管理员拦截器
 */
public class AdminFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        try {
            int userid = (int) httpServletRequest.getSession().getAttribute("userid");
            if (userid == 1){
                chain.doFilter(req, resp);
            }else {
                httpServletResponse.sendRedirect("/");
            }
        } catch (IOException e) {
            e.printStackTrace();
            httpServletResponse.sendRedirect("/");
        } catch (Exception e) {
            httpServletResponse.sendRedirect("/");
            e.printStackTrace();
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
