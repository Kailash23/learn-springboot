package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping("/send")
	@ResponseBody
	public String sendEmail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("test@gmail.com");
		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \nSpring Boot Email");
		javaMailSender.send(msg);
		return "<strong>Message sent</strong>";
	}

	@GetMapping("/")
	@ResponseBody
	public String mainScreen() {
		return "<a href='http://localhost:8080/send'>Send Email</a>";
	}
}
