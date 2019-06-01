package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.CronTask;


public interface CronTaskRepository extends CrudRepository<CronTask, Integer> {

}
