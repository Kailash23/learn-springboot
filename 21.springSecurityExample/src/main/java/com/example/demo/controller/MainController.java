package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.UserArticleInfoService;

@Controller
@RequestMapping("app")
public class MainController {

	@Autowired
	private UserArticleInfoService userArticleInfoService;

	@GetMapping("login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginpage");
		return mav;
	}
	
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("secure/article-details")
	public ModelAndView getAllArticles() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("articleList", userArticleInfoService.getAllArticles());
		mav.setViewName("details");
		return mav;
	}
	
	@Secured({ "ROLE_ADMIN" })
	@GetMapping("secure/user-details")
	public ModelAndView getAllUsers() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userList", userArticleInfoService.getAllUsers());
		mav.setViewName("details");
		return mav;
	}

	@GetMapping("error")
	public ModelAndView error() {
		ModelAndView mav = new ModelAndView();
		String errorMessage = "You are not authorized for the requested data.";
		mav.addObject("errorMsg", errorMessage);
		mav.setViewName("error");
		return mav;
	}

}