package com.example.demo.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

@Controller
public class MainController implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		StringBuffer url = httpRequest.getRequestURL();
		System.out.println("URL : " + url.toString());

		if (!isValid(url.toString())) {
			System.out.println("Invalid Url!");
		} else {
			System.out.println("Valid Url!");
		}
		chain.doFilter(request, response);
	}

	public boolean isValid(String url) {
		String regex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		return validator(regex, url);

	}

	private boolean validator(String nameRegex, String toValidate) {
		Pattern pattern = Pattern.compile(nameRegex);
		Matcher matcher = pattern.matcher(toValidate);
		return matcher.matches();
	}

}
