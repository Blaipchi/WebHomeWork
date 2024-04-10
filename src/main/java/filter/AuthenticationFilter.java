package filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pojo.User;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/*"})
public class AuthenticationFilter implements Filter {

    private List<String> allowedUrls = Arrays.asList("/LoginPage/login.jsp", "/LoginPage/register.jsp");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        String requestURI = httpRequest.getRequestURI();

        if (session == null || session.getAttribute("user") == null) {
            // 用户未登录
            if (!allowedUrls.contains(requestURI)) {
                // 用户未登录且访问了非登录页面，重定向到错误页面并显示错误信息
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/error.jsp?message=您尚未登录");
                return;
            }
        } else {
            // 用户已登录
            User user = (User) session.getAttribute("user");
            if (user.getFlag() == 0 && requestURI.contains("/AdminPages/admin.jsp")) {
                // 管理员无法访问 admin.jsp，重定向到错误页面并显示错误信息
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/error.jsp?message=您没有权限访问此页面");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // 销毁代码
    }
}
