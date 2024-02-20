package com.andersonfonseka.simple.enums;

public enum ScopeEnum {

	REQUEST("request"), SESSION("session"), APPLICATION("application");
	
	private String scope;

	private ScopeEnum(String scope) {
		this.scope = scope;
	}

	public String getScope() {
		return scope;
	}
	
}
