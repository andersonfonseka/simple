package com.andersonfonseka.simple.util;

import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SimpleConfigParser {

	public SimpleConfigParser(ServletContext context, SimpleHandler handler) throws Exception {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();

		InputStream is = context.getResourceAsStream("/WEB-INF/simple-config.xml");

		parser.parse(is, handler);
	}
}
