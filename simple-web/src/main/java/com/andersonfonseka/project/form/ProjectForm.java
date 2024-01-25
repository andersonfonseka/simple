package com.andersonfonseka.project.form;

import java.util.ArrayList;
import java.util.List;

import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.taghandler.SelectItem;

public class ProjectForm extends SimpleForm {

	private String name = "";

	private String password = "";

	private String genderId = "";

	private List<SelectItem> genderList = new ArrayList<>();

	public ProjectForm() {

		genderList.add(new SelectItem("1", "Male"));
		genderList.add(new SelectItem("2", "Female"));
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

	public List<SelectItem> getGenderList() {
		return genderList;
	}

	public String getGenderId() {
		return genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}

}
