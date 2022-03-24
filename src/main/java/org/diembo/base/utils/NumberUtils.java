package org.diembo.base.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParsePosition;
import java.util.Locale;

import org.diembo.base.enums.ErrorCode;

public class NumberUtils {


	public static String convertNumber(String number) {
		String result = null;
		try {
			DecimalFormat df = new DecimalFormat("#.#", new DecimalFormatSymbols(new Locale("fr", "FR")));
			result = ""+df.parse(number);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}

	public static Double stringToDouble(String string) {
		if ( string == null ) {
			throw new SaphirException(ErrorCode.errUnexpectedError, "Can't convert a null to double.");
		}

		for(int index=0; index < string.length(); index++){
			if((string.codePointAt(index) < 48 ||
					string.codePointAt(index) > 57) && string.codePointAt(index) != 44 && string.codePointAt(index) != 45){
				throw new SaphirException(ErrorCode.errUnexpectedError, "Can't convert string '"+string+"' to double error in INDEX["+index+"] CHAR[" + string.charAt(index) + "] CODE[" + string.codePointAt(index) + "]");
			}
		}

		ParsePosition pos = new ParsePosition(0);
		DecimalFormat df = new DecimalFormat("#.#", new DecimalFormatSymbols(new Locale("fr", "FR")));
		Number result = df.parse(string, pos);

		// have we succeded in parsing the string?
		if ( result == null ) {
			throw new SaphirException(ErrorCode.errUnexpectedError, "Failed to convert '" + string + "' to double.");
		}

		// have we consumed all the entire string?
		if ( pos.getIndex() < string.length() ) {
			throw new SaphirException(ErrorCode.errUnexpectedError, "Failed to convert the entire string '" + string + "' to double.");
		}

		return result.doubleValue();
	}

	public static String doubleToString(Double d) {
		DecimalFormat df = new DecimalFormat("#.#", new DecimalFormatSymbols(new Locale("fr", "FR")));
		return df.format(d);
	}

}
