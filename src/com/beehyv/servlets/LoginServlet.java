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
public class LoginServlet extends HttpServlet {
	
	UsersDAOimpl userDAO = new UsersDAOimpl();
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// response.getWriter().write("<html><body>GET response</body></html>");
		String paramusername = (String) request.getParameter("username");
		String parampassword = (String) request.getParameter("password");
		
		int idCurrentUser = userDAO.authenticate(paramusername, parampassword);
		if(idCurrentUser !=0)
		{
			HttpSession session = request.getSession(true);
			User currentUser = userDAO.getUserById(idCurrentUser);
			session.setAttribute("user", currentUser);
			session.setAttribute("userId", currentUser.getIdUser());
			session.setAttribute("userName", currentUser.getUserName());
			session.setMaxInactiveInterval(10*60);
			Cookie userCookie = new Cookie("user",paramusername);
			userCookie.setMaxAge(30*60);
			response.addCookie(userCookie);
			
			System.out.println("Cookie set");
			response.sendRedirect("Projects.jsp");
		}
		else
			response.sendRedirect("Login.jsp?error=login");
		

	}

}
