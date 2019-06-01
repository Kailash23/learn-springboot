package com.example.demo.dto;

public class Details {

	private String name;
	private String url;

	public Details(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public String getUrl() {
		return url;
	}
}