package com.andersonfonseka.simple.taghandler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TableColumnTag extends TagSupport {

	private String property;

	private String title;
	
	private String action;

	@Override
	public int doStartTag() throws JspException {

		TableTag tag = (TableTag) getParent();

		JspWriter out = pageContext.getOut();

		Column column = new Column();

		column.setTitle(this.title);
		column.setProperty(this.property);
		column.setAction(this.action);

		tag.addColumn(column);

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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
}
