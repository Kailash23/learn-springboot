package com.example.demo.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.FormRequestDto;

@Controller
public class MainController {

	@GetMapping("/")
	public String loginPageRender(Model model) {
		FormRequestDto formRequestDto = new FormRequestDto();
		formRequestDto.setFlag(true);
		model.addAttribute("forminfo", formRequestDto);
		model.addAttribute("formRequestDto", formRequestDto);
		model.addAttribute("bool", false);
		return "form";
	}

	@PostMapping("/submit")
	public String submit(@ModelAttribute FormRequestDto formRequestDto, Model model) {
		model.addAttribute("forminfo", formRequestDto);
		validate(formRequestDto);
		model.addAttribute("formRequestDto", formRequestDto);
		model.addAttribute("bool", true);
		return "form";
	}

	private void validate(FormRequestDto formRequestDto) {
		if (validator("^[\\p{L} .'-]+$", formRequestDto.getName())) {
			formRequestDto.setNameErrorText("");
		} else {
			formRequestDto.setNameErrorText("Invalid Name");
		}
		
		if (validator("^(.+)@(.+)$", formRequestDto.getEmail())) {
			formRequestDto.setEmailErrorText("");
		} else {
			formRequestDto.setEmailErrorText("Invalid Email");
		}
		
		if (validator("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}", formRequestDto.getPhoneNumber())) {
			formRequestDto.setPhoneNumberErrorText("");
		} else {
			formRequestDto.setPhoneNumberErrorText("Invalid Mobile Number");
		}
		
		if (validator("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", formRequestDto.getPassword())) {
			formRequestDto.setPasswordErrorText("");
		} else {
			formRequestDto.setPasswordErrorText("Password must contain one digit, lowercase char, uppercase char, special symbols & length at least 6 characters and maximum of 20");
		}
	}
	
	private boolean validator(String nameRegex, String toValidate) {
		Pattern pattern = Pattern.compile(nameRegex);
		Matcher matcher = pattern.matcher(toValidate);
		boolean bool = matcher.matches();
		return bool;
	}
}


