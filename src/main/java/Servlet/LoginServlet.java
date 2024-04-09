package Servlet;

import dao.UsersDAO;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收客户端的请求(接收参数:姓名、密码)
        String uname = request.getParameter("username");
        String upwd = request.getParameter("password");

        UsersDAO userdao = new UsersDAO();

        //3.判断消息模型的状态码
        if (userdao.checkLogin(uname,upwd))//登录成功
        {
            User user0 = UsersDAO.checkFlag(uname,upwd);
            request.getSession().setAttribute("user",user0);

            System.out.println( user0);

            //判断权限
            if (user0.getFlag() == 1)
            {//普通用户
                response.sendRedirect(request.getContextPath() + "/AdminPages/user.jsp");
            }
            else if (user0.getFlag() == 0)
            {//管理员
                response.sendRedirect(request.getContextPath() + "/AdminPages/admin.jsp");
            }
        }
        else//登录失败
        {
            // 返回登录页面
            response.sendRedirect(request.getContextPath() + "/LoginPage/login.jsp");
        }
    }
}