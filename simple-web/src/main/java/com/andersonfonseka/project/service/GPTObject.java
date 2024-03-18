package com.andersonfonseka.project.service;

public class GPTObject {

	String id;
	String object;
	String created;
	String model;
	GPTChoices[] choices;
	GPTUsage usage;
	String system_fingerprint;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public GPTChoices[] getChoices() {
		return choices;
	}

	public void setChoices(GPTChoices[] choices) {
		this.choices = choices;
	}

	public GPTUsage getUsage() {
		return usage;
	}

	public void setUsage(GPTUsage usage) {
		this.usage = usage;
	}

	public String getSystem_fingerprint() {
		return system_fingerprint;
	}

	public void setSystem_fingerprint(String system_fingerprint) {
		this.system_fingerprint = system_fingerprint;
	}

	public String toString() {
		String result = this.choices[0].getMessage().getContent();
		return result;
	}

}
