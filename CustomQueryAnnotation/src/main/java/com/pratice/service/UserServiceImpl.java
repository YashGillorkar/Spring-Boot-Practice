package com.pratice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratice.entity.User;
import com.pratice.exception.InVaildIdException;
import com.pratice.userRepository.UserRepository;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	UserRepository repository;

	// Get SingleRecord
	@Override
	public User getUserById(int id) {

		Optional<User> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new InVaildIdException("Invaild id " + id);
	}

	// Add User--post
	@Override
	public User addUser(User user) {
		return repository.save(user);
	}

	// Put Update User
	@Override
	public void updateUser(Integer id, User entity) {

		Optional<User> optional = repository.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();

			// here we don't know the payroll it might be only name or password
			// firstly we will check what are the field we need to update from responseBody
			// i.e entity
			if (entity.getName() != null) {
				user.setName(entity.getName());
			}
			if (entity.getEmail() != null) {
				user.setEmail(entity.getEmail());
			}
			if (entity.getPassword() != null) {
				user.setPassword(entity.getPassword());
			}
			repository.save(user);
		} else
			// there might be a scenario where user might enter invalid id while updating
			throw new InVaildIdException("Invaild id " + id);

	}

	// patch Update name
	// patch is use update single field that why it may be name , email, password

	@Override
	public User updateName(Integer id, String name) {
		Optional<User> optional = repository.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			user.setName(name);
			repository.save(user);
			return user;
		}
		throw new InVaildIdException("Invaild id " + id);

	}

	// Delete

	@Override
	public User deleteId(Integer id) {
		Optional<User> optional = repository.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			repository.delete(user);
			return user;
		}
		throw new InVaildIdException("Invaild id " + id);
	}

	@Override
	public User getUserByName(String name) {
		
		return repository.getByName(name);
	}
}
