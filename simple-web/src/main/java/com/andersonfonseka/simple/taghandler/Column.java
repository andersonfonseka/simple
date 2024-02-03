package com.andersonfonseka.simple.taghandler;

public class Column {

	private String property = "";

	private String title = "";
	
	private String action = "";

	public String getProperty() {
		return "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}
