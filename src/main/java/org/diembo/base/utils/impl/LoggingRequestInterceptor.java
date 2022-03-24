package org.diembo.base.utils.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;


public class LoggingRequestInterceptor implements ClientHttpRequestInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoggingRequestInterceptor.class);


    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {

        traceRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        traceResponse(response);
        return response;
    }

    private void traceRequest(HttpRequest request, byte[] body) throws IOException {
     	
		logger.info(	
			  "\nLEAN OUTBOUND-REQUEST ->" 
				+ "{\" RequestHeader\" : { "
				+ "\"Uri\" : \"{}\",  "
				+ "\"Method\" : \"{}\", "
				+ "\"Headers\" : \"{}\", "
				+ "\"RequestBody\" : {} }} ", 
				request.getURI(), request.getMethod(),request.getHeaders(), new String(body, "UTF-8"));
			

    }

    private void traceResponse(ClientHttpResponse response) throws IOException {

	       StringBuilder inputStringBuilder = new StringBuilder();
	       BufferedReader bufferedReader = null;
 	    	try {
    	        bufferedReader = new BufferedReader(new InputStreamReader(response.getBody(), "UTF-8"));
 	    	} catch (Exception e) {
 	    		return;
 	    	}
	        String line = bufferedReader.readLine();
	        while (line != null) {
	            inputStringBuilder.append(line);
	            inputStringBuilder.append('\n');
	            line = bufferedReader.readLine();
	        }
	        
	        String body = inputStringBuilder.toString();
			logger.info(
					  "\nLEAN OUTBOUND-RESPONSE ->" 
					    + "{\" ResponseHeader\" : { "
						+ "\"StatusCode\" : \"{}\",  "
						+ "\"StatusText\" : \"{}\", "
						+ "\"Headers\" : \"{}\", "
						+ "\"ResponseBody\" :   {}  }} ",
						response.getRawStatusCode(), response.getStatusText(), response.getHeaders(), body);
  
     }

}
