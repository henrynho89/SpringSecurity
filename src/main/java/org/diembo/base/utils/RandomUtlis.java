package org.diembo.base.utils;

import java.security.SecureRandom;


public class RandomUtlis {

	public static Byte generateRandomByte() {
		byte[] bytes = new byte[40];
		random.nextBytes(bytes);
		// Choose a random number between 0 and 39
		double 	randNumber = Math.random();
		int 	randomInt = (int)randNumber * 40;
		
		return bytes[randomInt];
	}

	public static Short generateRandomShort() {
		return (short)random.nextInt();
	}

	public static Integer generateRandomInteger() {
		return random.nextInt();
	}

	public static Long generateRandomLong() {
		return random.nextLong();
	}

	public static Float generateRandomFloat() {
		return random.nextFloat();
	}

	public static Double generateRandomDouble() {
		return random.nextDouble();
	}

	public static String generateRandomString(int length) {
		StringBuffer result = new StringBuffer();
		while (result.length() < length ) {
			result.append(Math.abs(generateRandomLong()));
		}
		return result.substring(0, length);
	}
	//
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //	
	public static String secureAlphaNumericRandom(int length) {
	    char[] CHARSET_AZ_09 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	    char[] result = new char[length];
	    for (int i = 0; i < result.length; i++) {
	        // picks a random index out of character set > random character
	        int randomCharIndex = random.nextInt(CHARSET_AZ_09.length);
	        result[i] = CHARSET_AZ_09[randomCharIndex];
	    }
	    return new String(result);
	}

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	public static String generateStringWithRegex(String regex) {
		String result = new GenerateStringWithRegex().stringFromRegex(regex);
		return result;
	}
	
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
    private static SecureRandom random = new SecureRandom();
	
	/* .~~~~~~~~..~~~~~~~~..~~~~~~~~. */
}
