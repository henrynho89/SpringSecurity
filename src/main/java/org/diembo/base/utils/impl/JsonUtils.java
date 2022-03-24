package org.diembo.base.utils.impl;

import java.io.UnsupportedEncodingException;

import org.diembo.base.enums.ErrorCode;
import org.diembo.base.utils.BeanUtils;
import org.diembo.base.utils.ByteUtils;
import org.diembo.base.utils.SaphirException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	//----------------------------------------------------------------------------------------------------------------
		
	public static String toJsonString (Object object) {
		return encodeAsString(object, false);
	}

	//----------------------------------------------------------------------------------------------------------------
		
	public static byte[] toJsonByteArray(Object object) {
		return encodeAsByteArray(object, false);
	}
	
	//----------------------------------------------------------------------------------------------------------------
		
	public static byte[] encode(Object object) {
		return encodeAsByteArray(object, false);
	}

	//----------------------------------------------------------------------------------------------------------------

	public static byte[] encodeAsByteArray(Object object, boolean wrapInClassName) {
		return ByteUtils.stringToByteArray(encodeAsString(object, wrapInClassName));
	}

	//----------------------------------------------------------------------------------------------------------------

	public static String encodeAsString(Object object, boolean wrapInClassName) {
		if ( object == null ) {
			return null;
		}

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(Include.NON_NULL);

        String result = null;
		try {
			result = mapper.writeValueAsString(object);
		} catch (Exception e) {
			throw new SaphirException(ErrorCode.errUnexpectedError, e.getMessage());
		}
		
		if ( wrapInClassName ) {
        	//mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
			result = object.getClass().getName()+ ":" +result;
        }

		return result;
	}
	
	//----------------------------------------------------------------------------------------------------------------

	public static String encodeAsStringWithJaxbAnno(Object object) {
		if ( object == null ) {
			return null;
		}

        ObjectMapper mapper = new ObjectMapper();
        
        String result = null;
		try {
			result = mapper.writeValueAsString(object);
		} catch (Exception e) {
			throw new SaphirException(ErrorCode.errUnexpectedError, e.getMessage());
		}

		return result;
	}
	
	//----------------------------------------------------------------------------------------------------------------

	public static <T> T decode(String json, Class<T> type) {
		if ( json == null ) {
			return null;
		}
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		
        T result = null;
		try {
			result = mapper.readValue(json, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	
	//----------------------------------------------------------------------------------------------------------------

	public static <T> T decodeWithJaxbAnno(String json, Class<T> type) {
		if ( json == null ) {
			return null;
		}
		
        ObjectMapper mapper = new ObjectMapper();
		
        T result = null;
		try {
			result = mapper.readValue(json, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return result;
	}

	//----------------------------------------------------------------------------------------------------------------

	public static Object decode(String json) {
		int sepPos = json.indexOf(':');
		if ( sepPos == -1 ) {
			throw new SaphirException(
					ErrorCode.json_utils__type_name_not_found,
					"Type name not found in [" + json + "]! Type name should be at begining followed by ':'.");
		}

		String typeName = json.substring(0, sepPos);
		json = json.substring(sepPos + 1);
		Class<?> type = BeanUtils.forName(typeName);

		return decode(json, type);
	}

	//----------------------------------------------------------------------------------------------------------------

	public static <T> T decode(byte[] bytes, Class<T> type) {
		String json = null;
		try {
			json = new String(bytes, "UTF8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return decode(json, type);
	}

	public static Object decode(byte[] bytes) {
		String json = null;
		try {
			json = new String(bytes, "UTF8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		return decode(json);
	}

	//----------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------------------------------------
			
}
