package com.smartinvoice.model;

import com.smartinvoice.utils.Status;

public class Response {
	
	private String message = Status.Success.toString();
	private String description;
	private String code = "" + Status.Success.getCode();
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String toString() {
		return "Response [message=" + message + ", description=" + description + ", code=" + code + "]";
	}
	
	
	
	

}
