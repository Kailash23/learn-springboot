package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService; // User service layer

	/**
	 * Get user list Handle GET request for "/users" to get the list of users
	 * Further pass conditional query or paged query by passing parameters
	 * via @RequestParam
	 */
	@GetMapping
	public String getUserList(Model model) {
		model.addAttribute("userList", userService.findAll());
		return "userList";
	}

	/**
	 * Show create user form
	 */
	@GetMapping("create")
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("action", "create");
		return "userForm";
	}

	/**
	 * Create user Handle POST requests for "/users" to get a list of users Bind
	 * parameters via @ModelAttribute and pass parameters from the page
	 * via @RequestParam
	 */
	@PostMapping("create")
	public String postUser(Model model, @ModelAttribute @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("action", "create");
			return "userForm";
		}
		userService.insertByUser(user);
		return "redirect:/users/";
	}

	/**
	 * Display needs to update user form Handle the GET request for "/users/{id}"
	 * and get the User information from the id value in the URL id in URL, bind
	 * parameter via @PathVariable
	 */
	@GetMapping("update/{id}")
	public String getUser(@PathVariable Long id, Model model) {
		model.addAttribute("user", userService.findById(id));
		model.addAttribute("action", "update");
		return "userForm";
	}

	/**
	 * Handle PUT request for "/users/{id}" to update User information
	 */
	@PostMapping("update")
	public String putUser(Model model, @ModelAttribute @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("action", "update");
			return "userForm";
		}
		userService.update(user);
		return "redirect:/users/";
	}

	/**
	 * Handle GET request for "/users/{id}" to delete User information
	 */
	@GetMapping("delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return "redirect:/users/";
	}
}
