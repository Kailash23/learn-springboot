package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/hello")
	public void hello(Model model) {
		System.out.println(userService.getAllUsers());
	}
}
