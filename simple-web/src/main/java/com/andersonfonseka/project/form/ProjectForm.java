package com.andersonfonseka.project.form;

import java.util.ArrayList;
import java.util.List;

import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.taghandler.SelectItem;

public class ProjectForm extends SimpleForm {

	private String name = "";

	private String password = "";

	private String description = "";

	private String genderId = "";

	private List<SelectItem> genderList = new ArrayList<>();

	private String[] type;

	private List<SelectItem> typeList = new ArrayList<>();

	public ProjectForm() {

		genderList.add(new SelectItem("1", "Male"));
		genderList.add(new SelectItem("2", "Female"));

		typeList.add(new SelectItem("1", "Predictive"));
		typeList.add(new SelectItem("2", "Adaptative"));

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<SelectItem> getGenderList() {
		return genderList;
	}

	public String getGenderId() {
		return genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
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

}
