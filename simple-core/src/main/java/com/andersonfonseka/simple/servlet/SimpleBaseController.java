package com.andersonfonseka.simple.servlet;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.reflections.Reflections;

import com.andersonfonseka.simple.annotation.SController;
import com.andersonfonseka.simple.annotation.SForm;
import com.andersonfonseka.simple.controller.SimpleController;
import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.navigation.SimpleForward;
import com.andersonfonseka.simple.util.SimpleConfigParser;
import com.andersonfonseka.simple.util.SimpleHandler;

public class SimpleBaseController extends HttpServlet {

	private HttpServletRequest request;
	private HttpServletResponse response;

	private static final long serialVersionUID = 1L;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Reflections reflections = new Reflections(req.getServletContext().getInitParameter("package"));

		if (req.getServletContext().getAttribute("controllerMap") == null) {

			try {
				SimpleHandler handler = new SimpleHandler();
				new SimpleConfigParser(req.getServletContext(), handler);
				req.getServletContext().setAttribute("controllerMap", loadControllers(reflections));
				req.getServletContext().setAttribute("formMap", loadForm(reflections));
				req.getServletContext().setAttribute("forwardMap", handler.getForwardMap());
				req.getServletContext().setAttribute("tilesMap", handler.getTilesMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		super.service(req, resp);

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

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
				Object controller = Class.forName(simpleController.getClassName()).getDeclaredConstructor()
						.newInstance();

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

				Method mRequest = controller.getClass().getMethod("setRequest",
						new Class[] { HttpServletRequest.class });
				mRequest.invoke(controller, req);

				Method m = controller.getClass().getMethod(op, new Class[] { SimpleForm.class });
				String forwardValue = String.valueOf(m.invoke(controller, form));

				SimpleForward.doForward(forwardValue, req, resp);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private Map<String, SimpleController> loadControllers(Reflections reflections) {

		Map<String, SimpleController> controllerMap = new HashMap<String, SimpleController>();

		Set<Class<?>> annotatedController = reflections.getTypesAnnotatedWith(SController.class);

		for (Class<?> class1 : annotatedController) {
			SController annotation = class1.getDeclaredAnnotation(SController.class);

			SimpleController simpleController = new SimpleController();
			simpleController.setClassName(class1.getName());

			if (null != annotation.name() && annotation.name().trim().length() > 0) {
				simpleController.setName(annotation.name());
			} else {
				simpleController.setName(class1.getSimpleName());
			}

			simpleController.setFormName(annotation.formName());
			simpleController.setScope(annotation.scope().getScope());

			controllerMap.put(simpleController.getName(), simpleController);
		}

		return controllerMap;
	}

	private Map<String, SimpleForm> loadForm(Reflections reflections) {

		Map<String, SimpleForm> formMap = new HashMap<String, SimpleForm>();

		Set<Class<?>> annotatedForm = reflections.getTypesAnnotatedWith(SForm.class);

		for (Class<?> class1 : annotatedForm) {
			SForm annotation = class1.getDeclaredAnnotation(SForm.class);

			SimpleForm simpleForm = new SimpleForm();
			simpleForm.setClassName(class1.getName());

			if (null != annotation.name() && annotation.name().trim().length() > 0) {
				simpleForm.setName(annotation.name());
			} else {
				simpleForm.setName(class1.getSimpleName());
			}

			formMap.put(simpleForm.getName(), simpleForm);
		}

		return formMap;
	}

}
