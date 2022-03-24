package org.diembo.base.utils;

import org.diembo.base.msg.BaseRequest;
import org.diembo.base.msg.BaseResponse;

public interface PayloadLogger {
	void logRequestPayload(
			String serviceName,
			String sessionId,
			String requestId,
			String uri, 
			BaseRequest request);
	
	void logResponsePayload(
			String serviceName,
			String sessionId,
			String requestId,
			BaseResponse response);
	
	
	void logObjectPayload(
			String sessionId,
			String requestId,
			Object request);
	
	void logObjectPayload(
			String sessionId,
			String requestId,
			String uri,
			Object request);
}