package com.andersonfonseka.simple.taghandler;

import java.lang.reflect.Method;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SimpleTextAreaTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String label;

	private String name;

	private String property;

	private String rows;

	private String placeHolder;

	public void setLabel(String label) {
		this.label = label;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();

		Object form = pageContext.getRequest().getAttribute(this.property);

		Method m;
		String result = "";

		try {
			if (null != form) {

				m = form.getClass().getMethod("get" + this.name.substring(0, 1).toUpperCase() + this.name.substring(1));

				if (null != m) {
					result = String.valueOf(m.invoke(form));
				}
			}

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			StringBuilder sb = new StringBuilder();

			if (result.length() > 0) {
				sb.append("<label for=" + this.label + " class=\"form-label\">" + this.label + "</label>");
				sb.append("<textarea rows=\"" + this.rows + "\" id=\"" + this.label + "\" name=\"" + this.name
						+ "\" class=\"form-control\" placeholder=" + this.placeHolder + " aria-label="
						+ this.placeHolder + " aria-describedby=\"basic-addon1\">" + result + "</textarea>");
			} else {
				sb.append("<label for=" + this.label + " class=\"form-label\">" + this.label + "</label>");
				sb.append("<textarea rows=\"" + this.rows + "\" id=\"" + this.label + "\" name=\"" + this.name
						+ "\" class=\"form-control\" placeholder=" + this.placeHolder + " aria-label="
						+ this.placeHolder + " aria-describedby=\"basic-addon1\"></textarea>");
			}

			out.print(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

}
