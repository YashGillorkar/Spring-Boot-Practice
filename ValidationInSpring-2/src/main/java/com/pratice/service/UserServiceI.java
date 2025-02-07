package com.pratice.service;

import com.pratice.dto.UserDTO;

public interface UserServiceI {

	public UserDTO getUserById(Long id);

	public UserDTO postUser(UserDTO entity);

}
