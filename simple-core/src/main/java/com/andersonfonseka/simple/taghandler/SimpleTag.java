package com.andersonfonseka.simple.taghandler;

import javax.servlet.jsp.tagext.TagSupport;

public class SimpleTag extends TagSupport {

	private String label;

	private String name;

	private String property;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

}
