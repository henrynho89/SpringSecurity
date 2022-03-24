package org.diembo.base.utils.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.SSLContext;


import org.diembo.base.enums.ErrorCode;
import org.diembo.base.utils.SaphirException;
import org.diembo.base.utils.SaphirHttpException;
import org.diembo.base.utils.StringUtils;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Security.TrustStrategy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

@Component
public class RestUtils {
	
	

	public <T, T2> T submitRequest(
			String		accessToken, 
			String 		xId, 
			String 		xTime, 
			String 		xSignature,
			String		cacheControl,
			int 		method,
			String 		serverUrl,
			T2 			bodyData,
			Class<T> 	clazz) {
		return submitRequest(null, null, null,accessToken, xId, xTime, xSignature, cacheControl,method, serverUrl, bodyData, clazz, MediaType.APPLICATION_JSON, false, null, null);
	}
	
	
	public <T, T2> T submitRequest(
			String		login,
			String 		password,
			String 		xId, 
			String 		xTime, 
			String 		xSignature,
			String		cacheControl,
			int 		method,
			String 		serverUrl,
			T2 			bodyData,
			Class<T> 	clazz) {
		return submitRequest(login, password, null, null, xId, xTime, xSignature, cacheControl,method, serverUrl, bodyData, clazz, MediaType.APPLICATION_JSON, false, null, null);
	}


	public <T, T2> T submitRequest(
			String		login,
			String 		password,
			int 		method,
			String 		serverUrl,
			Class<T> 	clazz) {
		return submitRequest(login, password, null, method, serverUrl, null, clazz, MediaType.APPLICATION_JSON, false, null, null);
	}
	
	public <T, T2> T submitRequest(
			int 		method,
			String 		serverUrl,
			T2 			bodyData,
			Class<T> 	clazz) {
		return submitRequest(null, null, null, method, serverUrl, bodyData, clazz, MediaType.APPLICATION_JSON, false, null, null);
	}
	
	public <T, T2> T submitRequest(
			String		login,
			String 		password,
			String		key,
			int 		method,
			String 		serverUrl,
			T2 			bodyData,
			Class<T> 	clazz) {
		return submitRequest(login, password, key, method, serverUrl, bodyData, clazz, MediaType.APPLICATION_JSON, false, null, null);
	}
	
	public <T, T2> T submitRequest(
			int 		method,
			String 		serverUrl,
			T2 			bodyData,
			Class<T> 	clazz,
			boolean 	ssl) {
		return submitRequest(null, null, null, method, serverUrl, bodyData, clazz, MediaType.APPLICATION_JSON, ssl, null, null);
	}
	
	public <T, T2> T submitRequest(
			int 		method,
			String 		serverUrl,
			T2 			bodyData,
			Class<T> 	clazz,
			MediaType 	mediaType) {
		return submitRequest(null, null, null, method, serverUrl, bodyData, clazz, mediaType, false, null, null);
	}
	
	public <T, T2> T submitRequest(
			int 		method,
			String 		serverUrl,
			T2 			bodyData,
			Class<T> 	clazz,
			String keyStoreFileName, 
			String keyStorePassword) {
		return submitRequest(null, null, null, method, serverUrl, bodyData, clazz, MediaType.APPLICATION_JSON, true, keyStoreFileName, keyStorePassword);
	}
	

	protected <T, T2> T submitRequest(
			String		login,
			String 		password,
			String		key,
			int 		method,
			String 		serverUrl,
			T2 			bodyData,
			Class<T> 	clazz,
			MediaType 	mediaType,
			boolean ssl,
			String keyStoreFileName, 
			String keyStorePassword) {
		return submitRequest(login,password,key,null,null,null,null,null,method,serverUrl,bodyData,clazz,mediaType,ssl,keyStoreFileName,keyStorePassword);
		
	}
	
	
	protected <T, T2> T submitRequest(
			String		login,
			String 		password,
			String		key,
			String      token, 
			String 		xId, 
			String 		xTime, 
			String 		xSignature,
			String		cacheControl,
			int 		method,
			String 		serverUrl,
			T2 			bodyData,
			Class<T> 	clazz,
			MediaType 	mediaType,
			boolean     ssl,
			String      keyStoreFileName, 
			String      keyStorePassword) {
		RestTemplate restTemplate =  getRestTemplate(login, password, ssl, keyStoreFileName, keyStorePassword);
		
		try {

			HttpHeaders headers = buildHeaders(mediaType, key, token, xId, xTime, xSignature,cacheControl);

			HttpEntity<T2> requestEntity = new HttpEntity <T2> (bodyData, headers);

			T result;

			ResponseEntity <T> response = null;
			switch (method) {

			case GET:
				response = restTemplate.exchange(serverUrl , HttpMethod.GET, requestEntity, clazz);
				result  = response.getBody();
				break;

			case POST:
				result  = restTemplate.postForObject(serverUrl , requestEntity, clazz);
				break;

			case PUT:
				response = restTemplate.exchange(serverUrl , HttpMethod.PUT, requestEntity, clazz);
				result  = response.getBody();
				break;

			case DELETE:
				response = restTemplate.exchange(serverUrl , HttpMethod.DELETE, requestEntity, clazz);
				result  = response.getBody();
				break;

			default:
				result  = restTemplate.postForObject(serverUrl , requestEntity, clazz);
				break;
			}


			if (response != null) {
				int rawStatusCode = response.getStatusCodeValue();
				if ( rawStatusCode != 200) {
					throw new SaphirHttpException(rawStatusCode, "Http Error");
				}
			}


			return result;

		} catch(org.springframework.web.client.HttpClientErrorException e) {
			int status = e.getRawStatusCode();

			switch (status) {

			case 400:
				throw new SaphirException(ErrorCode.backend_error_bad_request,  e.getMessage());

			default:
				throw  new SaphirHttpException(e.getRawStatusCode(), e.getMessage());

			}


		} catch(org.springframework.web.client.HttpServerErrorException e) {

			throw new SaphirException(ErrorCode.backend_error,  e.getMessage());


		} catch (org.springframework.web.client.ResourceAccessException e) {

			throw new SaphirException(ErrorCode.backend_error,  e.getMessage());

		} catch (SaphirHttpException e) {

			throw e;

		} catch (Exception e) {

			throw new SaphirException(ErrorCode.backend_error, e.getMessage());

		}
	}


