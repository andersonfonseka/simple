package com.andersonfonseka.simple.taghandler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class ParamTag extends TagSupport {

	private String id;

	private String property;

	@Override
	public int doStartTag() throws JspException {

		TableColumnTag tag = (TableColumnTag) getParent();

		JspWriter out = pageContext.getOut();

		Param param = new Param();

		param.setId(this.id);
		param.setProperty(this.property);

		tag.addParam(param);

		return EVAL_BODY_INCLUDE;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}