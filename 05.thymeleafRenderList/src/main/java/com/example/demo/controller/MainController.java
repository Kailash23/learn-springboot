package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dto.Details;

@Controller
public class MainController {

	@RequestMapping
	public String hello(Model model) {
		Details[] devResources = { new Details("Google", "http://www.google.com"),
				new Details("Stackoverflow", "http://www.stackoverflow.com"),
				new Details("W3Schools", "http://www.w3schools.com") };
		model.addAttribute("resources", devResources);
		return "index";
	}
}