	private HttpHeaders buildHeaders(MediaType mediaType, String key, String token, String xId, String xTime, String xSignature, String cacheControl) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		
		if (! StringUtils.isBlank(key)) {
			headers.set("x-Gateway-APIKey", key);//3ae52a66-5e26-4a31-8453-6d170d6b3b13			
		}		
		
		if (! StringUtils.isBlank(token)) {
			headers.set("Authorization", "Bearer "+token);		
		}
		if (! StringUtils.isBlank(xId)) {
			headers.set("X-Id", xId);		
		}
		if (! StringUtils.isBlank(xId)) {
			headers.set("X-Time", xTime);		
		}
		if (! StringUtils.isBlank(xSignature)) {
			headers.set("X-Signature", xSignature);		
		}
		if (! StringUtils.isBlank(xSignature)) {
			headers.set("Cache-Control", cacheControl);		
		}
		
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(mediaType);
		headers.setAccept(acceptableMediaTypes);

		headers.put("Connection", Collections.singletonList("Keep-Alive"));

		return headers;
	}


	 public RestTemplate getRestTemplate(String login, String password, boolean ssl, String keyStoreFileName, String keyStorePassword) {

		 String connectionTimeout 	= "" ;
		 String readTimeout 		= "";

		 if (! ssl) {
			 
			 SimpleClientHttpRequestFactory simpleClientHttpRequestFactory  = new SimpleClientHttpRequestFactory();
			 // No SSL
			 if ((connectionTimeout != null) && (readTimeout != null)){
				 simpleClientHttpRequestFactory.setReadTimeout(Integer.parseInt(readTimeout));
				 simpleClientHttpRequestFactory.setConnectTimeout(Integer.parseInt(connectionTimeout));	 
			 }

			RestTemplate restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(simpleClientHttpRequestFactory));
			List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
			interceptors.add(new LoggingRequestInterceptor());

			if (! StringUtils.isBlank(login)) {
				interceptors.add(new BasicAuthorizationInterceptor(login, password));
				restTemplate.setInterceptors(interceptors);				
			}

			restTemplate.setInterceptors(interceptors);
			   
			StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
			stringHttpMessageConverter.setWriteAcceptCharset(false);
			restTemplate.getMessageConverters().add(0, stringHttpMessageConverter);
			return restTemplate;
		} 


		 // SSL
//		 if (keyStoreFileName == null) {
//			 // SSL and ignore certificat
////			 TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
//	        TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
//	           @Override 
//		       public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
//		            return true;
//		        }
//		    };
//    
//			 SSLContext sslContext = null;
//			try {
//				sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
//			} catch (Exception e) {
//				e.printStackTrace();
//	    		throw new SaphirException(ErrorCode.errUnexpectedError, e.getMessage());
//			}
//
//			 SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
//			
//			 CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
//			 
//			 HttpComponentsClientHttpRequestFactory requestFactory 	= new HttpComponentsClientHttpRequestFactory();
//			 if ((connectionTimeout != null) && (readTimeout != null)){
//				 requestFactory.setReadTimeout(Integer.parseInt(readTimeout));
//				 requestFactory.setConnectTimeout(Integer.parseInt(connectionTimeout));	 
//			 }
//			 
//			requestFactory.setHttpClient(httpClient);
//			return new RestTemplate(requestFactory);
//		 } 


		 // SSL with certificat use
	   	try {
			char[] keyStorePassword2 = keyStorePassword.toCharArray();
	    	
	    	//KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
		    KeyStore keyStore = KeyStore.getInstance("PKCS12");
		    File key = ResourceUtils.getFile(keyStoreFileName);
		    InputStream in = new FileInputStream(key);
		    keyStore.load(in, keyStorePassword2);
		   	 
//	        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(
//	                new SSLContextBuilder()
//	                .loadTrustMaterial(keyStore, new TrustSelfSignedStrategy())
//	                .loadKeyMaterial(keyStore,keyStorePassword2).build());
//	        CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(socketFactory).build();
	 
	        
//	        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
//			 if ((connectionTimeout != null) && (readTimeout != null)){
//				 requestFactory.setReadTimeout(Integer.parseInt(readTimeout));
//				 requestFactory.setConnectTimeout(Integer.parseInt(connectionTimeout));	 
//			 }
			 
//	        return new RestTemplate(new BufferingClientHttpRequestFactory(requestFactory));
		    return null;//TODO
	    } catch (Exception e) {
    		e.printStackTrace();
    		throw new SaphirException(ErrorCode.errUnexpectedError, e.getMessage());
    	}
	}

	 
	public static final int  GET 	 = 0;
	public static final int  POST 	 = 1;
	public static final int  PUT 	 = 2;
	public static final int  DELETE = 3;
}
