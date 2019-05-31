package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {
	
	@GetMapping("/one")
	@ResponseBody
	public String runner(HttpServletRequest request) {
		String str = "Storing string in session.";
		request.getSession().setAttribute("text", str);
		return str;
	}
}
