package com.andersonfonseka.simple.taghandler;

import java.lang.reflect.Method;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SimpleContentTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String name;

	private String property;

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
				sb.append(result);
			}

			out.print(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

}
