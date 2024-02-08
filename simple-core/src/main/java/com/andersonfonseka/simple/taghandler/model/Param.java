package com.andersonfonseka.simple.taghandler.model;

public class Param {

	private String id;

	private String property;

	private String title;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProperty() {
		return this.property.substring(0, 1).toUpperCase() + this.property.substring(1);
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
