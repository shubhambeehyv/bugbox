package com.beehyv.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beehyv.dao.UserDAO;
import com.beehyv.modal.User;

public class UsersDAOimpl extends BaseDAO implements UserDAO {

	@Override
	public User getUserById(int idUser) {
		
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		 User user = new User();
		try{
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select userName,firstName,lastName,idRole  from Project.User "
					+"where idUser = "+""+idUser+"");
			while(resultSet.next()){
			user.setIdUser(idUser);
			user.setUserName(resultSet.getString(1));
			user.setFirstName(resultSet.getString(2));
			user.setLastName(resultSet.getString(3));
			user.setIdRole(resultSet.getInt(4));
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
		return user;
	}
public User getUserByUserName(String  username) {
		
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		boolean nouser = false;
		 User user = new User();
		try{
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select idUser,firstName,lastName,idRole  from Project.User "
					+"where userName = "+"'"+username+"'");
			while(resultSet.next()){
			user.setIdUser(resultSet.getInt(1));
			if(resultSet.wasNull())
				 nouser = true;
				
			user.setUserName(username);
			user.setFirstName(resultSet.getString(2));
			user.setLastName(resultSet.getString(3));
			user.setIdRole(resultSet.getInt(4));
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
		if(nouser)
			return null;
		return user;
	}

	@Override
	// re
	public int authenticate(String username, String password) {
		System.out.println("In AUTH");
		// TODO Auto-generated method stub
		Connection connection = getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		int idUser = 0;
		try{
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select idUser, username, Password  from Project.User where username ="+"'"+username.trim()+"'");
					
				while(resultSet.next()){	
				if(password.equals(resultSet.getString(3)) )
				idUser = resultSet.getInt(1);}
				
			
			
			
			
			
			
			
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
		
		return idUser;
	}
	public void addUser(User newuser){
		Connection connection = getConnection();
		Statement statement = null;
		String username = newuser.getUserName();
		String password = newuser.getPassWord();
		try{
			statement = connection.createStatement();
			statement.executeUpdate("Insert into Project.User(UserName, Password) values('"+username+"','"+password+"')" );
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
