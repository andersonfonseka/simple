package com.andersonfonseka.simple.navigation;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleForward {

	private String name;

	private String path;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public static void doForward(String name, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Map<String, SimpleForward> forwardMap = (Map<String, SimpleForward>) req.getServletContext()
				.getAttribute("forwardMap");

		RequestDispatcher rd = req.getRequestDispatcher(forwardMap.get(name).getPath());
		rd.forward(req, resp);
	}

}
