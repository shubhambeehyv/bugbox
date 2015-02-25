package com.beehyv.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beehyv.dao.CommentDAO;
import com.beehyv.dao.impl.CommentDAOimpl;
import com.beehyv.modal.Comment;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class CommentServlet extends HttpServlet{
	CommentDAO commentDAO = new CommentDAOimpl();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("In CommentServlet");
		List<Comment> comments = commentDAO.getCommentByIssueId(Integer.parseInt(req.getParameter("idIssue")));
		req.setAttribute("commments",comments);
		Gson gson = new Gson();
		String commmentsJSON = gson.toJson(comments);
		PrintWriter out = resp.getWriter();
		out.write(commmentsJSON);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		System.out.println("Comment post");
		String comment = (String)req.getParameter("comment");
		System.out.println(comment);
		int idIssue = Integer.parseInt(req.getParameter("idIssue"));
		int idCommentedBy = (Integer)req.getSession().getAttribute("userId");
		Comment newComment = new Comment();
		newComment.setComment(comment);
		newComment.setIdCommentedBy(idCommentedBy);
		newComment.setIdIssue(idIssue);
		commentDAO.addComment(newComment);
		
		
	}

}
