package com.example.demo.dto;

public class DeveloperResource {

	private String name;
	private String url;

	public DeveloperResource(String name, String url) {
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