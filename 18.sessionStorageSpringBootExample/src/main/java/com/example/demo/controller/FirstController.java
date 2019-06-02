package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

	@GetMapping("/save")
	@ResponseBody
	public String save(HttpServletRequest request, String text) {
		if(text == null) {
			text = "Hello World!";
		}
		request.getSession().setAttribute("text", text);
		return "Saved attribute on session :- " + text;
	}
	
	@GetMapping("/clear")
	@ResponseBody
	public String clearSession(HttpServletRequest request) {
		request.getSession().removeAttribute("text");
		return "Attribute removed from session!";
	}

	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "<em><strong>Save on session :- <a href='http://localhost:8080/save'>http://localhost:8080/save</a></strong></em><br>"
				+ "<em><strong>Retrieve from session :- <a href='http://localhost:8080/show'>http://localhost:8080/show</a></strong></em><br>"
				+ "<em><strong>Remove attribute from session :- <a href='http://localhost:8080/clear'>http://localhost:8080/clear</a></strong></em>";
	}
}
