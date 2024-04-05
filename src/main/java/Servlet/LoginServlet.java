package Servlet;
import bean.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UsersDAO usersDAO = new UsersDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginUser = new User(username, password);

        if (usersDAO.checkLogin(loginUser)) {
            // 登录成功，可以在此处设置 session、跳转到主页面等
            response.getWriter().println("Login successful!");
        } else {
            response.getWriter().println("Invalid username or password. Please try again.");
        }
    }
}
