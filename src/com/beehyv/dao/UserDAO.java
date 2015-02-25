package com.beehyv.dao;

import com.beehyv.modal.User;

public interface UserDAO {
	public User getUserById(int idUser);
	public int authenticate(String userName, String password);
}
