package com.andersonfonseka.simple.taghandler;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class SimpleAlertTag extends SimpleTag {

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();

		List<String> values = (List<String>) pageContext.getRequest().getAttribute("alert");

		StringBuilder sb = new StringBuilder();

		if (null != values && !values.isEmpty()) {
			sb.append("<div class=\"alert alert-warning\" role=\"alert\">"
					+ "<h4 class=\"alert-heading\">Message</h4><hr>" + "<ul>");
			for (String msg : values) {

				sb.append("<li>" + msg + "</li>");

			}
			sb.append("</ul></div>");
			values.clear();
		}

		try {
			out.print(sb.toString());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

}
