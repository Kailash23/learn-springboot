package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "usersnew")
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty(message = "name cannot be empty")
	@Size(min = 2, max = 20, message = "name must be greater than 2 and less than 20 words")
	private String name;

	@NotNull(message = "age cannot be empty")
	@Min(value = 0, message = "age greater than 0")
	@Max(value = 300, message = "age is not greater than 300")
	private Integer age;

	@NotEmpty(message = "Birth time cannot be empty")
	private String birthday;

	public User(String name, Integer age, String birthday) {
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

	public User() {
	}

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}

}
