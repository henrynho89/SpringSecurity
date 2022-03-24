package org.diembo.base.utils.impl;

import javax.servlet.http.HttpServletRequest;

import org.diembo.base.msg.BaseRequest;


public class HttpUtils {
	
	public static void setIpAddress(BaseRequest request, HttpServletRequest httpServletRequest) {
	    request.setIpAddress(httpServletRequest.getHeader("X-FORWARDED-FOR") != null ? httpServletRequest.getHeader("X-FORWARDED-FOR") : httpServletRequest.getRemoteAddr());
		
	}

}
