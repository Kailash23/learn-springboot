package com.example.demo.service;

import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public void save(Person person) {
		personRepository.save(person);
	}

	public void update(Person person) {
		updatedPerson(personRepository.findById(person.getId()), person);
	}

	private Person updatedPerson(Optional<Person> existingPerson, Person updatedPerson) {
		if (StringUtils.isNotBlank(updatedPerson.getName())) {
			existingPerson.get().setName(updatedPerson.getName());
		}

		if (updatedPerson.getAge() != 0) {
			existingPerson.get().setAge(updatedPerson.getAge());
		}

		if (updatedPerson.getGender() != null) {
			existingPerson.get().setGender(updatedPerson.getGender());
		}

		return personRepository.save(existingPerson.get());
	}
}
