package com.example.demo.repository;


import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.TableInfo;

@Transactional
public interface TableInfoRepository extends CrudRepository<TableInfo, Long> {

}
