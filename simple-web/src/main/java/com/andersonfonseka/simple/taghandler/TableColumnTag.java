package com.andersonfonseka.simple.taghandler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TableColumnTag extends TagSupport {

	private String name;

	private String property;

	private String title;

	@Override
	public int doStartTag() throws JspException {

		TableTag tag = (TableTag) getParent();

		JspWriter out = pageContext.getOut();

		tag.getColumnsCaption().add(this.title);
		tag.getColumnsProperty().add(this.property);

		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return super.doEndTag();
	}

	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		return super.doAfterBody();
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
