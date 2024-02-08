package com.andersonfonseka.simple.validation;

public class ValidatorMessage {

	private String message;

	private String name;

	public ValidatorMessage(String message, String name) {
		super();
		this.message = message;
		this.name = name;
	}

	@Override
	public String toString() {
		return message;
	}

}
