package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Article;
import com.example.demo.model.UserInfo;

public interface UserArticleInfoService {

	List<Article> getAllArticles();

	UserInfo getUserInfo(String userName);

	List<UserInfo> getAllUsers();

}