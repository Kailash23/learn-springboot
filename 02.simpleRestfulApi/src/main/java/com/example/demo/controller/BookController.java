package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.dto.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	private final Logger LOG = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookService;

	/**
	 * Get the Book list Handle a GET request for "/book" to get a list of Books
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Book> getBookList() {
		return bookService.findAll();
	}

	/**
	 * Get Book Handle GET request for "/book/{id}" to get Book information
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Book getBook(@PathVariable Long id) {
		return bookService.findById(id);
	}

	/**
	 * Create Book Handle POST request for "/book/create" to create a new Book
	 * message By @RequestBody binding entity parameters, but also by @RequestParam
	 * pass parameters
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Void> createBook(@RequestBody Book book, UriComponentsBuilder ucBuilder) {

		if (bookService.findByName(book.getName()) != null) {
			LOG.info("A book with name " + book.getName() + " already exists");
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		LOG.info("creating new book: ", book);

		bookService.insertByBook(book);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	/**
	 * Update Book Handle "/update" PUT request to update Book information
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Book putBook(@RequestBody Book book) {
		LOG.info("updating book: ", book);
		return bookService.update(book);
	}

	/**
	 * Delete Book Handle GET request for "/book/{id}" to delete Book information
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public Book deleteBook(@PathVariable Long id) {
		return bookService.delete(id);
	}

}

//@RequestBody and @ModelAttribute - Both are for same purpose to bind to the bean.

//As the name implies "RequestBody" supports only Body/POST and ModelAttribute supports only GET.

//A simple difference between @ModelAttribute and @RequestBody is that the former would look at the QueryString 
//and map it to object fields whereas the latter would look at the Body of the HTTP request.

//http://.../?name=Something&age=100
//public String doSomething(@ModelAttribute User user) { }

//{ "name": "Something", "age": "100" } in request body
//public String doSomething(@RequestBody User user) { }
