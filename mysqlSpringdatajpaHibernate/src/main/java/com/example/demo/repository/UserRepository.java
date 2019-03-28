package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.User;

/**
 * A DAO (aka Repository) is needed to works with entities in database’s table,
 * with methods like save, delete, update, etc.
 */
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
	/**
	 * This method will find an User instance in the database by its email. Note
	 * that this method is not implemented and its working code will be
	 * automagically generated from its signature by Spring Data JPA.
	 */
	public User findByEmail(String email);

}
