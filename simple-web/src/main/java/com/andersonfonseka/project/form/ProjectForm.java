package com.andersonfonseka.project.form;

import java.util.ArrayList;
import java.util.List;

import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.taghandler.SelectItem;
import com.andersonfonseka.simple.validation.Required;

public class ProjectForm extends SimpleForm {

	@Required
	private String name = "";

	@Required
	private String description = "";

	private String[] type;

	private List<SelectItem> typeList = new ArrayList<>();

	private String framework;

	private List<SelectItem> frameworkList = new ArrayList<>();

	private List projects = new ArrayList<>();

	public ProjectForm() {

		typeList.add(new SelectItem("1", "Predictive"));
		typeList.add(new SelectItem("2", "Adaptative"));

		frameworkList.add(new SelectItem("1", "Scrum"));
		frameworkList.add(new SelectItem("2", "Kanban"));
		frameworkList.add(new SelectItem("3", "PMBoK"));
		frameworkList.add(new SelectItem("4", "RUP"));

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

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
	}

	public List<SelectItem> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<SelectItem> typeList) {
		this.typeList = typeList;
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

	public List getProjects() {
		return projects;
	}

	public void setProjects(List projects) {
		this.projects = projects;
	}

}
