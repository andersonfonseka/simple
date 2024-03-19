package com.andersonfonseka.simple.taghandler.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Button {

	private String property = "";

	private String title = "";

	private String action = "";

	private String style = "btn btn-primary";

	private Map<String, Param> params = new HashMap<String, Param>();

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

	public List<Param> getParams() {
		return new ArrayList<Param>(this.params.values());
	}

	public void setParams(Map<String, Param> params) {
		this.params = params;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
