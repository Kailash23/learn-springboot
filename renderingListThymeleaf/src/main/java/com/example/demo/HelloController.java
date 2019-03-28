package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Rendering the Web view using the Thymeleaf template engine. 
 */
@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(Model model) {
		DeveloperResource[] devResources = { new DeveloperResource("Google", "http://www.google.com"),
				new DeveloperResource("Stackoverflow", "http://www.stackoverflow.com"),
				new DeveloperResource("W3Schools", "http://www.w3schools.com") };
		model.addAttribute("resources", devResources);
		return "hello";
	}
}
