package com.andersonfonseka.project.form;

import java.util.ArrayList;
import java.util.List;

import com.andersonfonseka.project.model.Project;
import com.andersonfonseka.simple.annotation.SForm;
import com.andersonfonseka.simple.annotation.SValidate;
import com.andersonfonseka.simple.enums.ValidateEnum;
import com.andersonfonseka.simple.form.SimpleForm;

@SForm
public class ProjectForm extends SimpleForm {

	private String id;

	@SValidate(types = { ValidateEnum.REQUIRED }, fieldName = "Name")
	private String name = "";

	@SValidate(types = { ValidateEnum.REQUIRED }, fieldName = "Description")
	private String description = "";

	private String expandedDescription;

	private List<Project> projects = new ArrayList<Project>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
