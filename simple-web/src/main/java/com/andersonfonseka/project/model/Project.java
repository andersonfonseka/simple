package com.andersonfonseka.project.model;

import java.util.UUID;

public class Project {

	private String id = UUID.randomUUID().toString();

	private String name;

	private String description;

	public Project() {
	}

	public Project(String name) {
		super();
		this.name = name;
	}

	public Project(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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

}
