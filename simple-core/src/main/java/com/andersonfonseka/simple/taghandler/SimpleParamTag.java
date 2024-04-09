package com.andersonfonseka.simple.taghandler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.andersonfonseka.simple.taghandler.model.Param;

public class SimpleParamTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String id;

	private String property;

	private String value;

	@Override
	public int doStartTag() throws JspException {

		Param param = new Param();

		param.setId(this.id);
		param.setProperty(this.property);
		param.setValue(this.value);

		if (getParent() instanceof SimpleTableColumnTag) {
			SimpleTableColumnTag tag = (SimpleTableColumnTag) getParent();
			tag.addParam(param);
		} else if (getParent() instanceof SimpleButtonTag) {
			SimpleButtonTag tag = (SimpleButtonTag) getParent();
			tag.addParam(param);
		} else if (getParent() instanceof SimpleLinkTag) {
			SimpleLinkTag tag = (SimpleLinkTag) getParent();
			tag.addParam(param);
		}

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
