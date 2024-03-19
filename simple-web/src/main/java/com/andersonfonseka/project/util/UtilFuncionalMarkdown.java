package com.andersonfonseka.project.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UtilFuncionalMarkdown {

	public static List<String> getFuncionalities(String text) {

		List<String> funcionalities = new ArrayList();

		InputStream is = UtilFuncionalMarkdown.class.getResourceAsStream("/funcional.txt");
		BufferedReader bis = new BufferedReader(new InputStreamReader(is));

		StringTokenizer st = new StringTokenizer(text, ".");

		while (st.hasMoreTokens()) {

			String result = String.valueOf(st.nextElement());

			if (!result.trim().contains("###") && result.trim().length() > 3) {
				System.out.println(result);
				funcionalities.add(result.trim());
			}
		}

		return funcionalities;
	}

	public static void main(String[] args) {
		UtilFuncionalMarkdown.getFuncionalities("");
	}

}
