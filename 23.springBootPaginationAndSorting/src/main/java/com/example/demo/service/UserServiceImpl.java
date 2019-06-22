package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Page<User> findByPage(Pageable pageable) {
		pageable = PageRequest.of(0, 5, Sort.by("name"));
		System.out.println(" PageNumber = " + pageable.getPageNumber());
		System.out.println(" PageSize = " + pageable.getPageSize());
		return userRepository.findAll(pageable);
	}

	@Override
	public User insertByUser(User user) {
		System.out.println("New users:" + user.toString());
		return userRepository.save(user);
	}
}