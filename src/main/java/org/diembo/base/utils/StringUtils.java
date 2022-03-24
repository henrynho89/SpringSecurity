package org.diembo.base.utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Vector;


public class StringUtils {

	// ==========================================================================================
	// These functions are not in the crossplateform package because some of
	// them are not supported by J2ME
	// ===========================================================================================================
	/**
	 * Returns <code>replacement</code> in case <code>data</code> is
	 * <code>null</code>. Otherwise,it returns <code>data</code>.
	 * 
	 * @param data
	 *            to be checked whether it is <code>null</code> or not.
	 * @param replacement
	 *            the string that will be returned in case <code>data</code> is
	 *            null.
	 */
	
	
	
	public static String truncate(String data, int length) {
		
		if (data == null) {
			return null;
		}
		
		if (length >= data.length()) {
			return data;
		}
		return data.substring(0, length);
	}

	public static String nvl(String data, String replacement) {
		return data == null ? replacement : data;
	}

	/**
	 * returns true in case 'data' is null or equals a blank (spaces, '\t' or
	 * '\n')
	 */
	public static String removeBlanks(String data) {
		return data.replaceAll("[ \\t\\\n]", "");
	}

	public static boolean isBlank(String data) {
		return data == null || "".equals(removeBlanks(data));
	}

	/** Hyphenize the given string */
	public static String hyphenize(String str) {
		String hyphenized = str;
		if (str != null && str.length() > 0) {
			hyphenized = str.substring(0, 1).toLowerCase();
			for (int index = 1; index < str.length(); index++) {
				if (Character.isUpperCase(str.charAt(index)))
					hyphenized += "-"
							+ Character.toLowerCase(str.charAt(index));
				else
					hyphenized += str.charAt(index);
			}
		}

		return hyphenized;
	}

	/** Hyphenize the simple name of the given class */
	public static String hyphenize(Class<?> clazz) {
		return hyphenize(clazz.getSimpleName());
	}

	/**
	 * Returns a string representing the boolean <em>b</em>. In case <em>b</em>
	 * is <em>null</em>, <em>dflt</em> will be considered.
	 */
	public static String booleanString(Boolean b, boolean dflt) {
		String result = null;
		if (b == null)
			result = booleanString(dflt, false);
		else if (b)
			result = "Y";
		else
			result = "N";

		return result;
	}

	public static class Token {
		private String token;
		private String str;
		private String startMark;
		private String endMark;
		private int start;
		private int end;

		public Token() {
		}

		public Token(String token, String str, String startMark,
				String endMark, int start, int end) {
			this.token = token;
			this.str = str;
			this.startMark = startMark;
			this.endMark = endMark;
			this.start = start;
			this.end = end;
		}

		public String getToken() {
			return token;
		}

		public void setToken(String token) {
			this.str = token;
		}

		public String getStr() {
			return str;
		}

		public void setStr(String str) {
			this.str = str;
		}

		public String getStartMark() {
			return startMark;
		}

		public void setStartMark(String startMark) {
			this.startMark = startMark;
		}

		public String getEndMark() {
			return endMark;
		}

		public void setEndMark(String endMark) {
			this.endMark = endMark;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}
	}

	public static Token indexOfStringBetween(String input, String startMark,
			String endMark) {
		return indexOfStringBetween(input, startMark, endMark, 0);
	}

	public static Token indexOfStringBetween(String input, String startMark,
			String endMark, int start) {
		// look for the startMark
		start = input.indexOf(startMark, start);
		if (start == -1)
			return null;

		// look for the endMark
		int end = input.indexOf(endMark, start + startMark.length());
		if (end == -1)
			return null;

		// extract the string
		String str = input.substring(start + startMark.length(), end);

		return new Token(startMark + str + endMark, str, startMark, endMark,
				start, end);
	}

	public static final boolean isNumeric(final String s) {
		if (s == null || s.isEmpty())
			return false;

		for (int x = 0; x < s.length(); x++) {
			final char c = s.charAt(x);
			if ((c >= '0') && (c <= '9'))
				continue; // 0 - 9
			return false; // invalid
		}
		return true; // valid
	}

	public static String trimIfNotNull(String input) {
		if (input == null)
			return null;
		return input.trim();
	}

	
	public static String rtrim(String data) {
		return rtrim(rtrim(rtrim(rtrim(rtrim(data, ' '), '\t'), '\n'), '\f'), '\r');
	}

	public static String rtrim(String data, char c) {
		int index = data.length() - 1;
		for ( ; index >= 0; index -- ) {
			if ( data.charAt(index) != c ) {
				break ;
			}
		}
		return data.substring(0, index + 1);
	}

	public static String ltrim(String data) {
		return data.replaceFirst("^\\s*", "");
	}

	public static String ltrim(String data, char c) {
		return data.replaceFirst("^["+c+"]*", "");
	}

	public static String lpad(String data, int length, char pad) {
		String result = data;
		for (int i = data.length(); i < length; i++)
			result = pad + result;
		return result;
	}

	public static String lpad(String data, int length) {
		return lpad(data, length, ' ');
	}

