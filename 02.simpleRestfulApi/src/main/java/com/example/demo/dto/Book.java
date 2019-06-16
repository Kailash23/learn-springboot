package com.example.demo.dto;

public class Book {

	private Long id;

	private String name;

	private String writer;

	private String introduction;

	public Book(Long id, String name, String writer, String introduction) {
		this.id = id;
		this.name = name;
		this.writer = writer;
		this.introduction = introduction;
	}

	public Book(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Book(String name) {
		this.name = name;
	}

	public Book() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}
