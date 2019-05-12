package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.TableInfo;
import com.example.demo.repository.TableInfoRepository;

@Controller
public class MainController {

	@Autowired
	private TableInfoRepository tableInfoRepository;

	@GetMapping("/")
	public String renderTable(Model model) {
		List<TableInfo> list = (List<TableInfo>) tableInfoRepository.findAll();
		model.addAttribute("rowlist", list);
		return "index";
	}

}
