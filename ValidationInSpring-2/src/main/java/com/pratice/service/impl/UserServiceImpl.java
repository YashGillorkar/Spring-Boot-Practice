package com.pratice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.dto.UserDTO;
import com.pratice.entity.User;
import com.pratice.repository.UserRepo;
import com.pratice.service.UserServiceI;

@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    UserRepo repository;

    @Override
    public UserDTO getUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return new UserDTO(user.getName(), user.getEmail(), user.getAge(), user.getPhoneNumber());
    }

    @Override
    public UserDTO postUser(UserDTO dto) {
        User user = repository.save(new User(dto.getName(), dto.getEmail(), dto.getAge(), dto.getPhoneNumber()));
        return new UserDTO(user.getName(), user.getEmail(), user.getAge(), user.getPhoneNumber());
    }
}
