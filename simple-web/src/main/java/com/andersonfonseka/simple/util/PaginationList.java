package com.andersonfonseka.simple.util;

import java.util.ArrayList;

public class PaginationList extends ArrayList {

	private int pSize;

	public void setSize(int pSize) {
		this.pSize = pSize;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.pSize;
	}

}
