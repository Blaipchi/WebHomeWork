package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import pojo.User;

public class UpdateUserInfoServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("age"));


		Integer uid = (Integer) request.getSession().getAttribute("uid");

		System.out.println(uid);

		//String uid = "1";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));

		UsersDAO userDAO = new UsersDAO();
		User user = new User();

		user.setUid(uid);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setAge(age);

		boolean temp = userDAO.updateUserInfo(user);

		if(temp == true) {
			System.out.println("修改成功！");
		}
		else {
			System.out.println("修改失败！");
		}
		response.sendRedirect(request.getContextPath() + "/AdminPages/user.jsp");
	}
}
