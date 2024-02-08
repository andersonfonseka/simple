package com.andersonfonseka.simple.util;

import java.util.List;

public class Pagination {

	public static List getSublist(List source, int page, int rows) {

		int numOfblocks = source.size() / rows;
		if ((source.size() % rows) > 0) {
			numOfblocks++;
		}

		int blocks[][] = new int[numOfblocks][2];

		int j = 0;
		for (int i = 0; i < numOfblocks; i++) {
			blocks[i] = new int[] { j, j + (rows - 1) };
			j += rows;
		}

		PaginationList newList = new PaginationList();

		for (int i = blocks[page - 1][0]; i <= blocks[page - 1][1]; i++) {
			if (i < source.size()) {
				newList.add(source.get(i));
			}
		}

		newList.setSize(source.size());

		return newList;

	}

}
