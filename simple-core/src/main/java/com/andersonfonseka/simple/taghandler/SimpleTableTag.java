package com.andersonfonseka.simple.taghandler;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.andersonfonseka.simple.taghandler.model.Column;
import com.andersonfonseka.simple.taghandler.model.Param;

public class SimpleTableTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String name;

	private String property;

	private String var;

	private List<Object> items = new ArrayList<Object>();

	private List<Column> columns = new ArrayList<Column>();

	private String rows = "0";

	private int counter = 0;

	private String paginationUrl;

	@Override
	public int doStartTag() throws JspException {

		Object form = pageContext.getRequest().getAttribute(this.name);

		Method m;

		try {
			if (null != form) {

				m = form.getClass().getMethod("get" + this.getProperty());

				if (null != m) {
					this.items = (List<Object>) m.invoke(form);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.columns.clear();

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

		for (Column col : columns) {
			sb.append("<th scope=\"col\">" + col.getTitle() + "</th>\n");
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

			for (Column col : columns) {

				try {
					Method mProperty = obj.getClass().getDeclaredMethod(col.getProperty());
					String result = String.valueOf(mProperty.invoke(obj));

					if (col.getAction() != null && col.getAction().trim().length() > 0) {

						StringBuilder builder = new StringBuilder();

						if (null != col.getParams() && !col.getParams().isEmpty()) {
							for (Param param : col.getParams()) {

								Method m = obj.getClass().getMethod("get" + param.getProperty());
								String value = "";

								if (null != m) {
									value = String.valueOf(m.invoke(obj));
								}

								builder.append("&" + param.getId() + "=" + value);
							}

							sb.append("<td><button type=\"button\" class=\"" + col.getStyle() + "\" onclick=goUrl('"
									+ col.getAction() + builder.toString() + "');>" + result + "</button></td>\n");

						}

					} else {
						sb.append("<td>" + result + "</td>\n");
					}

				} catch (Exception e) {
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
		return this.property.substring(0, 1).toUpperCase() + this.property.substring(1);
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

	public String getPaginationUrl() {
		return paginationUrl;
	}

	public void setPaginationUrl(String paginationUrl) {
		this.paginationUrl = paginationUrl;
	}

	public void addColumn(Column column) {
		this.columns.add(column);
	}

}
