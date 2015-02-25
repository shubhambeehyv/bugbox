package com.beehyv.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beehyv.dao.IssueDAO;
import com.beehyv.dao.impl.IssueDAOimpl;
import com.beehyv.modal.Issue;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class IssueServlet extends HttpServlet {
	IssueDAO issueDAO = new IssueDAOimpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("In IssueServlet");
		List<Issue> issues = issueDAO.getIssueByReleaseId(Integer.parseInt(req.getParameter("idRelease")));
		req.setAttribute("issues",issues);
		Gson gson = new Gson();
		String issuesJSON = gson.toJson(issues);
		PrintWriter out = resp.getWriter();
		out.write(issuesJSON);
	}

}
