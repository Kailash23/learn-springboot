package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.DeveloperResource;


@Controller
public class MainController {

	@RequestMapping
	public String hello(Model model) {
		DeveloperResource[] devResources = { 
			new DeveloperResource("Google", "http://www.google.com"),
			new DeveloperResource("Stackoverflow", "http://www.stackoverflow.com"),
			new DeveloperResource("W3Schools", "http://www.w3schools.com") 
		};
		model.addAttribute("resources", devResources);
		return "index";
	}
}
