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
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController implements Filter {
	
	private int count = 0;
	
	@GetMapping("/")
	@ResponseBody
	public String home() {
		return "<em><strong>Valid url eg. :- <a href='http://localhost:8080/home'>http://localhost:8080/home</a></strong></em><br>"
				+ "<em><strong>Invalid url eg. :- <a href='http://localhost:8080/home^'>http://localhost:8080/home^</a></strong></em>";
	}
	
	@GetMapping("/valid")
	@ResponseBody
	public String valid() {
		count++;
		return "<em><strong>(" + count + ") This is a valid url! </strong></em>";
	}

	@GetMapping("/invalid")
	@ResponseBody
	public String invalid() {
		count++;
		return "<em><strong>(" + count + ") This is not a valid url!</strong></em>";
	}

	@GetMapping("/*")
	@ResponseBody
	public String alert() {
		return "";
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();
		StringBuffer url = httpRequest.getRequestURL();
		System.out.println("URL : " + url.toString());
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		if (!(uri.equals("/")|| (uri.equals("/valid"))|| uri.equals("/invalid"))) {
			if (isValid(url.toString())) {
				System.out.println("Valid Url!");
				httpResponse.sendRedirect("/valid");
			} else {
				System.out.println("Invalid Url!");
				httpResponse.sendRedirect("/invalid");
			}
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
