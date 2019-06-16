package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class MainController {

	@GetMapping("hello")
	String getView(Model model) {
		model.addAttribute("text", "Juggernaut");
		return "index";
	}
}