	public static String rpad(String data, int length, char pad) {
		String result = data;
		for (int i = data.length(); i < length; i++)
			result += pad;
		return result;
	}

	public static String rpad(String data, int length) {
		return rpad(data, length, ' ');
	}

	public static String formatDoubleValue_2(double value, int decimalPlaces) {
		String doubleString = formatDouble(value);
		int pIndex = doubleString.indexOf(".");
		String result = "??";
		if (pIndex == -1) {

			result = doubleString + "." + rpad("", decimalPlaces, '0');

		} else {

			int stringLength = pIndex + decimalPlaces + 1;

			if (doubleString.length() <= stringLength) {
				result = rpad(doubleString, stringLength, '0');
			} else {
				result = doubleString.substring(0, stringLength);
			}
		}
		return result;
	}

	public static String formatDoubleValueWithRounding(double value, int decimalPlaces) {
		String format;
		if (decimalPlaces == 0) {
			format = "0";
		}
		else {
			 format = rpad("0.", decimalPlaces+2, '0');
		}
		DecimalFormat formatter = new DecimalFormat(format, new DecimalFormatSymbols(new Locale("en", "EN")));
		return formatter.format(value);
	}

	private static String formatDouble(double d) {
		String s = Double.toString(d);

		if (!(Double.isNaN(d) || Double.isInfinite(d))) {
			char[] ch = s.toCharArray();
			boolean isNegative = ch[0] == '-';

			StringBuffer digits = new StringBuffer(ch.length);
			StringBuffer exp = new StringBuffer(ch.length);
			boolean foundE = false;
			int point = 0;
			for (int i = 0; i < ch.length; i++) {
				char c = ch[i];
				if (c == 'E') {
					foundE = true;
				} else if (c >= '0' && c <= '9') {
					if (foundE) {
						exp.append(c);
					} else {
						digits.append(c);
					}
				} else if (c == '-' && foundE) {
					exp.append(c);
				} else if (c == '.') {
					point = digits.length();
				}
			}
			if (exp.length() > 0) {
				point += Integer.parseInt(exp.toString());
			}
			while (point < 1) {
				digits.insert(0, '0');
				point++;
			}
			while (point >= digits.length()) {
				digits.append('0');
			}
			digits.insert(point, '.');
			if (isNegative) {
				digits.insert(0, '-');
			}
			boolean done = false;
			do {
				int last = digits.length() - 1;
				char c = digits.charAt(last);
				if (c == '0' || c == '.') {
					digits.deleteCharAt(last);
				}
				if (c != '0') {
					done = true;
				}
			} while (!done);

			s = digits.toString();
		}
		return s;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector getStrings(byte[] message, byte sep) {
		Vector result = new Vector();
		int index = 0;
		int messageLength = message.length;

		while (index < messageLength) {
			int end = index ;
			while ((end < messageLength) && (message[end] != sep))
				end ++ ;
			String str = null;
			try {
				str = new String ( message, index, end - index , "UTF-8" );
				index = end ;
			} catch (Exception e) {
				throw new RuntimeException("Unsupported Charset UTF-8");
			}
			result.addElement(str);
			if ((index < messageLength)) {
				index++;
			}
		}
		return result;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Vector getByteArrays(byte[] message, byte sep) {
		Vector result = new Vector();
		int index = 0;
		int messageLength = message.length;

		while (index < messageLength) {

			int length = 0;
			while ((message[index + length] != sep)
					&& (index + length < messageLength)) {
				length++;
			}

			byte[] byteArray = new byte[length];
			int i = 0;
			while ((message[index] != sep) && (index < messageLength)) {
				byteArray[i++] += message[index++];
			}
			result.addElement(byteArray);
			if ((index < messageLength)) {
				index++;
			}
		}
		return result;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String[] split(String original, char separator) {
		Vector nodes = new Vector();

		int index = 0;
		int length = original.length();
		String currentNode = "";
		char currentChar;
		while (index < length) {
			
			currentChar = original.charAt(index++);
			
			if (currentChar == separator){
				nodes.addElement(currentNode);
				currentNode = "";
				continue;
			} 
				
			if (index == length){
				currentNode += currentChar;
				nodes.addElement(currentNode);
				break;
			} 
				
			currentNode += currentChar;
		}

		// Create split string array
		String[] result = new String[nodes.size()];
		if (nodes.size() > 0) {
			for (int loop = 0; loop < nodes.size(); loop++) {
				result[loop] = (String) nodes.elementAt(loop);
			}
		}
		return result;
	}
	
	
	public static String formatMsisdn(String msisdn) {
		
		String nationalPrefix = "+" + "212"; //ParameterManager.CountryCode;
		
		if (msisdn.startsWith("00")) {
			
			msisdn = "+" + msisdn.substring(2);
			
		} else {
			
			if (msisdn.startsWith("0")) {
				msisdn = nationalPrefix + msisdn.substring(1);
			}
			
		}
		return msisdn;	
	}

	public static String blankToNull(String param) {
		if (isBlank(param)) return null;
		return param;
	}

}
