package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther: zayvion
 * @Date: 2019-06-27 11:20
 * @Description:编码过滤器
 */
public class CharsetFilter implements Filter {
    private FilterConfig config;
    //初始化配置参数
    private static final String INIT_PARAM_ENCODE="encode";
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse resp = (HttpServletResponse) response;
            String encode = config.getInitParameter(INIT_PARAM_ENCODE);
            if(encode != null && !encode.isEmpty())
            {
                req.setCharacterEncoding(encode);

            }

            chain.doFilter(request, response);

            if(encode != null && !encode.isEmpty())
            {
                resp.setCharacterEncoding(encode);
            }

    }

    public void init(FilterConfig config) throws ServletException {
        this.config=config;
    }

}
