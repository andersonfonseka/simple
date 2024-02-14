package com.andersonfonseka.simple.taghandler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.andersonfonseka.simple.taghandler.model.Column;
import com.andersonfonseka.simple.taghandler.model.Param;

public class SimpleTableColumnTag extends TagSupport {

	private String property;

	private String title;

	private String action;

	private Map<String, Param> params = new HashMap<String, Param>();

	public SimpleTableColumnTag() {
		this.params.clear();
	}

	@Override
	public int doStartTag() throws JspException {

		SimpleTableTag tag = (SimpleTableTag) getParent();

		JspWriter out = pageContext.getOut();

		Column column = new Column();

		column.setTitle(this.title);
		column.setProperty(this.property);
		column.setAction(this.action);
		column.setParams(this.params);

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

	public void addParam(Param pParam) {
		this.params.put(pParam.getId(), pParam);
	}

}
