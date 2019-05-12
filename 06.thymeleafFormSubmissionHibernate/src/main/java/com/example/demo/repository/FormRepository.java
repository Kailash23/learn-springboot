package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Form;

@Transactional
public interface FormRepository extends CrudRepository<Form, Long> {

}
