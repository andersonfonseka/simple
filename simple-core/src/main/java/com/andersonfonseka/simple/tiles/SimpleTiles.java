package com.andersonfonseka.simple.tiles;

import java.util.ArrayList;
import java.util.List;

public class SimpleTiles {

	private String definition;

	private String path;

	private String extend = "";

	private List<SimpleTilesFragment> fragments = new ArrayList<>();

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public void add(SimpleTilesFragment fragment) {
		fragments.add(fragment);
	}

	public List<SimpleTilesFragment> getFragments() {
		return fragments;
	}

}
