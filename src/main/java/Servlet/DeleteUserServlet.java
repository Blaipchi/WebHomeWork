package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteUserServlet extends HttpServlet  {
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		String uid = request.getParameter("uid");

	}
}
