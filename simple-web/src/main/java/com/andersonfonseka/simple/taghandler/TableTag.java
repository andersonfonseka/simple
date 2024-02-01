package com.andersonfonseka.simple.taghandler;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TableTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String name;

	private String property;

	private String var;

	private List items = new ArrayList<Object>();

	private List<String> columnsCaption = new ArrayList<String>();

	private List<String> columnsProperty = new ArrayList<String>();

	private String rows = "0";

	private int counter = 0;

	private String paginationUrl;

	@Override
	public int doStartTag() throws JspException {

		Object form = pageContext.getRequest().getAttribute(this.name);

		Method m;

		try {
			if (null != form) {

				m = form.getClass()
						.getMethod("get" + this.property.substring(0, 1).toUpperCase() + this.property.substring(1));

				if (null != m) {
					this.items = (List<Object>) m.invoke(form);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.columnsCaption.clear();
		this.columnsProperty.clear();

		counter = 0;

		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();

		StringBuilder sb = new StringBuilder();

		int pRows = Integer.valueOf(this.rows);

		String pageNumber = String.valueOf(pageContext.getRequest().getParameter("tPage"));

		if (pageNumber.equals("null")) {
			pageNumber = "1";
		}

		if (pRows < this.items.size()) {

			int pages = this.items.size() / pRows;
			int modPages = this.items.size() % pRows;

			if (modPages > 0) {
				pages++;
			}

			sb.append("<nav aria-label=\"Page navigation example\"><ul class=\"pagination justify-content-end\">\n");

			for (int i = 0; i < pages; i++) {

				if ((i + 1) == Integer.valueOf(pageNumber).intValue()) {
					sb.append("<li class=\"page-item active\"><a class=\"page-link\" href=\"" + this.paginationUrl
							+ "&tPage=" + (i + 1) + "&tRows=" + pRows + "\">" + (i + 1) + "</a></li>\n");
				} else {
					sb.append("<li class=\"page-item\"><a class=\"page-link\" href=\"" + this.paginationUrl + "&tPage="
							+ (i + 1) + "&tRows=" + pRows + "\">" + (i + 1) + "</a></li>\n");
				}
			}

			sb.append("</ul></nav>\n");

		}

		sb.append("<table class=\"table table-striped\"><thead><tr>\n");

		for (String string : columnsCaption) {
			sb.append("<th scope=\"col\">" + string + "</th>\n");
		}

		sb.append("</tr></thead>\n");

		sb.append("<tbody>");

		for (Object object : this.items) {

			if (counter == Integer.valueOf(rows)) {
				counter = 0;
				break;
			}

			counter++;

			sb.append("<tr>");

			Object obj = object;

			for (String string : columnsProperty) {

				try {
					Method mProperty = obj.getClass()
							.getDeclaredMethod("get" + string.substring(0, 1).toUpperCase() + string.substring(1));
					String result = String.valueOf(mProperty.invoke(obj));

					sb.append("<td>" + result + "</td>\n");

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			sb.append("</tr>");

		}

		sb.append("</tbody>");

		sb.append("</table>");

		try {
			out.print(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return super.doEndTag();
	}

	public String getName() {
		return name;
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

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public List<String> getColumnsCaption() {
		return columnsCaption;
	}

	public List<String> getColumnsProperty() {
		return columnsProperty;
	}

	public String getPaginationUrl() {
		return paginationUrl;
	}

	public void setPaginationUrl(String paginationUrl) {
		this.paginationUrl = paginationUrl;
	}

}
