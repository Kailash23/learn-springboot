package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, String>{

	UserInfo findByUserName(String userName);
	
}
