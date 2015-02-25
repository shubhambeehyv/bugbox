package com.beehyv.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beehyv.dao.ReleaseDAO;
import com.beehyv.dao.impl.ReleaseDAOimpl;
import com.beehyv.modal.Release;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class ReleaseServlet extends HttpServlet {
	ReleaseDAO releaseDAO = new ReleaseDAOimpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("In ReleaseServlet");
		Gson gson = new Gson();
		if (req.getParameter("idProject") != null) {
			List<Release> releases = releaseDAO.getReleasesByProjectId(Integer
					.parseInt(req.getParameter("idProject")));
			req.setAttribute("releases", releases);

			String releasesJSON = gson.toJson(releases);
			PrintWriter out = resp.getWriter();
			out.write(releasesJSON);
		}
		if (req.getParameter("idRelease") != null) {
			Release release = releaseDAO.getReleaseByReleaseId(Integer
					.parseInt(req.getParameter("idRelease")));
			req.setAttribute("release", release);

			String releaseJSON = gson.toJson(release);
			PrintWriter out = resp.getWriter();
			out.write(releaseJSON);
		}
	}
}
