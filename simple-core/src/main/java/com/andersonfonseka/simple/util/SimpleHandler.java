package com.andersonfonseka.simple.util;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.andersonfonseka.simple.controller.SimpleController;
import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.navigation.SimpleForward;

public class SimpleHandler extends DefaultHandler {

	private Map<String, SimpleController> controllerMap = new HashMap<String, SimpleController>();

	private Map<String, SimpleForm> formMap = new HashMap<String, SimpleForm>();

	private Map<String, SimpleForward> forwardMap = new HashMap<String, SimpleForward>();

	private SimpleController simpleController;

	private SimpleForm simpleForm;

	private SimpleForward simpleForward;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName.equals("simple-controller")) {
			simpleController = new SimpleController();
			simpleController.setName(attributes.getValue("name"));
			simpleController.setClassName(attributes.getValue("className"));
			simpleController.setFormName(attributes.getValue("formName"));
			simpleController.setScope(attributes.getValue("scope"));
		}

		if (qName.equals("simple-form")) {
			simpleForm = new SimpleForm();
			simpleForm.setName(attributes.getValue("name"));
			simpleForm.setClassName(attributes.getValue("className"));
		}

		if (qName.equals("simple-forward")) {
			simpleForward = new SimpleForward();
			simpleForward.setName(attributes.getValue("name"));
			simpleForward.setPath(attributes.getValue("path"));
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName.equals("simple-controller")) {
			controllerMap.put(simpleController.getName(), simpleController);
		}

		if (qName.equals("simple-form")) {
			formMap.put(simpleForm.getName(), simpleForm);
		}

		if (qName.equals("simple-forward")) {
			forwardMap.put(simpleForward.getName(), simpleForward);
		}

	}

	public Map<String, SimpleController> getControllerMap() {
		return controllerMap;
	}

	public Map<String, SimpleForm> getFormMap() {
		return formMap;
	}

	public Map<String, SimpleForward> getForwardMap() {
		return forwardMap;
	}

}
