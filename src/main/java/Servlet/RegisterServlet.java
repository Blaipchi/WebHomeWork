package Servlet;
import pojo.User;
import dao.UsersDAO;
import jakarta.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    private final UsersDAO usersDAO = new UsersDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User newUser = new User(); // 默认为普通用户
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);


        if (usersDAO.addUser(newUser)) {
            // 注册成功，可以在此处添加额外处理（如发送验证邮件、跳转到欢迎页面等）
            response.getWriter().println("Registration successful!");
        } else {
            response.getWriter().println("Failed to register. Please try again.");
        }
    }
}
