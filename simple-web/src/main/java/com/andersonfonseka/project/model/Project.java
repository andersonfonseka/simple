package com.andersonfonseka.project.model;

public class Project {

	private String id;

	private String name = "";

	private String description = "";

	private String expandedDescription;

	private String remove = "Remove";

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

	public String getExpandedDescription() {
		return expandedDescription;
	}

	public void setExpandedDescription(String expandedDescription) {
		this.expandedDescription = expandedDescription;
	}

	public String getRemove() {
		return remove;
	}

	public void setRemove(String remove) {
		this.remove = remove;
	}

}
