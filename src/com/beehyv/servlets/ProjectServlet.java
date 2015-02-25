package com.beehyv.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.beehyv.dao.ProjectDAO;
import com.beehyv.dao.impl.ProjectDAOimpl;
import com.beehyv.modal.Project;

@SuppressWarnings("serial")
public class ProjectServlet extends HttpServlet {
	
	ProjectDAO projectDAO = new ProjectDAOimpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("In ProjectServlet");
		List<Project> projects = projectDAO.getProjects();
		req.setAttribute("projects",projects);
		Gson gson = new Gson();
		String projectsJSON = gson.toJson(projects);
		PrintWriter out = resp.getWriter();
		out.write(projectsJSON);
		
	}
}
