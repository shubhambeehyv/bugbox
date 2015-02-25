package com.beehyv.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.beehyv.dao.impl.UsersDAOimpl;
import com.beehyv.modal.User;

@SuppressWarnings("serial")
public class NewUserServlet extends HttpServlet{
	UsersDAOimpl userDAO = new UsersDAOimpl();
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// response.getWriter().write("<html><body>GET response</body></html>");
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		System.out.println(username);
		User checkUser = userDAO.getUserByUserName(username);
		System.out.println(checkUser.getUserName());
		if (checkUser.getUserName() != null)
		{
			
			System.out.println("same User");
			
			response.sendRedirect("Login.jsp?sameUserError=yes");
			return;
		}
		
		
			User newuser = new User();
			newuser.setUserName(username);
			newuser.setPassWord(password);
			userDAO.addUser(newuser);
			User currentUser = userDAO.getUserByUserName(username);
			
		
		
		
			HttpSession session = request.getSession(true);
			
			session.setAttribute("user", currentUser);
			session.setAttribute("userId", currentUser.getIdUser());
			session.setAttribute("userName", currentUser.getUserName());
			session.setMaxInactiveInterval(10*60);
			Cookie userCookie = new Cookie("user",username);
			userCookie.setMaxAge(30*60);
			response.addCookie(userCookie);
			
			System.out.println("Cookie set");
			response.sendRedirect("Projects.jsp");
		
		

	}
	

}
