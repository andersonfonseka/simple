package com.andersonfonseka.simple.taghandler;

import java.lang.reflect.Method;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

public class SimpleInputTag extends SimpleTag {

	private String type;

	private String placeHolder;

	public void setType(String type) {
		this.type = type;
	}

	public void setPlaceHolder(String placeHolder) {
		this.placeHolder = placeHolder;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();

		Object form = pageContext.getRequest().getAttribute(getProperty());

		Method m;
		String result = "";

		try {
			if (null != form) {

				m = form.getClass().getMethod("get" + getName().substring(0, 1).toUpperCase() + getName().substring(1),
						null);

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

			if (!this.type.equals("hidden")) {
				sb.append("<label for=" + getLabel() + " class=\"form-label\">" + getLabel() + "</label>");
			}
			
			if (result.length() > 0) {
				sb.append("<input type=" + this.type + " id=" + getLabel() + " name=" + getName() + " value=\"" + result
						+ "\" class=\"form-control\" placeholder=" + this.placeHolder + " aria-label="
						+ this.placeHolder + " aria-describedby=\"basic-addon1\">");
			} else {
				sb.append("<input type=" + this.type + " id=" + getLabel() + " name=" + getName()
						+ " class=\"form-control\" placeholder=" + this.placeHolder + " aria-label=" + this.placeHolder
						+ " aria-describedby=\"basic-addon1\">");
			}

			out.print(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

}
