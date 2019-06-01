package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/create")
	@ResponseBody
	public String create(String email, String name) {
		String userId = "";
		String message = "";
		try {
			User user = new User(email, name);
			User userCheck = userRepository.findByEmail(email);
			if (userCheck == null) {
				userRepository.save(user);
				userId = String.valueOf(user.getId());
				message = "User succesfully created with id = " + userId;
			} else {
				message = "User already exists!";
			}
		} catch (Exception e) {
			message = "Error creating the user: " + e.toString();
		}
		return message;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			User user = new User(id);
			userRepository.delete(user);
		} catch (Exception e) {
			return "Error deleting the user:" + e.toString();
		}
		return "User succesfully deleted!";
	}

	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId = "";
		try {
			User user = userRepository.findByEmail(email);
			userId = String.valueOf(user.getId());
		} catch (Exception e) {
			return "User not found";
		}
		return "The user id is: " + userId;
	}

	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, String email, String name) {
		try {
			Optional<User> user = userRepository.findById(id);
			user.get().setEmail(email);
			user.get().setName(name);
			userRepository.save(user.get());
		} catch (Exception e) {
			return "Error updating the user: " + e.toString();
		}
		return "User succesfully updated!";
	}

}
