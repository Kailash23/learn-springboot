package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Book;

public interface BookService {

	List<Book> findAll();

	Book insertByBook(Book book);

	Book update(Book book);

	Book delete(Long id);

	Book findById(Long id);

	boolean exists(Book book);

	Book findByName(String name);
}
