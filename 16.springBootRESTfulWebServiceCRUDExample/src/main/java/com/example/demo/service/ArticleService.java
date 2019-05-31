package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Article;

public interface ArticleService {

	List<Article> getAllArticles();

	Article getArticleById(long articleId);

	boolean addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(int articleId);
}
