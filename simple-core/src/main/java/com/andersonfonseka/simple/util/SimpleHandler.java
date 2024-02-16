package com.andersonfonseka.simple.util;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.andersonfonseka.simple.controller.SimpleController;
import com.andersonfonseka.simple.form.SimpleForm;
import com.andersonfonseka.simple.navigation.SimpleForward;
import com.andersonfonseka.simple.tiles.SimpleTiles;
import com.andersonfonseka.simple.tiles.SimpleTilesFragment;

public class SimpleHandler extends DefaultHandler {

	private Map<String, SimpleController> controllerMap = new HashMap<String, SimpleController>();

	private Map<String, SimpleForm> formMap = new HashMap<String, SimpleForm>();

	private Map<String, SimpleForward> forwardMap = new HashMap<String, SimpleForward>();

	private Map<String, SimpleTiles> tilesMap = new HashMap<String, SimpleTiles>();

	private SimpleController simpleController;

	private SimpleForm simpleForm;

	private SimpleForward simpleForward;

	private SimpleTiles simpleTiles;

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

		if (qName.equals("simple-tiles")) {
			simpleTiles = new SimpleTiles();
			simpleTiles.setDefinition(attributes.getValue("definition"));
			simpleTiles.setPath(attributes.getValue("path"));
			simpleTiles.setExtend(attributes.getValue("extend"));
		}

		if (qName.equals("simple-tiles-fragment")) {
			SimpleTilesFragment simpleTilesFragment = new SimpleTilesFragment();
			simpleTilesFragment.setId(attributes.getValue("id"));
			simpleTilesFragment.setPath(attributes.getValue("path"));

			simpleTiles.add(simpleTilesFragment);
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

		if (qName.equals("simple-tiles")) {
			tilesMap.put(simpleTiles.getDefinition(), simpleTiles);
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

	public Map<String, SimpleTiles> getTilesMap() {
		return tilesMap;
	}

}
