package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.BookProperties;

@RestController
public class MainController {

	@Autowired
	private BookProperties bookProperties;

	@GetMapping("/book")
	public String displayAction() {
		return "Hello，" + bookProperties.getWriter() + " is writing " + bookProperties.getName() + " ！";
	}

	@GetMapping("/desc")
	public String displayDesc() {
		return bookProperties.getDescription();
	}
}
