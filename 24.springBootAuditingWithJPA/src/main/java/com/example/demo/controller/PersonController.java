package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("audit/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@RequestMapping(value = { "/save" }, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void save(@RequestBody Person person) {
		try {
			personService.save(person);
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public void update(@RequestBody Person person) {
		try {
			personService.update(person);
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
