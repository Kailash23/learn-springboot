package com.example.demo.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ArticleRowMapper implements RowMapper<Article> {

	@Override
	public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
		Article article = new Article();
		article.setArticleId(rs.getInt("articleId"));
		article.setTitle(rs.getString("title"));
		article.setCategory(rs.getString("category"));
		return article;
	}

}
