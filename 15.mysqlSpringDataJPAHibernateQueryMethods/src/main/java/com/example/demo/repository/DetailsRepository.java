package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Details;

public interface DetailsRepository extends CrudRepository<Details, Integer> {

	Details findByFirstNameAndLastName(String firstName, String lastName);

	List<Details> findByStartDateBetween(Date startDate, Date endDate);

	List<Details> findByAgeLessThan(int age);

	List<Details> findByAgeLessThanEqual(int age);

	List<Details> findByAgeIsNull();

	List<Details> findByFirstNameLike(String firstName);

	List<Details> findByFirstNameNotLike(String firstName);

	List<Details> findByFirstNameStartingWith(String firstName);

	List<Details> findByFirstNameContaining(String firstName);

	List<Details> findByAgeOrderByLastNameDesc(int age);

	List<Details> findByLastNameNot(String lastName);

	List<Details> findByAgeIn(List<Integer> list);

	List<Details> findByStatusTrue();

	List<Details> findFirstNameDistinctByFirstNameStartingWith(String firstName);

	List<Details> findByStatusTrueAndStartDateBetweenOrderByIdAsc(Date startDate, Date endDate);

	List<Details> findByFirstNameStartingWithAndEndDateBetweenAndStatusNotNullOrderByIdDesc(String name, Date startDate,
			Date endDate);

	List<Details> findByStartDateAfterAndEndDateBefore(Date startDate, Date endDate);

}