package com.beehyv.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beehyv.dao.IssueDAO;
import com.beehyv.dao.UserDAO;
import com.beehyv.modal.Issue;


public class IssueDAOimpl extends BaseDAO implements IssueDAO {

	@Override
	public List<Issue> getIssueByReleaseId(int idRelease) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		UserDAO userDAO = new UsersDAOimpl();
		List<Issue> issues = new ArrayList<Issue>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select idIssue,issueTitle,issueDescription,idIssueAssignee,idIssueReporter,issueStatus"+
								" from Project.Issue where idRelease = "+idRelease);
			while(resultSet.next())
			{
				Issue issue = new Issue();
				issue.setIdIssue(resultSet.getInt(1));
				issue.setIssueTitle(resultSet.getString(2));
				issue.setIssueDescription(resultSet.getString(3));
				issue.setIdIssueAssignee(resultSet.getInt(4));
				issue.setIssueAssigneeName(userDAO.getUserById(issue.getIdIssueAssignee()).getUserName());
				issue.setIdIssueReporter(resultSet.getInt(5));
				issue.setIdRelease(idRelease);
				issue.setIssueStatus(resultSet.getString(6));
				issues.add(issue);
				
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
		return issues;
	}

	@Override
	public void addIssue(Issue newIssue) {
		// TODO Auto-generated method stub
		
	}
	

}
