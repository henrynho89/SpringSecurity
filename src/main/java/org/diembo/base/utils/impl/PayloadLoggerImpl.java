package org.diembo.base.utils.impl;

import java.util.Date;

import org.diembo.base.managers.ReleaseManager;
import org.diembo.base.msg.BaseRequest;
import org.diembo.base.msg.BaseResponse;
import org.diembo.base.utils.PayloadLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@Component
public class PayloadLoggerImpl implements PayloadLogger {
	
	@Autowired
	protected ReleaseManager 	releaseManager;
	
	public void logRequestPayload(
			String serviceName,
			String sessionId,
			String requestId,
			String uri, 
			BaseRequest request) {
		
		String password = request.getPassword();
		if ( (password != null) && (! password.equals(""))) {
			request.setPassword("**********");
		}
		
		String digestedPassword = request.getDigestedPassword();
		if ( (digestedPassword != null) && (! digestedPassword.equals(""))) {
			request.setDigestedPassword("**********");
		}
		
		String newPassword = request.getNewPassword();
		if ( (newPassword != null) && (! newPassword.equals(""))) {
			request.setNewPassword("**********");
		}
		
		String token = request.getToken();
		if ( (token != null) && (! token.equals(""))) {
			request.setToken("*******************");
		}
		String otp = request.getOtp();
		if ( (otp != null) && (! otp.equals(""))) {
			request.setOtp("****");
		}

		String ipAddress = request.getIpAddress();

		Date now  = new Date();	
		logger.info("\n Release : " + "version 1.0.0");	
		logger.info(
				"\nLEAN-REQUEST > Service : {} " 
				+ "{\" RequestHeader\" : { "
				+ "\"Ip Address\" : \"{}\",  "
				+ "\"Date\" : \"{}\",  "
				+ "\"SessionId\" : \"{}\", "
				+ "\"RequestId\" : \"{}\", "
				+ "\"Login\" : \"{}\" },  "
				+ "\"RequestBody\" :   {}  } ",
				serviceName, ipAddress, now, sessionId, requestId, request.getLogin(), getJson(request, false),
				"UTF-8");
	 
		if ( (password != null) && (! password.equals(""))) {
			request.setPassword(password);
		}
		if ( (digestedPassword != null) && (! digestedPassword.equals(""))) {
			request.setDigestedPassword(digestedPassword);
		}
		if ( (newPassword != null) && (! newPassword.equals(""))) {
			request.setNewPassword(newPassword);
		}
		if ( (token != null) && (! token.equals(""))) {
			request.setToken(token);
		}
		if ( (otp != null) && (! otp.equals(""))) {
			request.setOtp(otp);
		}
		
		//-----------------------------------------------------------------------------------
//		String activeRecorder = parameterManager.getSaphirParameterIfAny("activeRecorder");
//		if (activeRecorder == null) {
//			activeRecorder = "N";
//		}
//		if ("Y".equals(activeRecorder)) {
//			testCaseDao.insert(serviceName, now, requestId, request.getLogin(), getJson(request, false));	
//		}
		//-----------------------------------------------------------------------------------

	}
	
	public void logResponsePayload(
			String serviceName,
			String sessionId,
			String requestId,
			BaseResponse response){

		Date now  = new Date();
		
		if ( (response.getResponse().getInternalReason() != null)) {
			response.getResponse().setInternalReason(null);
		}
		
		logger.info(
			 "\nLEAN-RESPONSE > Service : {} " 		
		   + "{\" ResponseHeader\" : { "
			+ "\"Date\" : \"{}\",  "
			+ "\"SessionId\" : \"{}\", "
			+ "\"RequestId\" : \"{}\", "
			+ "\"Response\" : \"{}\" },  "
			+ "\"ResponseBody\" :   {}  } ",
			serviceName, now, sessionId, requestId, response.getResponse().getCode().name(), getJson(response, false),
			"UTF-8");
		
		
		//-----------------------------------------------------------------------------------
//		String activeRecorder = parameterManager.getSaphirParameterIfAny("activeRecorder");
//		if (activeRecorder == null) {
//			activeRecorder = "N";
//		}
//		
//		if ("Y".equals(activeRecorder)) {
//			testCaseDao.complete(serviceName, now, requestId, response.getResponse().getCode().name(), getJson(response, false));	
//		}
		//-----------------------------------------------------------------------------------
		
	}
	

	
	protected String getJson(
			Object payloadToLog,
			boolean beautify) {

		String json = "";
		try {

			ObjectWriter ow = null;
			if (beautify) {
				ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			} else {
				ow = new ObjectMapper().writer();
			}

			json =  ow.writeValueAsString(payloadToLog);
		
			
		} catch (JsonProcessingException e1) {

			logger.info(
					"===========================  START JsonProcessingException ERROR  ================================================");
			e1.printStackTrace();
			logger.info(
					"==========================    END JsonProcessingException ERROR   ================================================");
			logger.info("");
			logger.info("");
		}
		return json;
	}


	
	protected Logger logger = LoggerFactory.getLogger(getClass());



	public void logObjectPayload(			
			String sessionId,
			String requestId, 
			Object object) {
		Date now  =new Date();

		logger.info(
				 "\nLEAN-INTERNAL-RESPONSE > " 	
					+ "{\" Header\" : { "
					+ "\"Date\" : \"{}\",  "
					+ "\"SessionId\" : \"{}\", "
					+ "\"RequestId\" : \"{}\", "
					+ "\"Body\" :   {}  } ", 
					now, sessionId, requestId, getJson(object, false),
					"UTF-8");		
	}
	
	public void logObjectPayload(			
			String sessionId,
			String requestId,
			String uri, 
			Object object) {

		Date now  =new Date();

		logger.info(
				 "\nLEAN-INTERNAL-REQUEST > " 
				    + "{\" Header\" : { "
					+ "\"Date\" : \"{}\",  "
					+ "\"SessionId\" : \"{}\", "
					+ "\"RequestId\" : \"{}\", "
					+ "\"Uri\" : \"{}\", "
					+ "\"Body\" :   {}  } ", 

				now, sessionId, requestId, uri, getJson(object, false),
				"UTF-8");
		
	}
}
