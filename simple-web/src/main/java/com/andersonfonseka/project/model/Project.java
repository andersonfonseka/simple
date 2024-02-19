package com.andersonfonseka.project.model;

import java.util.ArrayList;
import java.util.List;

import com.andersonfonseka.simple.taghandler.model.SelectItem;
import com.andersonfonseka.simple.validation.Validate;
import com.andersonfonseka.simple.validation.ValidateEnum;

public class Project {

	private String id;

	private String name = "";

	private String description = "";
	
	private String approach = "";

	private String framework = "";
	
	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApproach() {
		return approach;
	}

	public void setApproach(String approach) {
		this.approach = approach;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}
	
}
