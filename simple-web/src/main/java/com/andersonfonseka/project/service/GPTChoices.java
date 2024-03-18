package com.andersonfonseka.project.service;

public class GPTChoices {

	String index;
	GPTMessage message;
	String logprobs;
	String finish_reason;

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public GPTMessage getMessage() {
		return message;
	}

	public void setMessage(GPTMessage message) {
		this.message = message;
	}

	public String getLogprobs() {
		return logprobs;
	}

	public void setLogprobs(String logprobs) {
		this.logprobs = logprobs;
	}

	public String getFinish_reason() {
		return finish_reason;
	}

	public void setFinish_reason(String finish_reason) {
		this.finish_reason = finish_reason;
	}

}
