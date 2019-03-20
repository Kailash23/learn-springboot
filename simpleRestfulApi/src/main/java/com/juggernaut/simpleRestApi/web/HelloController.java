package com.juggernaut.simpleRestApi.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String index() {
		return "Hello World";
	}
}

//@Controller: modifier class, used to create objects that process http requests

//@RestController: Note added after Spring4, the original @Controller return json 
//needs @ResponseBodyto cooperate, if you directly use the @RestController substitution, 
//@Controller you do not need to configure @ResponseBody, the default return json format.

//@RequestMapping: Configuring url mapping