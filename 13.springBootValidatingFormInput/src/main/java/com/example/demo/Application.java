package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private Logger LOG = LoggerFactory.getLogger(Application.class);

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("Sergey", 24, "1994-01-01");
		User user2 = new User("Ivan", 26, "1994-01-01");
		User user3 = new User("Adam", 31, "1994-01-01");

		LOG.info("Inserting data in DB.");

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		
		LOG.info("User count in DB: {}", userRepository.count());
		
	}

}
