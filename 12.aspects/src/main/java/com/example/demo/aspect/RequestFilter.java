package com.example.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Before;

@Aspect
@Component
public class RequestFilter {

	@Before("execution(public void print()))")
	public void getString() {
		System.out.println();
		System.out.println("Request Filtered!");
	}
	
	@After("execution(public void print()))")
	public void getAnotherString() {
		System.out.println("Request Filtered Again!");
	}
}
