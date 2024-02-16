package com.andersonfonseka.simple.navigation;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonfonseka.simple.tiles.SimpleTiles;
import com.andersonfonseka.simple.tiles.SimpleTilesFragment;

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

		Map<String, SimpleTiles> tilesMap = (Map<String, SimpleTiles>) req.getServletContext().getAttribute("tilesMap");

		SimpleTiles simpleTiles = tilesMap.get(forwardMap.get(name).getPath());

		for (SimpleTilesFragment fragment : simpleTiles.getFragments()) {
			req.setAttribute(fragment.getId(), fragment.getPath());
		}

		if (simpleTiles.getExtend().length() > 0) {
			simpleTiles = tilesMap.get(simpleTiles.getExtend());

			for (SimpleTilesFragment fragment : simpleTiles.getFragments()) {
				req.setAttribute(fragment.getId(), fragment.getPath());
			}
		}

		req.getServletContext().getRequestDispatcher(simpleTiles.getPath()).forward(req, resp);

	}

}
