package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Details;

public interface DetailsRepository extends CrudRepository<Details, Integer> {

	// Query By Method Name

	Details findByFirstNameAndLastName(String firstName, String lastName);

	List<Details> findByStartDateBetween(Date startDate, Date endDate);

	List<Details> findByAgeLessThan(int age);

	List<Details> findByAgeLessThanEqual(int age);

	List<Details> findByAgeIsNull();

	List<Details> findByFirstNameLike(String firstName);

	List<Details> findByFirstNameNotLike(String firstName);

	List<Details> findByFirstNameStartingWith(String firstName);

	List<Details> findByFirstNameContaining(String firstName);

	List<Details> findByFirstNameStartingWithOrderByLastNameDesc(String name);

	List<Details> findByLastNameNot(String lastName);

	List<Details> findByAgeIn(List<Integer> list);

	List<Details> findByStatusTrue();

	List<Details> findFirstNameDistinctByFirstNameStartingWith(String firstName);

	List<Details> findByStatusTrueAndStartDateBetweenOrderByIdAsc(Date startDate, Date endDate);

	List<Details> findByFirstNameStartingWithAndEndDateBetweenAndStatusNotNullOrderByIdDesc(String name, Date startDate,
			Date endDate);

	List<Details> findByStartDateAfterAndEndDateBefore(Date startDate, Date endDate);

	List<Details> findTop3ByLastNameEndingWith(String letter);

	// Declare query using @Query

	@Query("select u from details u where u.firstName = ?1 and u.lastName = ?2")
	Details findByFullName(String firstName, String lastName);

	// Query using named parameter

	@Query("select u from details u where u.firstName = :firstName or u.lastName = :lastName")
	List<Details> findByFirstNameOrLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

	// Using SpEL Expressions
	@Query("select u from #{#entityName} u where u.lastName = ?1")
	List<Details> findByLastname(String lastName);

}