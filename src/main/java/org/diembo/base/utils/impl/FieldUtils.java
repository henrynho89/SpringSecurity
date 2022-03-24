package org.diembo.base.utils.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class FieldUtils {
	public static String[] lookupAllFieldsNameOf(Class<?> type) {
		List<Field> fields = lookupAllFieldsOf(type);
		String[] fieldNames = new String[fields.size()];

		for ( int index = 0; index < fields.size(); index ++ ) {
			fieldNames[index] = fields.get(index).getName();
		}

		return fieldNames;
	}

	public static List<Field> lookupAllFieldsOf(Class<?> type) {
		List<Field> fields = new ArrayList<Field>();
		Class<?> currentClass = type ;
		while ( ! Object.class.equals(currentClass) ) {
			for ( Field field : currentClass.getDeclaredFields() ) {
				if ( ! Modifier.isStatic(field.getModifiers()) ) {
					fields.add(field);
				}
			}
			currentClass = currentClass.getSuperclass();
		}

		return fields;
	}

	public static Field lookupFieldOf(Class<?> entityType, String fieldName) {
		String entityCodeFieldName = entityType.getSimpleName() + "Code" ;
		entityCodeFieldName = Character.toLowerCase(entityCodeFieldName.charAt(0)) + entityCodeFieldName.substring(1);
		if ( fieldName.equals(entityCodeFieldName)  ) {
			fieldName = fieldName.replaceFirst("Code$", "_code");
		}
		for ( Field field : FieldUtils.lookupAllFieldsOf(entityType) ) {
			if ( fieldName.equals(field.getName()) ) {
				return field ;
			}
		}

		throw new RuntimeException("The field '" + fieldName + "' is missing in '" + entityType + "'.");
	}
	
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	public static List<Field>  lookupFieldsNames (Class<?> entity, String[] fieldsNames){
		List<Field>		fields = new ArrayList<Field>();
		for (String fieldName: fieldsNames ){
			fields.add(lookupFieldOf(entity, fieldName));
		}
		return fields;
	}

}
