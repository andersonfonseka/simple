package com.andersonfonseka.simple.util;

import java.util.ArrayList;

public class PaginationList extends ArrayList<Object> {

	private static final long serialVersionUID = 1L;
	
	private int pSize;

	public void setSize(int pSize) {
		this.pSize = pSize;
	}

	@Override
	public int size() {
		return this.pSize;
	}

}
