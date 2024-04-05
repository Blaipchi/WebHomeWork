package filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
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

        request.setCharacterEncoding(encoding);

        response.setContentType("text/html;charset="+encoding);

        chain.doFilter(request, response);

    }

}
