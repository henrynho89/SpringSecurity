package org.diembo.base.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BeanUtils {
	
	
	public static <T> T getEmptyInstance (Class<T> clazz ) {
		
	//	Class<?> clazz = c.getClass();
		T instance = null;
		try {
			instance = clazz.newInstance();
			Field[] fields = lookupAllRWFields(clazz);
			   for (Field field : fields) {
				   field.setAccessible(true);
				   field.set(instance, null);
			   }
		} catch (Exception e) {

		} 
		return instance;
	}
	
	public static Field[] lookupAllFields ( Class<?> clazz ) {
		List<Field> result = new ArrayList<Field>();

		while ( true ) {
			result.addAll( Arrays.asList(clazz.getDeclaredFields()) ) ;
			clazz = clazz.getSuperclass() ;
			if ( clazz == null )
				break ;
		}

		return result.toArray(EMPTY_FIELD_ARRAY);
	}

	public static Field[] lookupAllRWFields ( Class<?> clazz ) {
		List<Field> result = new ArrayList<Field>();

		while ( true ) {
			for ( Field field : clazz.getDeclaredFields() ) {
				if ( hasGetter(clazz, field.getName()) && hasSetter(clazz, field.getName(), field.getType()) ) {
					result.add( field ) ;
				}
			}
			clazz = clazz.getSuperclass() ;
			if ( clazz == null )
				break ;
		}

		return result.toArray(EMPTY_FIELD_ARRAY);
	}

	public static Field lookupRWField ( Class<?> clazz , String fieldName) {
		ObjectUtils.assertNotNull("Class", clazz);
		ObjectUtils.assertNotNull("Field Name", fieldName);

		Field result = null;

		Class<?> currentClass = clazz ;
		while ( true ) {
			for ( Field field : currentClass.getDeclaredFields() ) {
				if ( fieldName.equals(field.getName()) && hasGetter(currentClass, field.getName()) && hasSetter(currentClass, field.getName(), field.getType()) ) {
					result = field ;
					break;
				}
			}

			// are we done?
			if ( result != null ) {
				// yes, we are; stop here then.
				break ;
			}

			currentClass = currentClass.getSuperclass() ;
			if ( currentClass == null )
				break ;
		}

		// have we found the field?
		if ( result == null ) {
			// no, we didn't; so, fire an error
			throw new RuntimeException("" +
				"The field '" + fieldName + "' is missing in " +
				"the class '" + clazz + "'!");
		}

		return result;
	}

	public static Class<?> forName ( String entityName ) {
		Class<?> clazz = null ;
		try {
			clazz = Class.forName(entityName);
		} catch (Throwable e) {
			throw new RuntimeException("Error while loading class '" + entityName
					+ "' using the class loader of '" + BeanUtils.class
					+ "'. See nested exceptions for more details.", e);
		}

		return clazz ;
	}

	public static Class<?> forName ( String entityName , ClassLoader classLoader ) {
		Class<?> clazz = null ;
		try {
			clazz = Class.forName(entityName, true , classLoader);
		} catch (Throwable e) {
			throw new RuntimeException("Error while loading class '" + entityName
					+ "' using the given class loader '" + classLoader
					+ "'. See nested exceptions for more details.", e);
		}

		return clazz ;
	}

	public static Object newInstance ( String entityName ) {
		return newInstance ( forName(entityName) ) ;
	}

	public static Object newInstance ( String entityName , ClassLoader classLoader ) {
		return newInstance ( forName(entityName, classLoader) ) ;
	}

	public static Object newInstance ( Class<?> clazz ) {
		Object object;
		try {
			object = clazz.newInstance();
		} catch (Throwable e) {
			throw new RuntimeException("Error while instantiating '"
					+ (clazz == null ? null : clazz.getName())
					+ "'. See nested exceptions for more details.", e);
		}

		return object ;
	}

	/** Whether the <em>object</em> has a field named <em>field</em>. */
	public static boolean hasGetterAndSetter ( Object object , String field , Class<?> fieldClazz ) {
		return hasGetterAndSetter ( object.getClass() , field , fieldClazz ) ;
	}

	/** Whether the <em>object</em> has a field named <em>field</em>. */
	public static boolean hasGetterAndSetter ( Class<?> clazz, String field , Class<?> fieldClazz ) {
		return hasGetter (clazz, field ) && hasSetter ( clazz , field , fieldClazz ) ;
	}

	/** Whether the <em>object</em> has a getter for the given <em>field</em>. */
	public static boolean hasGetter ( Object object , String field ) {
		return hasGetter ( object.getClass(), field ) ;
	}

	/** Whether the <em>object</em> has a getter for the given <em>field</em>. */
	public static boolean hasGetter ( Class<?> clazz , String field ) {
		boolean result = true  ;

		// getter name derived from the field name
		String name = Character.toUpperCase(field.charAt(0)) + field.substring(1);

		// get the getter
		try {
			try {
				clazz.getMethod ( "get" + name, (Class<?>[])null);
			}
			catch ( NoSuchMethodException e ) {
				clazz.getMethod ( "is" + name, (Class<?>[])null);
			}
		} catch (SecurityException e) {
			result = false ;
		} catch (NoSuchMethodException e) {
			result = false ;
		}

		return result ;
	}

	/** Whether the <em>object</em> has a setter for the given <em>field</em>. */
	public static boolean hasSetter ( Object object , String field , Class<?> clazz ) {
		boolean result = true ;

		// setter name derived from the field name
		String name = Character.toUpperCase(field.charAt(0)) + field.substring(1);

		// get the setter
		try {
			Class<?>[] params = {clazz} ;
			object.getClass().getMethod("set" + name, params);
		} catch (SecurityException e) {
			result = false ;
		} catch (NoSuchMethodException e) {
			result = false ;
		}

		return result ;
	}

	/** Whether the <em>object</em> has a setter for the given <em>field</em>. */
	public static boolean hasSetter ( Class<?> clazz , String field , Class<?> fieldClazz ) {
		boolean result = true ;

		// setter name derived from the field name
		String name = Character.toUpperCase(field.charAt(0)) + field.substring(1);

		// get the setter
		try {
			Class<?>[] params = {fieldClazz} ;
			clazz.getMethod("set" + name, params);
		} catch (SecurityException e) {
			result = false ;
		} catch (NoSuchMethodException e) {
			result = false ;
		}

		return result ;
	}

	/**
	 * Looks for the method having the given name and arguments and return it.
	 * Null will be returned in case the method is not found.
	 */
	public static Method hasMethod ( Class<?> clazz , String name , Class<?>[] args ) {
		return lookupMethodIfAny(clazz, name, args) ;
	}

	/**
	 * Looks for the method having the given name and arguments and return it.
	 * Null will be returned in case the method is not found.
	 */
	public static Method lookupMethod ( Class<?> clazz , String name , Class<?>[] args ) {
		Method result = lookupMethodIfAny(clazz, name, args) ;

		if ( result == null ) {
			throw new RuntimeException("No method '" + name + "("
					+ Arrays.toString(args) + ")' exist in '" + clazz
					+ "'. Existing methods are '"
					+ Arrays.toString(clazz.getMethods()) + "'.");
		}

		return result ;
	}

	/**
	 * Looks for the method having the given name and arguments and return it.
	 * Null will be returned in case the method is not found.
	 */
	public static Method lookupMethodIfAny ( Class<?> clazz , String name , Class<?>[] params ) {
		Method result = null ;
		for ( Method method : clazz.getMethods() ) {
			// is the name of this method matches the name of the method we are
			// looking for?
			if ( ! method.getName().equals(name) )
				continue ;

			// is the number of parameters of this method matches the number of
			// parameters of the method we are looking for?
			if ( method.getParameterTypes().length != params.length )
				continue;

			// let's try to find a method whose parameters can be assigned using
			// our parameters
			boolean found = true ;
			for ( int index = 0; index < params.length; index ++ ) {
				if ( ! method.getParameterTypes()[index].isAssignableFrom(params[index])) {
					found = false ;
					break ;
				}
			}

			// is this our method?
			if ( found ) {
				result = method ;
				break ;
			}
		}

		return result ;
	}

	public static Method hasMethod ( String className , String name , Class<?>[] args ) {
		Class<?> clazz = null ;
		try {
			clazz = Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException ( e ) ;
		}

		return hasMethod ( clazz , name , args )  ;
	}

	/**
	 * Looks for the method having the given name and arguments and return it.
	 * Null will be returned in case the method is not found.
	 */
	public static Method hasImmediateMethod ( Class<?> clazz , String name , Class<?>[] args ) {
		Method result = null ;
		for ( Method method : clazz.getDeclaredMethods() ) {
			if ( method.getName().equals(name) && Arrays.equals(method.getParameterTypes(), args) ) {
				result = method ;
				break ;
			}
		}

		return result ;
	}

	public static Object invoke ( String className , String method , Object[] args ) {
		Class<?>[] classes = new Class<?>[args.length] ;
		for ( int index = 0 ; index < args.length ; index ++ )
			classes[index] = args[index].getClass() ;
		return invoke ( className , hasMethod ( className , method , classes ) , args ) ;
	}

	public static Object invoke ( String className , Method method , Object[] args ) {
		Object object = null ;
		try {
			object = Class.forName(className).newInstance();
		} catch (Throwable e) {
			throw new RuntimeException ( e ) ;
		}

		return invoke ( object , method , args ) ;
	}

	public static Object invoke ( Class<?> clazz, Method method , Object[] args ) {
		Object object = null ;
		try {
			object = clazz.newInstance();
		} catch (Throwable e) {
			throw new RuntimeException ( e ) ;
		}

		return invoke ( object , method , args ) ;
	}

	public static Object invoke ( Object object , Method method , Object[] args ) {
		Object result = null ;

		try {
			result = method.invoke(object, (Object[])args);
		} catch (Throwable e) {
			throw new RuntimeException ( "Error while invoking method '" + method + "' for '" + (object == null ? null : object.getClass()) + "'." , e ) ;
		}

		return result ;
	}

	/**
	 * Calls the getter of the given <em>object</em> associated with the given
	 * <em>field</em>.
	 */
	@SuppressWarnings("rawtypes")
	public static Object callGetter ( Object object , String field ) {
		
		int index	=  field.indexOf(".");
		
		if ( ( index != -1 ) && !field.equals(""))
		{
			String 	name 		= field.substring(0, index);
			Object 	newObject	= callGetter (object, name);  
			if ( newObject == null )  
				return null; 
			else if (!StringUtils.isBlank(field.substring(index+1)))
				return callGetter (newObject, field.substring(index+1));
			else 
				return 	newObject; 
		}
		else 
		{
			if ( object instanceof Map<?,?>) {
				return ((Map)object).get(field) ;
			}
			else {
				// getter name derived from the field name
				String name = Character.toUpperCase(field.charAt(0)) + field.substring(1);
			
				// get the getter
				Method getter = null ;
				try {
					try {
						getter = object.getClass().getMethod ( "get" + name, (Class<?>[])null);
					}
					catch ( NoSuchMethodException e ) {
						getter = object.getClass().getMethod ( "is" + name, (Class<?>[])null);
					}
				} catch (Throwable e) {
					throw new RuntimeException ( "Error while looking up getter '" + name + "' for '" + (object == null ? null : object.getClass()) + "'." , e ) ;
				}
		
				// call the getter
				Object result = null;
				try {
					result = getter.invoke(object, (Object[])null);
				} catch (Throwable e) {
					throw new RuntimeException ( "Error while invoking getter '" + name + "' for '" + object.getClass() + "'." , e ) ;
				}
		
				return result ;
			}
		}	
	}


	/**
	 * Calls the setter of the given <em>object</em> associated with the
	 * <em>field</em>
	 */
	public static void callSetter ( Object object , String fieldName , Class<?> fieldClass , Object fieldValue ) {
		if ( object == null ) {
			throw new IllegalArgumentException("The supplied object is null.");
		}

		// in case the field name has '.', this means that we have to get the
		// parent of the last field before calling the setter.
		int index = fieldName.lastIndexOf('.');
		if ( index != -1 ) {
			object = callGetter(object, fieldName.substring(0, index));
			fieldName = fieldName.substring(index+1);
		}

		// the class of the value being set
		fieldClass = fieldValue != null ? fieldValue.getClass() : fieldClass ;

		// setter name derived from the field name
		String setterName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);

		// get the setter
		Method setter = lookupMethod(object.getClass(), setterName, new Class<?>[] {fieldClass}) ;

		// call the setter
		try {
			Object[] args = {fieldValue};
			setter.invoke(object, args );
		} catch (Throwable e) {
			throw new RuntimeException("Error while invoking setter '" + setter
					+ "' for '" + object + "'.", e);
		}
	}

	public static void callSetterWithImplicitConversion ( Object object , String fieldName , Class<?> fieldClass , Object fieldValue ) {
		if ( object == null ) {
			throw new IllegalArgumentException("The supplied object is null.");
		}

		// the class of the value being set
		fieldClass = fieldClass == null && fieldValue != null ? fieldValue.getClass() : fieldClass ;

		// convert the field value, if required
		if (fieldValue != null && fieldValue instanceof String
				&& fieldClass != null
				&& !String.class.isAssignableFrom(fieldClass)) {
			fieldValue = convert(fieldClass, (String) fieldValue);
		}

		// setter name derived from the field name
		String setterName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);

		// get the setter
		Method setter = lookupMethod(object.getClass(), setterName, new Class<?>[] {fieldClass}) ;

		// call the setter
		try {
			Object[] args = {fieldValue};
			setter.invoke(object, args );
		} catch (Throwable e) {
			throw new RuntimeException("Error while invoking setter '" + setter
					+ "' for '" + object + "'.", e);
		}
	}

	public static void callSetterWithImplicitConversion ( Object object , String fieldName , Object fieldValue ) {
		if ( object == null ) {
			throw new IllegalArgumentException("The supplied object is null.");
		}

		// setter name derived from the field name
		String setterName = "set" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);

		Class<?> fieldClass = null ;
		Method setter = null ;
		for ( Method method : object.getClass().getMethods() ) {
			if ( setterName.equals(method.getName()) ) {
				if ( method.getParameterTypes().length != 1 ) {
					logger.warn("Found a setter with unexpected number of parameters '"
							+ method.getParameterTypes().length + "'.");
					continue ;
				}

				fieldClass = method.getParameterTypes()[0];
				setter = method ;
				break ;
			}
		}

		if ( setter == null ) {
			throw new IllegalArgumentException("Setter '" + setterName
					+ "' unknown. Know methods are: '"
					+ object.getClass().getMethods() + "'.");
		}

		// convert the field value, if required
		if (fieldValue != null && fieldValue instanceof String
				&& fieldClass != null
				&& !String.class.isAssignableFrom(fieldClass)) {
			fieldValue = convert(fieldClass, (String) fieldValue);
		}

		// call the setter
		try {
			Object[] args = {fieldValue};
			setter.invoke(object, args );
		} catch (Throwable e) {
			throw new RuntimeException("Error while invoking setter '" + setter
					+ "' for '" + object + "'.", e);
		}
	}

	/**
	 * Calls the setter of the given <em>object</em> associated with the
	 * <em>field</em>
	 */
	public static void callSetter ( Object object , String fieldName , Object fieldValue ) {
		if ( fieldValue == null ) {
			throw new IllegalArgumentException("The value of '" + fieldName + "' is null!!!");
		}
		callSetter ( object , fieldName , fieldValue.getClass(), fieldValue ) ;
	}
	
	public static Class<?> getFieldType ( Class<?> clazz, String name) {
		logger.debug("Calling BeanUtil.getFieldType(" + clazz + ", " + name + ")" );
		Class<?> type = null ;

		if ( clazz != null && name != null ) {
			int index = name.indexOf('.');
			if ( index != -1 ) {
				Class<?> subType = getFieldType ( clazz , name.substring(0, index) ) ;
				type = getFieldType ( subType , name.substring(index+1));
			}
			else {
				String getterName = "get" + Character.toUpperCase( name.charAt(0) ) + name.substring ( 1 ) ;
				try {
					type = clazz.getMethod(getterName, (Class<?>[])null).getReturnType() ;
				} catch (SecurityException e) {
					throw new RuntimeException ( e ) ;
				} catch (NoSuchMethodException e) {
					getterName = "is" + Character.toUpperCase( name.charAt(0) ) + name.substring ( 1 ) ;
					try {
						type = clazz.getMethod(getterName, (Class<?>[])null).getReturnType() ;
					} catch (Throwable e1) {
						throw new RuntimeException ( "Error while looking up getter '" + name + "' for '" + clazz + "'." , e1 ) ;
					}
				}
			}
		}

		logger.debug("Leaving BeanUtil.getFieldType(" + type  + ")" );
		return type ;
	}

	public static <T> T lookupStaticField ( String fieldAbsoluteName , Class<T> type ) {
		String clazzName = fieldAbsoluteName.substring(0, fieldAbsoluteName.lastIndexOf('.')) ;
		String fieldName = fieldAbsoluteName.substring(fieldAbsoluteName.lastIndexOf('.') + 1) ;

		Object field = null ;
		try {
			field = Class.forName(clazzName).getField(fieldName).get(null) ;
		} catch (Throwable e) {
			throw new RuntimeException ( e ) ;
		}

		return type.cast(field) ;
	}

	public static String toJavaVariableName (Class<?> clazz) {
		return Character.toLowerCase(clazz.getSimpleName().charAt(0)) + clazz.getSimpleName().substring(1);
	}

	public static String toJavaVariableName (String clazzName) {
		if ( clazzName.lastIndexOf('$') != -1 )
			clazzName = clazzName.substring(clazzName.lastIndexOf('$') + 1);
		if ( clazzName.lastIndexOf('.') != -1 )
			clazzName = clazzName.substring(clazzName.lastIndexOf('.') + 1);
		return Character.toLowerCase(clazzName.charAt(0)) + clazzName.substring(1);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T cast(Object o){
	    return (T)o;
	}
	
	public static String [] loadParamsFields ( String params, String regexp )
	{
		// Params fields are not managed. Return Null
		if  (StringUtils.isBlank(params))
			return null; 
		
		String [] 	paramsFileds = params.split(regexp); 
		if (paramsFileds == null || paramsFileds.length == 0)
		{
			String errmsg 	= "The 'params' attribute is not correctly written '" + params + "'.";
			throw new IllegalArgumentException(errmsg); 
		}

		// trim extra spaces from key components
		String[] result = new String[paramsFileds.length];
		for ( int index = 0; index < paramsFileds.length ; index ++ ) {
			result[index] = paramsFileds[index].trim();
		}
			
		return result; 
	}

	public static ArrayList<Method> hasMethods( Object object , String methodName, String params  ){
		Method[] methods =  object.getClass().getMethods();
		String[] paramsFields = loadParamsFields ( params, "," );
		ArrayList<Method> overrideMethods = new ArrayList<Method>();
		for( int index = 0; index < methods.length ; index++  ){
			if( methods[index].getName().equals(methodName)  ){
				if ( paramsFields == null || ( paramsFields != null && paramsFields.length == methods[index].getParameterTypes (  ).length ) ){
					overrideMethods.add(methods[index]);
				}
			}
		}
		return overrideMethods;
	}

	public static Object convert ( Class<?> clazz , String value ) {
		Object result = null;
		if 		(  Integer.class.equals(clazz) || int.class.equals(clazz) ) {
			result = Integer.parseInt(value) ;
		}
		else if ( Long.class.equals(clazz) || long.class.equals(clazz) ) {
			result = Long.parseLong(value) ;
		}
		else if ( Float.class.equals(clazz) || float.class.equals(clazz) ) {
			result = Float.parseFloat(value) ;
		}
		else if ( Double.class.equals(clazz) || double.class.equals(clazz) ) {
			result = Double.parseDouble(value) ;
		}
		else if ( Boolean.class.equals(clazz) || boolean.class.equals(clazz) ) {
			result = Boolean.parseBoolean(value) ;
		}
		else if( Date.class.equals(clazz) ){
			DateUtils.toDate(value, "yyyy-MM-dd");
		}
		else{
			result = value;
		}
		return result;
	}

//	public static Object callMethod ( Object object , String methodName , String params, Map<String, Object> model ) {
//		ArrayList<Method>  overrideMethods = hasMethods ( object , methodName, params );
//		if ( overrideMethods == null || overrideMethods.size() <= 0 )
//			throw new NSException("method with name '" + methodName
//					+ "' not found in class name '"
//					+ object.getClass().getName() + "'. ");
//		
//		String[] paramsFields = loadParamsFields ( params, "," );
//		for( Method method: overrideMethods ){
//			Class<?>[]  formalParams = method.getParameterTypes (  );
//			ArrayList<Object> args = new ArrayList<Object>();
//			try{
//				if(  paramsFields!=null && paramsFields.length >0  ){
//					for ( int index = 0; index < paramsFields.length ; index ++ ) {
//						String[] parts = loadParamsFields ( paramsFields[index], "=" );
//						Object arg = null;
//						Token token = StringUtil.indexOfStringBetween(parts[1], "${", "}");
//						if( token != null )
//							arg = formalParams[index].cast(ShellUtils.EVAL(ScriptEngineCode.getJavaScript(), token.getStr(), model ));
//						else
//							arg = convert ( formalParams[index], parts[1] );
//						args.add( arg );				
//					}
//				}
//				return invoke(object, method, args.toArray());
//			}catch (NumberFormatException e){
//				continue;
//			}
//		}
//		return null;
//	}

	protected static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);
	private static final Field[] EMPTY_FIELD_ARRAY = new Field[]{} ;
}
