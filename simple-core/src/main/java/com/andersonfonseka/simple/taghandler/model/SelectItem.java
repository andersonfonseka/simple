package com.andersonfonseka.simple.taghandler.model;

public class SelectItem implements Comparable<SelectItem> {

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

	@Override
	public int compareTo(SelectItem o) {
		return this.getLabel().compareTo(o.getLabel());
	}

}
