package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import pojo.User;

import java.io.IOException;

public class AddAdminServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        String uid = "";
        uid = request.getParameter("uid");

        int flag ;
        flag = Integer.parseInt(request.getParameter("flag"));

        AdminDAO adminDAO = new AdminDAO();
        User user = new User();
        user.setUid(uid);
        user.setFlag(flag);
        boolean temp = adminDAO.addAdmin(user);
        if(temp == true) {
            System.out.println("修改权限成功！");
        }
        else {
            System.out.println("修改权限失败！");
        }
        response.sendRedirect("/WebHomeWork/AdminPages/admin.jsp");
    }
}
