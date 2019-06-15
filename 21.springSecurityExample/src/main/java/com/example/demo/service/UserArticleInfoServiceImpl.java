package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Article;
import com.example.demo.model.UserInfo;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.UserInfoRepository;

@Service
public class UserArticleInfoServiceImpl implements UserArticleInfoService {

	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public List<Article> getAllArticles() {
		return articleRepository.findByOrderByArticleId();
	}

	@Override
	public UserInfo getUserInfo(String userName) {
		return userInfoRepository.findByUserName(userName);
	}

	@Override
	public List<UserInfo> getAllUsers() {
		return (List<UserInfo>) userInfoRepository.findAll();
	}
}