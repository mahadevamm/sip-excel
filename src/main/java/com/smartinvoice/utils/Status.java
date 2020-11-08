package com.smartinvoice.utils;

public enum Status {
	
	Success, Failed;
	 
	
	private int code;
	
	
	private Status() {

	}

	
	private Status(int code) {
		this.code = code;
	}
	 

	public int getCode() {
		return code;
	}
 
}
