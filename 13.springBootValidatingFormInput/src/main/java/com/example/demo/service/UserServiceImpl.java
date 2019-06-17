package com.example.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User insertByUser(User user) {
		LOGGER.info(" Add User: " + user.toString());
		return userRepository.save(user);
	}

	@Override
	public User update(User user) {
		LOGGER.info(" Update User: " + user.toString());
		return userRepository.save(user);
	}

	@Override
	public User delete(Long id) {
		User user = userRepository.findById(id).get();
		userRepository.delete(user);

		LOGGER.info(" Delete user: " + user.toString());
		return user;
	}

	@Override
	public User findById(Long id) {
		LOGGER.info(" Get User ID: " + id);
		return userRepository.findById(id).get();
	}
}
