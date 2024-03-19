package com.andersonfonseka.simple.taghandler;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.andersonfonseka.simple.taghandler.model.Button;
import com.andersonfonseka.simple.taghandler.model.Param;

public class SimpleButtonTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String type = "submit";

	private String style = "btn btn-primary";

	private String title = "";

	private String action = "";

	private String name = "";

	private Map<String, Param> params = new HashMap<String, Param>();

	@Override
	public int doStartTag() throws JspException {

		Button btn = new Button();

		btn.setTitle(this.title);
		btn.setAction(this.action);
		btn.setParams(this.params);
		btn.setStyle(this.style);

		return EVAL_BODY_INCLUDE;

	}

	@Override
	public int doEndTag() throws JspException {

		JspWriter out = pageContext.getOut();

		StringBuilder sb = new StringBuilder();

		Object form = pageContext.getRequest().getAttribute(this.name);

		try {

			if (getAction() != null && getAction().trim().length() > 0 && !getParams().isEmpty()) {

				StringBuilder builder = new StringBuilder();

				if (null != getParams() && !getParams().isEmpty()) {
					for (Param param : getParams()) {

						Method m = form.getClass().getMethod("get" + param.getProperty());
						String value = "";

						if (null != m) {
							value = String.valueOf(m.invoke(form));
						}

						builder.append("&" + param.getId() + "=" + value);
					}

					sb.append("<button type=\"button\" class=\"" + getStyle() + "\" onclick=goUrl('" + getAction()
							+ builder.toString() + "');>" + this.title + "</button>\n");

				}

			} else if (getAction() != null && getAction().trim().length() > 0 && getParams().isEmpty()) {
				sb.append("<button type=\"button\" class=\"" + getStyle() + "\" onclick=goUrl('" + getAction() + "');>"
						+ this.title + "</button>\n");
			} else {
				sb.append("<button type=\"submit\" class=\"" + getStyle() + "\">" + this.title + "</button></td>\n");
			}

			try {
				out.print(sb.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return super.doEndTag();

	}

	@Override
	public int doAfterBody() throws JspException {
		return super.doAfterBody();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void addParam(Param pParam) {
		this.params.put(pParam.getId(), pParam);
	}

	public List<Param> getParams() {
		return new ArrayList<Param>(this.params.values());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
