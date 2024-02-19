package com.andersonfonseka.project.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.taghandler.model.SelectItem;
import com.andersonfonseka.simple.validation.Validate;
import com.andersonfonseka.simple.validation.ValidateEnum;

public class ProjectForm extends SimpleForm {

	private String id;

	@Validate(types = { ValidateEnum.REQUIRED }, fieldName = "Name")
	private String name = "";

	@Validate(types = { ValidateEnum.REQUIRED }, fieldName = "Description")
	private String description = "";

	@Validate(types = { ValidateEnum.REQUIRED }, fieldName = "Management Approach")
	private String approach;

	private List<SelectItem> approachList = new ArrayList<>();

	@Validate(types = { ValidateEnum.REQUIRED }, fieldName = "Management Framework")
	private String framework = "";

	private List<SelectItem> frameworkList = new ArrayList<>();

	private Collection projects = new ArrayList<>();

	public ProjectForm() {

		approachList.add(new SelectItem("", "Choose one..."));
		approachList.add(new SelectItem("1", "Predictive"));
		approachList.add(new SelectItem("2", "Adaptative"));

		frameworkList.add(new SelectItem("1", "Scrum"));
		frameworkList.add(new SelectItem("2", "Kanban"));
		frameworkList.add(new SelectItem("3", "PMBoK"));
		frameworkList.add(new SelectItem("4", "RUP"));

	}

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

	public String getApproach() {
		return approach;
	}

	public void setApproach(String approach) {
		this.approach = approach;
	}

	public List<SelectItem> getApproachList() {
		return approachList;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}

	public List<SelectItem> getFrameworkList() {
		return frameworkList;
	}

	public Collection getProjects() {
		return projects;
	}

	public void setProjects(Collection projects) {
		this.projects = projects;
	}

}
