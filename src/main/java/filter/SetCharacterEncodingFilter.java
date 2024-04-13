package filter;


import jakarta.servlet.annotation.WebFilter;

import javax.servlet.*;
import java.io.IOException;

// ����jsp��ȡ���ݵı����ʽ�����post������������Ĺ�����
// ������jspʹ��
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
        // 设置http请求字符编码
        request.setCharacterEncoding(encoding);

        // 设置http响应字符编码
        response.setContentType("text/html;charset="+encoding);

        chain.doFilter(request, response);

    }

}
