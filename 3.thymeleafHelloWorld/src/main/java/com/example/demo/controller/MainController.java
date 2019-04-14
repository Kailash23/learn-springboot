package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/helloWorld")
public class MainController {

	@GetMapping
	String getView(Model model) {
		model.addAttribute("text", "Hello World!");
		return "index";
	}
}