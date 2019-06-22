package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;


@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public User postUser(@RequestBody User user) {
		return userService.insertByUser(user);
	}

	@GetMapping
	public Page<User> getUserPage(Pageable pageable) {
		return userService.findByPage(pageable);
	}

//  Alternative

//	@GetMapping
//	public ResponseEntity<Page<User>> getUsers(Pageable pageable) {
//		return new ResponseEntity<>(userService.findByPage(pageable), HttpStatus.OK);
//	}

}