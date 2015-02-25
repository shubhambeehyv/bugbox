package com.beehyv.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beehyv.dao.impl.ProjectDAOimpl;
import com.beehyv.modal.Project;

@SuppressWarnings("serial")
public class NewProjectServlet extends HttpServlet{
	ProjectDAOimpl projectDAO = new ProjectDAOimpl();

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String projectname = request.getParameter("projectname");
		String projectdescription = request.getParameter("projectdescription");
		Project newproject = new Project();
		newproject.setProjectName(projectname);
		newproject.setDescription(projectdescription);
		projectDAO.addProject(newproject);
		response.sendRedirect("Projects.jsp");
		
		
		
	}
	
	
}
