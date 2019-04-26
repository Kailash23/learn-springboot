package com.example.demo.dto;

public class FormRequestDto {

	private String name;
	private String email;
	private String phoneNumber;
	private String password;
	private String nameErrorText;
	private String emailErrorText;
	private String phoneNumberErrorText;
	private String passwordErrorText;

	public String getNameErrorText() {
		return nameErrorText;
	}

	public void setNameErrorText(String nameErrorText) {
		this.nameErrorText = nameErrorText;
	}

	public String getEmailErrorText() {
		return emailErrorText;
	}

	public void setEmailErrorText(String emailErrorText) {
		this.emailErrorText = emailErrorText;
	}

	public String getPhoneNumberErrorText() {
		return phoneNumberErrorText;
	}

	public void setPhoneNumberErrorText(String phoneNumberErrorText) {
		this.phoneNumberErrorText = phoneNumberErrorText;
	}

	public String getPasswordErrorText() {
		return passwordErrorText;
	}

	public void setPasswordErrorText(String passwordErrorText) {
		this.passwordErrorText = passwordErrorText;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
