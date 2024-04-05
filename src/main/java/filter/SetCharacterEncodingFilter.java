package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 设置jsp读取数据的编码格式，解决post请求中文乱码的过滤器
// 对所有jsp使用
@WebFilter("/*")
public class SetCharacterEncodingFilter implements Filter {

    protected String encoding = "UTF-8";

    public void destroy(){

        this.encoding = null;

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException

    {

        request.setCharacterEncoding(encoding);

        response.setContentType("text/html;charset="+encoding);

        chain.doFilter(request, response);

    }

}
