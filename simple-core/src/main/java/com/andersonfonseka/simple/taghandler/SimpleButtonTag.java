package com.andersonfonseka.simple.taghandler;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SimpleButtonTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String type = "submit";

	private String style = "btn btn-primary";

	private String title = "";

	private String action = "";

	@Override
	public int doStartTag() throws JspException {

		JspWriter out = pageContext.getOut();

		try {

			if (this.action.length() > 0) {
				out.print("<button type=\"" + this.type + "\" class=\"" + this.style + "\" onclick=\"" + this.action
						+ "\">" + this.title + "</button>");
			} else {
				out.print(
						"<button type=\"" + this.type + "\" class=\"" + this.style + "\">" + this.title + "</button>");

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
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

}
