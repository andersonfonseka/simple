package com.andersonfonseka.simple.taghandler;

public class SelectItem {

	private String value;

	private String label;

	private boolean selected;

	public SelectItem(String value, String label) {
		super();
		this.value = value;
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
