package com.andersonfonseka.simple.taghandler;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.andersonfonseka.simple.taghandler.model.SelectItem;

public class SimpleSelectTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String label;

	private String name;

	private String property;

	private String type;

	private String items;

	private List<SelectItem> selectItems = new ArrayList<SelectItem>();

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
						.getMethod("get" + this.items.substring(0, 1).toUpperCase() + this.items.substring(1));

				if (null != m) {
					this.selectItems = (List<SelectItem>) m.invoke(form);
				}

				m = form.getClass().getMethod("get" + this.name.substring(0, 1).toUpperCase() + this.name.substring(1));

				if (null != m) {
					result = String.valueOf(m.invoke(form));
				}
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		try {

			StringBuilder sb = new StringBuilder();

			sb.append("<label for=" + this.label + " class=\"form-label\">" + this.label + "</label>");

			sb.append("<select class=\"form-select\" type=\"" + this.type + "\" id=\"" + this.label + "\" name=\""
					+ this.name + "\" value=\"" + this.name + "\">\n");

			for (SelectItem selectItem : selectItems) {

				if (selectItem.getValue().equals(result)) {
					selectItem.setSelected(true);
				}

				if (selectItem.isSelected()) {
					sb.append("<option selected value=\"" + selectItem.getValue() + "\">" + selectItem.getLabel()
							+ "</option>\n");
				} else {
					sb.append(
							"<option value=\"" + selectItem.getValue() + "\">" + selectItem.getLabel() + "</option>\n");
				}
			}

			sb.append("</select>");

			out.print(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SKIP_BODY;
	}

}
