package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import pojo.User;


public class DeleteUserServlet extends HttpServlet  {

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		int uid;
		uid = Integer.parseInt(request.getParameter("uid"));

		UsersDAO usersDAO = new UsersDAO();
		User user = new User();
		user.setUid(uid);
		boolean temp = usersDAO.deleteUser(user);
		if(temp == true) {
			System.out.println("删除成功！");
		}
		else {
			System.out.println("删除失败！");
		}
		response.sendRedirect(request.getContextPath() + "/AdminPages/admin.jsp");
	}
}
