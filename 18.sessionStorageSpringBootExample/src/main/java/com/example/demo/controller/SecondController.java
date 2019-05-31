package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecondController {

	@GetMapping("/two")
	@ResponseBody
	public String runner(HttpServletRequest request) {
		System.out.println(request.getSession().getAttribute("text"));
		return "Check console!";
	}
}
