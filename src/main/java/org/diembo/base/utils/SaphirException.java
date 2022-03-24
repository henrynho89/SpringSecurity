package org.diembo.base.utils;

import org.diembo.base.enums.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SaphirException extends RuntimeException {

	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private static final long serialVersionUID = 1L;
	
	
	protected ErrorCode errorCode;
	protected String message;
	protected String backEndErrorCode;
	
	private String[] args ;
	
	protected boolean specificException	= false;
	

	
	@Override
	public void printStackTrace() {
		
		StringBuffer stringBuffer = new StringBuffer(); 
		stringBuffer.append("--------   SAPHIREXCEPTION -------------------- \n");
		stringBuffer.append("ErrorCode 	:{}\n");
		stringBuffer.append("Message 	:{}\n");
		stringBuffer.append("----------------------------------------------- \n");
		logger.error(stringBuffer.toString(), getErrorCode().name(), getMessage());
		
		super.printStackTrace();
	}
	

	
	public String getMessage() {
		return message;
	}

	public SaphirException(ErrorCode errorCode, String defaultMessage) {
		super((defaultMessage == null ? errorCode.name() : defaultMessage));
		this.errorCode 		= errorCode;
		this.message 		= defaultMessage;
	}
	
	public SaphirException(ErrorCode errorCode, String backEndErrorCode, String defaultMessage, String...args) {
		super((defaultMessage == null ? errorCode.name() : defaultMessage));
		
		this.errorCode 			= errorCode;
		this.backEndErrorCode	= backEndErrorCode;	
		this.message 			= defaultMessage;
		
		this.args 				= args;

	}
	
	
//	public SaphirException(ErrorCode errorCode, String defaultMessage, Throwable t) {
//		super((defaultMessage == null ? errorCode.name() : defaultMessage), t);
//		this.errorCode 		= errorCode;
//		this.message 		= defaultMessage;
//	}
//	
//	
//	public SaphirException(String errorCode, String defaultMessage) {
//		super((defaultMessage == null ? errorCode : defaultMessage));
//		this.errorCode 		= ErrorCode.legacy_error;
// 
//		this.message 				= defaultMessage;
//	}
//	
//	public SaphirException(String errorCode, String defaultMessage, Object...args) {
//		super((defaultMessage == null ? errorCode : defaultMessage));
//		this.errorCode 		= ErrorCode.legacy_error;
//		this.message 				= defaultMessage;
//		this.args 					= args;
//	}
//	
//
//	public SaphirException(ErrorCode errorCode,  String defaultMessage, Object...args) {
//		super((defaultMessage == null ? errorCode.name()  : defaultMessage));
//		this.errorCode 		= errorCode;
//		this.message 		= defaultMessage;
//		this.args 			= args;
//	}
//	
	
	public ErrorCode getErrorCode(){
		return errorCode;
	}
	
	public boolean isSpecificException(){
		return specificException;
	}
	
	
	
	public String getBackEndErrorCode() {
		return backEndErrorCode;
	}



	public void setBackEndErrorCode(String backEndErrorCode) {
		this.backEndErrorCode = backEndErrorCode;
	}

	public String[] getArgs() {
		return args;
	}
	
}
