package com.example.simpleRestApi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloControllerAlternative {

	@GetMapping("helloAlternative")
	@ResponseBody
	public String sayHello() {
		return "Hello World";
	}

}
