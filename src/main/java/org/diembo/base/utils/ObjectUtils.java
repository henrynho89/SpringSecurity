package org.diembo.base.utils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectUtils {
	
	
	public static boolean isTrue( Boolean value ) {
		if ( value == null ) {
			return false;
		}
		return value;
	}

	
	public static <E> E getParameter( String objectName, E obj ) {
		if ( obj == null ) {
			throw new IllegalArgumentException("The suplied '" + objectName + "' is null.");
		}
		return obj;
	}

	/*
	public static <E> E extractParameter( String objectName, E obj ) {
		if ( obj == null ) {
			throw new IllegalArgumentException("The suplied '" + objectName + "' is null.");
		}
		return obj;
	}
*/
	
	public static void assertContains ( Object[] set, Object obj ) {
		if ( ! in ( obj, set ) ) {
			throw new RuntimeException("'" + Arrays.toString(set)
					+ "' doesn't contain '" + obj + "'.");
		}
	}

	public static void assertContains ( Collection<?> set, Object obj ) {
		if ( ! in ( obj, set.toArray() ) ) {
			throw new RuntimeException("'" + set + "' doesn't contain '"
					+ obj + "'.");
		}
	}

	public static void assertContained ( Object obj , Object...set) {
		if ( ! in ( obj, set ) ) {
			throw new RuntimeException("'" + Arrays.toString(set)
					+ "' doesn't contain '" + obj + "'.");
		}
	}

	public static void assertNotNull ( String objectName, Object obj ) {
		if ( obj == null ) {
			throw new IllegalArgumentException("The suplied '" + objectName + "' is null.");
		}
	}

	public static void assertNotEmpty ( String objectName, String obj ) {
		if ( StringUtils.isBlank(obj) ) {
			throw new IllegalArgumentException("The suplied string '" + objectName + "' is empty.");
		}
	}

	public static void assertNotEmpty ( String collectionName , Collection<?> collection ) {
		if ( collection.size() == 0 ) {
			throw new IllegalArgumentException("The suplied '" + collectionName + "' is empty.");
		}
	}

	public static void assertNotEmpty ( String mapName , Map<?, ?> map ) {
		if ( map.size() == 0 ) {
			throw new IllegalArgumentException("The suplied '" + map + "' is empty.");
		}
	}

	public static void assertEquals ( String objectName, Object expected, Object actual) {
		if 	(		expected == null && actual != null
				||	expected != null && actual == null
				||	expected != null && ! expected.equals(actual)
				||	actual != null && ! actual.equals(expected)
		) {
			throw new IllegalArgumentException("The expected value '"
					+ expected + "' of '" + objectName
					+ "' is difefrent than actual value '" + actual + "'.");
		}
	}

	
	/** Returns 'true' in case 'obj' equals one of the objects given in 'set'. */
	public static boolean in ( Object obj , Object[] set ) {
		if ( set == null ) {
			return false ;
		}
		
		for ( int i = 0 ; i < set.length ; i ++ ) {
			if ( ( set[i] == null && obj == null ) || ( set[i] != null && set[i].equals(obj) )) {
				return true ;
			}
		}

		return false ;
	}

	/** Returns 'true' in case 'obj' equals one of the objects given in 'set'. */
	public static boolean IN ( Object obj , Object...set) {
		return in ( obj, set ) ;
	}

	/**
	 * Returns <em>replacement</em> in case <em>data</em> is null. Otherwise, it
	 * returns <em>data</em>.
	 */
	public static String nvl ( Object data , String replacement ) {
		return data == null ? replacement : data.toString() ;
	}

	/**
	 * Copies deeply fields of <em>right</em> object to <em>left</em> object
	 * starting from the <em>fromClazz</em> till reaching the <em>toClazz</em>.
	 * Fields included within <em>noUpdateFields</em> array will not be
	 * assigned.
	 */
	public static void copy ( Object right , Object left , Class<?> fromClazz , Class<?> toClazz , String[] noUpdateFields ) {
		fromClazz		= fromClazz			== null ? right.getClass()	: fromClazz ;
		toClazz			= toClazz			== null ? Object.class		: toClazz ;
		noUpdateFields	= noUpdateFields	== null ? new String[]{}	: noUpdateFields ;

		while ( true ) {
			// Assign all immediate fields of 'right' to 'left'. Only fields
			// that have getter/setter will be considered.
			for ( Field field : fromClazz.getDeclaredFields() ) {
				String name = field.getName() ;
				if	(
						BeanUtils.hasGetter(right, name) && 
						BeanUtils.hasSetter(left, name, field.getType()) && 
						! in ( name , noUpdateFields )
					)
				{
					BeanUtils.callSetter ( left, name, field.getType() , BeanUtils.callGetter ( right , name ) );
				}
			}

			// The class of 'right' is it the 'rootClazz' class?
			if ( fromClazz.equals(toClazz) ) {
				// yes, the class of 'right' is the 'rootClazz' class; stop here
				break ;
			}

			// no, the class of 'right' isn't the 'rootClazz' class;
			// assign the fields of the parent class
			fromClazz = fromClazz.getSuperclass() ;
		}
	}

	protected final Logger logger = LoggerFactory.getLogger(getClass());
}
