package com.example.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.FormDto;
import com.example.demo.model.Form;
import com.example.demo.repository.FormRepository;

@Controller
public class FormController {

	@Autowired
	private FormRepository formRepository;

	@GetMapping("/")
	public String loginPageRender(Model model) {
		model.addAttribute("forminfo", new FormDto());
		return "form";
	}

	@RequestMapping("/submit")
	@ResponseBody
	public String formDataSubmission(@ModelAttribute FormDto formDto) {
		Form form = new Form();
		BeanUtils.copyProperties(formDto, form);
		formRepository.save(form);
		return "Submitted!";
	}
}
