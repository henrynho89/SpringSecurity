package org.diembo.base.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaphirHttpException extends RuntimeException {

	protected Logger logger = LoggerFactory.getLogger(getClass());	
	
	protected int statusCode;
	protected String message;
	protected String errorCode;
	

	public SaphirHttpException(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public SaphirHttpException(int statusCode, String errorCode, String message) {
		this.statusCode = statusCode;
		this.message 	= message;
		this.errorCode 	= errorCode; 
	}


	@Override
	public void printStackTrace() {
		
		StringBuffer stringBuffer = new StringBuffer(); 
		stringBuffer.append("--------   SAPHIR HTTP EXCEPTION -------------------- \n");
		stringBuffer.append("StatusCode :{}\n");
		stringBuffer.append("Message 	:{}\n");
		stringBuffer.append("----------------------------------------------- \n");
		logger.error(stringBuffer.toString(), getStatusCode(), getMessage());
		
		super.printStackTrace();
	}



	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	private static final long serialVersionUID = 1L;
	
}
