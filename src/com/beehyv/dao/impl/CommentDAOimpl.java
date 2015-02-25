package com.beehyv.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beehyv.dao.CommentDAO;
import com.beehyv.modal.Comment;

public class CommentDAOimpl extends BaseDAO implements CommentDAO {

	@Override
	public List<Comment> getCommentByIssueId(int idIssue) {
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<Comment> comments = new ArrayList<Comment>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select * from Project.Comment where idIssue="+idIssue);
			while(resultSet.next()){
				Comment comment = new Comment();
				comment.setIdComment(resultSet.getInt(1));
				comment.setComment(resultSet.getString(2));
				comment.setIdIssue(resultSet.getInt(3));
				comment.setIdCommentedBy(resultSet.getInt(4));
				comments.add(comment);
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			try{
				resultSet.close();
				statement.close();
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		return comments;
	}

	@Override
	public void addComment(Comment newComment) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		Statement statement = null;
		
		try{
			statement = connection.createStatement();
			String comment = newComment.getComment();
			int idIssue = newComment.getIdIssue();
			int idCommentedBy = newComment.getIdCommentedBy();
			statement.executeUpdate("Insert into Project.Comment(comment, idIssue,idCommentedBy )VALUES('"+comment+"', "+idIssue+","+idCommentedBy+")");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			try{
				
				statement.close();
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
			
		
	}
	
}
