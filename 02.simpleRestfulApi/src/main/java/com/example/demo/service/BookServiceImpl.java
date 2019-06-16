package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Book;

@Service
public class BookServiceImpl implements BookService {

	// Simulate the database, store Book information
	private Map<String, Book> BOOK_DB = Collections.synchronizedMap(new HashMap<String, Book>());

	@Override
	public List<Book> findAll() {
		return new ArrayList<>(BOOK_DB.values());
	}

	@Override
	public Book insertByBook(Book book) {
		book.setId(BOOK_DB.size() + 1L);
		BOOK_DB.put(book.getId().toString(), book);
		return book;
	}

	@Override
	public Book update(Book book) {
		BOOK_DB.put(book.getId().toString(), book);
		return book;
	}

	@Override
	public Book delete(Long id) {
		return BOOK_DB.remove(id.toString());
	}

	@Override
	public Book findById(Long id) {
		return BOOK_DB.get(id.toString());
	}

	@Override
	public boolean exists(Book book) {
		return findByName(book.getName()) != null;
	}

	@Override
	public Book findByName(String name) {
		List<Book> books = new ArrayList<>(BOOK_DB.values());

		for (Book book : books) {
			if (book.getName().equals(name)) {
				return book;
			}
		}
		
		return null;
	}
}
