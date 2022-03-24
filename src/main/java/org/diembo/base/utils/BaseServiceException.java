package org.diembo.base.utils;



public class BaseServiceException extends RuntimeException {
	
	
	public BaseServiceException(String messageCode, String...args) {
		this.messageCode = messageCode ;
		this.args = args;
	}
	

	
	
	public String getMessageCode() {
		return messageCode;
	}
	public String[] getArgs() {
		return args;
	}
	

	
	
	private String					messageCode			;
	private String[]				args				;
	

	
	
	private static final long serialVersionUID = 1L;
	
}
