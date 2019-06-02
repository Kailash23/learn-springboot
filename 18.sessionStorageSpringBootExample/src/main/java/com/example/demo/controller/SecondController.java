package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecondController {

	@GetMapping("/show")
	@ResponseBody
	public String show(HttpServletRequest request) {
		return "Retrieved attribute from session	 :- " + request.getSession().getAttribute("text");
	}
}
