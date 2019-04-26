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
		String nameRegex = "^[\\p{L} .'-]+$";
		Pattern pattern = Pattern.compile(nameRegex);
		Matcher matcher = pattern.matcher(formRequestDto.getName());  
		boolean bool = matcher.matches();
		if(bool) {
			formRequestDto.setNameErrorText("");
		} else {
			formRequestDto.setNameErrorText("Invalid Name");
		}
	}
}
