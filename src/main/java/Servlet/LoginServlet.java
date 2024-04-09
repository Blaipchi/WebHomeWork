package Servlet;

import jakarta.servlet.annotation.WebServlet;
import pojo.valueobject.MessageModel;
import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    //实例化LoginService对象
    private LoginService loginService = new LoginService();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收客户端的请求(接收参数:姓名、密码)
        String uname = request.getParameter("username");
        String upwd = request.getParameter("password");
        //2.调用service层的方法，返回消息模型对象
        MessageModel messageModel = new MessageModel();
        //3.判断消息模型的状态码
        if (messageModel.getCode() == 1)//登录成功
        {
            //将消息模型中的用户信息设置到session作用域中，重定向跳转到user.jsp
            request.getSession().setAttribute("user",messageModel.getObject());
            response.sendRedirect("user.jsp");
        }
        else//登录失败
        {
            // 将消息模型对象设置到request作用域中，请求转发跳转到login.jsp
            request.setAttribute("messageModel",messageModel);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}