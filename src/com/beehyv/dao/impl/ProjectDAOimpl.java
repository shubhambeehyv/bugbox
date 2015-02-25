package com.beehyv.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beehyv.dao.ProjectDAO;
import com.beehyv.modal.Project;


public class ProjectDAOimpl extends BaseDAO implements ProjectDAO{

	@Override
	public List<Project> getProjects() {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<Project> projects = new ArrayList<Project>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select idProject,projectName, description from Project.Project");
			
			while(resultSet.next())
			{
				Project project = new Project();
				project.setIdProject(resultSet.getInt(1));
				project.setProjectName(resultSet.getString(2));
				project.setDescription(resultSet.getString(3));
				projects.add(project);
			}
		}catch(SQLException e){
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
		
		return projects;
	}

	@Override
	public Project getProjectById(int idProject) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		Project project = new Project();
		try{
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select idProject,projectName, description from Project.Project"
					+"where idProject = "+idProject);
			project.setIdProject(resultSet.getInt(1));
			project.setProjectName(resultSet.getString(2));
			project.setDescription(resultSet.getString(3));
			
			
		}catch(SQLException e){
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
		return project;
	}

	@Override
	public void addProject(Project newProject) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		Statement statement = null;
		
		try{
			statement = connection.createStatement();
			
			String projectName = newProject.getProjectName();
			String description = newProject.getDescription();
			statement.executeUpdate("Insert into Project.Project(projectName,description)VALUES('"+projectName+"', '"+description+"')");
			
		}catch(SQLException e){
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
