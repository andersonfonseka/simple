package com.andersonfonseka.simple.servlet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andersonfonseka.simple.controller.SimpleController;
import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.util.SimpleConfigParser;
import com.andersonfonseka.simple.util.SimpleHandler;

public class SimpleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getServletContext().getAttribute("controllerMap") == null) {

			try {
				SimpleHandler handler = new SimpleHandler();
				new SimpleConfigParser(req.getServletContext(), handler);
				req.getServletContext().setAttribute("controllerMap", handler.getControllerMap());
				req.getServletContext().setAttribute("formMap", handler.getFormMap());
				req.getServletContext().setAttribute("forwardMap", handler.getForwardMap());
				req.getServletContext().setAttribute("tilesMap", handler.getTilesMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		super.service(req, resp);

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Map<String, SimpleController> controllerMap = null;
		Map<String, SimpleForm> formMap = null;

		String className = null;
		String op = null;

		if (!req.getRequestURI().contains(".jsp")) {

			className = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/") + 1,
					req.getRequestURI().lastIndexOf("."));
			op = req.getParameter("op");

			controllerMap = (Map<String, SimpleController>) req.getServletContext().getAttribute("controllerMap");
			formMap = (Map<String, SimpleForm>) req.getServletContext().getAttribute("formMap");
		}

		if (null != controllerMap && controllerMap.containsKey(className)) {

			try {

				SimpleController simpleController = controllerMap.get(className);
				Object controller = Class.forName(simpleController.getClassName()).getDeclaredConstructor().newInstance();

				SimpleForm form = null;

				if (simpleController.getScope().equals("request")) {
					form = (SimpleForm) req.getAttribute(simpleController.getFormName());
				} else if (simpleController.getScope().equals("session")) {
					form = (SimpleForm) req.getSession().getAttribute(simpleController.getFormName());
				}

				if (null == form) {
					String formClassName = formMap.get(simpleController.getFormName()).getClassName();
					form = (SimpleForm) Class.forName(formClassName).getDeclaredConstructor().newInstance();
				}

				Enumeration<String> enumAttr = req.getParameterNames();

				while (enumAttr.hasMoreElements()) {

					String element = enumAttr.nextElement();

					if (!element.equals("op") && !element.equals("tPage") && !element.equals("tRows")) {

						try {

							Method mForm = form.getClass().getMethod(
									"set" + element.substring(0, 1).toUpperCase() + element.substring(1),
									new Class[] { String.class });

							mForm.invoke(form, req.getParameterValues(element));

						} catch (Exception ex) {

							Field mField = form.getClass().getDeclaredField(element);
							mField.setAccessible(true);
							mField.set(form, req.getParameterValues(element));

						}
					}
				}

				Method m = controller.getClass().getMethod(op,
						new Class[] { HttpServletRequest.class, HttpServletResponse.class, SimpleForm.class });
				m.invoke(controller, req, resp, form);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
