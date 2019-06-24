package com.example.demo.controller;

import java.security.Principal;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@SuppressWarnings("unchecked")
	@GetMapping(value = "/user")
	public String user(Principal principal, Model model) {
		OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
		Authentication authentication = oAuth2Authentication.getUserAuthentication();
		Map<String, String> userDetails = (Map<String, String>) authentication.getDetails();
		MapUtils.verbosePrint(System.out, "user details", userDetails);
		String name = userDetails.get("name");
		model.addAttribute("name", name);
		return "redirect";
	}

}
