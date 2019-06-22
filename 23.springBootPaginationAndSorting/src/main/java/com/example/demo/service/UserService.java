package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.domain.User;

public interface UserService {

	Page<User> findByPage(Pageable pageable);

	User insertByUser(User user);
}