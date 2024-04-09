package Servlet;

import dao.UsersDAO;
import jakarta.servlet.annotation.WebServlet;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 接收客户端的请求（接收参数：用户名、密码）
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user0 = new User();
        user0.setUsername(username);
        user0.setPassword(password);

        UsersDAO usersDAO = new UsersDAO();
        if(usersDAO.addUser(user0)){
            //注册成功
            response.sendRedirect(request.getContextPath() + "/LoginPage/login.jsp");
        }else {
            //注册失败
            response.sendRedirect(request.getContextPath() + "/LoginPage/Register.jsp");
        }

    }
}
