package com.beehyv.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.beehyv.dao.ReleaseDAO;
import com.beehyv.modal.Release;

public class ReleaseDAOimpl extends BaseDAO implements ReleaseDAO {

	@Override
	public List<Release> getReleasesByProjectId(int idProject) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<Release> releases = new ArrayList<Release>();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select idRelease, releaseName, releaseDescription, releaseStatus,releaseDate, releaseNote"+
								", idProject from Project.Release where idProject = "+idProject);
			while(resultSet.next())
			{
				Release  release = new Release();
				release.setIdRelease(resultSet.getInt(1));
				release.setReleaseName(resultSet.getString(2));
				release.setReleaseDescription(resultSet.getString(3));
				release.setReleaseStatus(resultSet.getString(4));
				release.setReleaseDate(resultSet.getDate(5));
				release.setReleaseNote(resultSet.getString(6));
				release.setIdProject(resultSet.getInt(7));
				releases.add(release);
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
		return releases;
	}

	@Override
	public void addRelease(Release newRelease) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		Statement statement = null;
		
		try{
			statement = connection.createStatement();
			int idProject = newRelease.getIdProject();
			int idRelease = newRelease.getIdRelease();
			String releaseName = newRelease.getReleaseName();
			String releaseDescription = newRelease.getReleaseDescription();
			String releaseStatus = newRelease.getReleaseStatus();
			Date releaseDate = newRelease.getReleaseDate();
			String releaseNote = newRelease.getReleaseNote();
			
			
			
			
			statement.executeUpdate("Insert into Project.Release(idRelease,releaseName,releaseDescription, releaseStatus,releaseDate,releaseNote,idProject )VALUES('"
			+idRelease+"', '"+releaseName+"', '"+releaseDescription+"', '"+releaseStatus+"', '"+releaseDate+"', '"+releaseNote+"', '"+idProject+"')");
			
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

	@Override
	public Release getReleaseByReleaseId(int idRelease) {
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		Release  release = new Release();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select idRelease, releaseName, releaseDescription, releaseStatus,releaseDate, releaseNote"+
								", idProject from Project.Release where idRelease = "+idRelease);
			while(resultSet.next())
			{
				
				release.setIdRelease(resultSet.getInt(1));
				release.setReleaseName(resultSet.getString(2));
				release.setReleaseDescription(resultSet.getString(3));
				release.setReleaseStatus(resultSet.getString(4));
				release.setReleaseDate(resultSet.getDate(5));
				release.setReleaseNote(resultSet.getString(6));
				release.setIdProject(resultSet.getInt(7));
				
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
		return release;
		
	}
		
	}


