package com.example.simpleRestApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "Hello World";
	}

//	We can write the above one as.

	@GetMapping("helloAgain")    //Or @GetMapping("/helloAgain")
	public String sayHelloAgain() {
		return "Hello World";
	}

}

//@Controller: modifier class, used to create objects that process http requests

//@RestController: Note added after Spring4, the original @Controller return json 
//needs @ResponseBody to cooperate, if you directly use the @RestController substitution, 
//@Controller you do not need to configure @ResponseBody, the default return json format.

//@RequestMapping: Configuring url mapping