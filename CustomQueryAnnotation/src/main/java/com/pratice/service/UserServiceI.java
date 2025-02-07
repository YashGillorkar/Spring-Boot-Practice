package com.pratice.service;

import com.pratice.entity.User;

public interface UserServiceI {

	User getUserById(int id);

	User addUser(User user);

	void updateUser(Integer id, User entity);

	User updateName(Integer id, String name);

	User deleteId(Integer id);

	User getUserByName(String name);

	
	
}
