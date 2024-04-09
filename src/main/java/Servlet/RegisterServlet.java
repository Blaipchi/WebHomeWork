package Servlet;

import jakarta.servlet.annotation.WebServlet;
import pojo.valueobject.MessageModel;
import service.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    // 实例化RegisterService对象
    private RegisterService registerService = new RegisterService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收客户端的请求（接收参数：用户名、密码）
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2. 调用service层的方法，返回消息模型对象
        MessageModel messageModel = registerService.registerUser(username, password);

        // 3. 判断消息模型的状态码
        if (messageModel.getCode() == 1) { // 注册成功
            // 重定向跳转到注册成功提示页面或直接返回首页
            response.sendRedirect("register_success.jsp");
        } else { // 注册失败
            // 将消息模型对象设置到request作用域中，请求转发跳转到register.jsp
            request.setAttribute("messageModel", messageModel);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
