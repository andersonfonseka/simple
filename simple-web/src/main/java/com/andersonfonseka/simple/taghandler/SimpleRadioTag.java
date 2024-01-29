package com.andersonfonseka.simple.taghandler;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SimpleRadioTag extends TagSupport {

	private String label;

	private String name;

	private String property;

	private String type;

	private String items;

	private List<SelectItem> selectItems = new ArrayList();

	public void setLabel(String label) {
		this.label = label;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();

		Object form = pageContext.getRequest().getAttribute(this.property);

		Method m;

		String result = "";

		try {
			if (null != form) {

				m = form.getClass()
						.getMethod("get" + this.items.substring(0, 1).toUpperCase() + this.items.substring(1), null);

				if (null != m) {
					this.selectItems = (List<SelectItem>) m.invoke(form);
				}

				m = form.getClass().getMethod("get" + this.name.substring(0, 1).toUpperCase() + this.name.substring(1),
						null);

				if (null != m) {
					result = String.valueOf(m.invoke(form));
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {

			StringBuilder sb = new StringBuilder();

			sb.append("<label for=" + this.label + " class=\"form-label\">" + this.label + "</label><br/>");

			int i = 0;
			for (SelectItem selectItem : selectItems) {

				if (checkValue(selectItem.getValue(), result)) {
					sb.append("<div class=\"form-check form-check-inline\">\n");
					sb.append("<input class=\"form-check-input\" type=\"radio\" value=\"" + selectItem.getValue()
							+ "\" id=\"" + this.name + "\" name=\"" + this.name + "\" checked>");
					sb.append("<label class=\"form-check-label\" for=\"" + this.name + "\">");
					sb.append(selectItem.getLabel());
					sb.append("</label>");
					sb.append("</div>");
				} else {
					sb.append("<div class=\"form-check form-check-inline\">\n");
					sb.append("<input class=\"form-check-input\" type=\"radio\" value=\"" + selectItem.getValue()
							+ "\" id=\"" + this.name + "\" name=\"" + this.name + "\" >");
					sb.append("<label class=\"form-check-label\" for=\"" + this.name + "\">");
					sb.append(selectItem.getLabel());
					sb.append("</label>");
					sb.append("</div>");
				}

				i++;
			}

			out.print(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

	private boolean checkValue(String value, String values) {

		boolean result = false;
		result = value.equals(values);
		return result;
	}

}
