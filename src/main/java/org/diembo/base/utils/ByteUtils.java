package org.diembo.base.utils;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Random;


public class ByteUtils {

	public static byte randomByte() {
		Random random = new Random();
		byte b = (byte) random.nextInt(63);
		return b;
	}

	public static final byte[] shortToBytes(short value) {
		return new byte[] { (byte) value, (byte) (value >>> 8) };
	}

	public static final short bytesToShort(byte[] b) {
		if ( b.length < 2 ) {
			throw new RuntimeException(
				"There are too little bytes " + b.length + " in the input array " + Arrays.toString(b) + "!") ;
		}

		if ( b.length > 2 ) {
			throw new RuntimeException(
				"There are too many bytes " + b.length + " in the input array " + Arrays.toString(b) + "!") ;
		}

		return (short)(((b[1] & 0xFF) << 8) + (b[0] & 0xFF));
	}

	public static final byte[] intToBytes(int value) {
		return new byte[] { (byte) (value >>> 24), (byte) (value >>> 16),
				(byte) (value >>> 8), (byte) value };
	}

	public static final int bytesToInt(byte[] b) {
		if ( b.length < 4 ) {
			throw new RuntimeException(
				"There are too little bytes " + b.length + " in the input array " + Arrays.toString(b) + "!") ;
		}

		if ( b.length > 4 ) {
			throw new RuntimeException(
				"There are too many bytes " + b.length + " in the input array " + Arrays.toString(b) + "!") ;
		}

		return (b[0] << 24) + ((b[1] & 0xFF) << 16) + ((b[2] & 0xFF) << 8)
				+ (b[3] & 0xFF);
	}

	public static final byte[] longToBytes(long value) {
		return new byte[] { (byte) value, (byte) (value >>> 8),
				(byte) (value >>> 16), (byte) (value >>> 24),
				(byte) (value >>> 32), (byte) (value >>> 40),
				(byte) (value >>> 48), (byte) (value >>> 56) };
	}

	public static final long bytesToLong(byte[] b) {
		if ( b.length < 8 ) {
			throw new RuntimeException(
				"There are too little bytes " + b.length + " in the input array " + Arrays.toString(b) + "!") ;
		}

		if ( b.length > 8 ) {
			throw new RuntimeException(
				"There are too many bytes " + b.length + " in the input array " + Arrays.toString(b) + "!") ;
		}

		int i = 0;
		int len = 8;
		int cnt = 0;
		int start = 0;
		byte[] tmp = new byte[len];
		for (i = start; i < (start + len); i++) {
			tmp[cnt] = b[i];
			cnt++;
		}
		long accum = 0;
		i = 0;
		for (int shiftBy = 0; shiftBy < 64; shiftBy += 8) {
			accum |= ((long) (tmp[i] & 0xff)) << shiftBy;
			i++;
		}
		return accum;
		// return (
		// // + (b[0] & 0xFF) << 56)
		// + b[0] << 56)
		// + ((b[1] & 0xFF) << 48)
		// + ((b[2] & 0xFF) << 40)
		// + ((b[3] & 0xFF) << 32)
		// + ((b[4] & 0xFF) << 24)
		// + ((b[5] & 0xFF) << 16)
		// + ((b[6] & 0xFF) << 8)
		// + ((b[7] & 0xFF));
	}

	public static byte[] doubleToBytes(double input) {

		long l = Double.doubleToLongBits(input);
		return longToBytes(l);

		// input += 0.00000000001; // XYXYXYXYXYXYXYXYXYXY a cause du fait que
		// 77.74 est transformé en 77.739999999999
		// long l = (long) (input * 100);
		// return longToBytes(l);

	}

	public static double bytesToDouble(byte[] b) {

		return Double.longBitsToDouble(bytesToLong(b));

		// return ((double) bytesToLong(b) / 100);
	}

	public static boolean arrayContainsFields(int[] array, int field) {
		boolean result = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == field) {
				result = true;
				break;
			}
		}
		return result;
	}

	public static byte[] BytesTobytes(Byte[] input) {
		byte[] result = new byte[input.length];
		for (int i = 0; i < input.length; i++) {
			result[i] = input[i].byteValue();
		}
		return result;
	}

	public static Byte[] bytesToBytes(byte[] input) {
		Byte[] result = new Byte[input.length];
		for (int i = 0; i < input.length; i++)
			result[i] = new Byte(input[i]);
		return result;
	}

	// public static Byte[] stringToBytes(String s) {
	// byte[] bs = s.getBytes();
	//
	// Byte[] result = new Byte[bs.length];
	// for (int i = 0; i < bs.length; i++) {
	// result[i] = new Byte(bs[i]);
	// }
	// return result;
	// }

	public static Byte[] stringToBytes(String s) {
		byte[] bs = stringToByteArray(s);

		Byte[] result = new Byte[bs.length];
		for (int i = 0; i < bs.length; i++) {
			result[i] = new Byte(bs[i]);
		}
		return result;
	}

	public static byte[] stringToByteArray(String s) {
		byte[] bs = null;
		try {
			bs = s.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("Exception while retrieving bytes of '"
					+ s + "'\n"  + e.getMessage());
		}
		return bs;
	}

	public static byte[] hexStringToBytes(String hexStr) {
		byte bArray[] = new byte[hexStr.length() / 2];
		for (int i = 0; i < (hexStr.length() / 2); i++) {
			byte firstNibble = Byte.parseByte(
					hexStr.substring(2 * i, 2 * i + 1), 16); // [x,y)
			byte secondNibble = Byte.parseByte(
					hexStr.substring(2 * i + 1, 2 * i + 2), 16);
			int finalByte = (secondNibble) | (firstNibble << 4); // bit-operations
																	// only with
																	// numbers,
																	// not
																	// bytes.
			bArray[i] = (byte) finalByte;
		}
		return bArray;
	}

	private static final char[] kDigits = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String bytesToHexString(Byte[] raw) {
		byte[] raw2 = new byte[raw.length];
		for (int i = 0; i < raw.length; i++)
			raw2[i] = raw[i].byteValue();
		return bytesToHexString(raw2);
	}

	public static String bytesToHexString(byte[] raw) {
		if (raw == null) {
			return null;
		}
		int length = raw.length;
		char[] hex = new char[length * 2];
		for (int i = 0; i < length; i++) {
			int value = (raw[i] + 256) % 256;
			int highIndex = value >> 4;
			int lowIndex = value & 0x0f;
			hex[i * 2 + 0] = kDigits[highIndex];
			hex[i * 2 + 1] = kDigits[lowIndex];
		}
		return new String(hex);
	}


	/**
	 * Convert the passed in String to a byte array by taking the bottom 8 bits
	 * of each character it contains.
	 * 
	 * @param string
	 *            the string to be converted
	 * @return a byte array representation
	 */
	public static byte[] toByteArray(String string) {
		byte[] bytes = new byte[string.length()];
		char[] chars = string.toCharArray();

		for (int i = 0; i != chars.length; i++) {
			bytes[i] = (byte) chars[i];
		}

		return bytes;
	}

	/** Returns the 'HEX' representation of given bytes. */
	public static String toHex ( byte[] bytes ) {
		String result = "" ;

		for ( int i = 0 ; i < bytes.length ; i++ ) {
			if ( i%4 == 0 && i > 0 )
				result += ' ' ;
			result += StringUtils.lpad(Integer.toHexString(bytes[i]&0x000000ff), 2 , '0');
		}

		return result ;
	}

	/**
	 * Convert a byte array of 8 bit characters into a String.
	 * 
	 * @param bytes
	 *            the array containing the characters
	 * @param length
	 *            the number of bytes to process
	 * @return a String representation of bytes
	 */
	public static String toString(byte[] bytes, int length) {
		char[] chars = new char[length];

		for (int i = 0; i != chars.length; i++) {
			chars[i] = (char) (bytes[i] & 0xff);
		}

		return new String(chars);
	}

	/**
	 * Convert a byte array of 8 bit characters into a String.
	 * 
	 * @param bytes
	 *            the array containing the characters
	 * @param length
	 *            the number of bytes to process
	 * @return a String representation of bytes
	 */
	public static String toString(byte[] bytes) {
		return toString(bytes, bytes.length);
	}

	/**
	 * Removes all spaces add by {@link #toHex(byte[])} to ease reading the HEX
	 * representation.
	 */
	public static String normalizeHex ( String original ) {
		return original.replaceAll ("\\s", "") ;
	}

	/** Converts a String to a bytes array by casting each 'char' to a 'byte'. */
	public static byte[] toArray ( String input ) {
		byte[] output = new byte[input.length()];
		for ( int i = 0 ; i < input.length() ; i++ ) {
			output [ i ] = (byte) input.charAt ( i ) ;
		}
		return output ;
	}

	/** Expands each byte to two bytes that are its hex representation. */
	public static byte[] expand ( byte[] input ) {
		return expand(input, input.length);
	}

	/** Expands each byte to two bytes that are its hex representation. */
	public static byte[] expand ( byte[] input , boolean useUpperCase) {
		return expand(input, input.length, useUpperCase);
	}

	/** Expands each byte to two bytes that are its hex representation. */
	public static byte[] expand ( byte[] input , int length ) {
		return expand(input, input.length, false);
	}

	/** Expands each byte to two bytes that are its hex representation. */
	public static byte[] expand ( byte[] input , int length , boolean useUpperCase) {
		if ( length > input.length){
			throw new IllegalArgumentException("The supplied length '" + length
					+ "' is greater than the length of the input '"
					+ input.length + "'.");
		}

		byte[] output = new byte[length*2];

		for ( int i = 0 ; i < length ; i++ ) {
			// Left nibble
			output[2*i] = expand ( (byte) (( input[i] & 0xf0 ) >> 4) , useUpperCase) ;

			// Right nibble
			output[2*i+1] = expand ( (byte) (input[i] & 0x0f) , useUpperCase) ;
		}

		return output;
	}

	/**
	 * Compresses each two bytes to one byte. The content of each byte of the
	 * input string should be an hex number.
	 */
	public static byte[] compress ( final byte[] input )
	{
		return compress(input, 0, input.length);
	}

	/**
	 * Compresses each two bytes to one byte. The content of each byte of the
	 * input string should be an hex number.
	 */
	public static byte[] compress ( final byte[] input , int length ) {
		return compress(input, 0, length);
	}

	/**
	 * Compresses each two bytes to one byte. The content of each byte of the
	 * input string should be an hex number.
	 */
	public static byte[] compress ( final byte[] input , int from , int to)
	{
		if ( from < 0 || from >= input.length ){
			throw new IllegalArgumentException("The supplied value '" + from
					+ "' for 'from' should be positive and should be less than the length "
					+ "of the input '" + input.length + "'.");
		}

		if ( to < from || to > input.length){
			throw new IllegalArgumentException("The supplied to '" + to
					+ "' should be greater than the from '" + from
					+ "' and should be less than the length "
					+ "of the input '" + input.length + "'.");
		}

		// keep only the part that we have to compress
		byte[] work = Arrays.copyOfRange(input, from, to);

		// left padding with '0' in case the length of the data to compress is odd
		int length = to - from ;
		if ( length%2 == 1 ) {
			byte[] tmp = new byte[length + 1 ] ;
			tmp[0] = '0' ;
			for ( int index = 0 ; index < length ; index ++ )
				tmp [ index + 1 ] = work [ index ] ;
			work = tmp ;
			length ++ ;
		}

		byte[] output = new byte[length/2] ;

		for ( int i = 0 ; i < length/2 ; i++){
			// Left nibble
			output[i] = (byte)(compress ( work[2*i] ) << 4 & 0xf0) ;

			// Right nibble
			output[i] |= (byte) (compress (work[2*i + 1 ]) & 0x0f) ;
		}

		return output;
	}

	/** Expands a nibble to byte. */
	private static byte expand ( byte input , boolean useUpperCase ) {
		byte nibble = input ;
		if ( nibble >= 0x00 && nibble <= 0x09 )
			nibble += '0' ;
		else if ( nibble >= 0x0a && nibble <= 0x0f )
			nibble += (useUpperCase ? 'A' : 'a') - 0x0a ;
		return nibble ;
	}

	/** Compresses a byte to nibble. */
	private static byte compress ( byte input )
	{
		byte nibble = input;
		if ( nibble >= '0' && nibble <= '9' )
			nibble -= '0' ;
		else if ( nibble >= 'a' && nibble <= 'f' )
			nibble += 0x0a - 'a';
		else if ( nibble >= 'A' && nibble <= 'F' )
			nibble += 0x0a - 'A';
		else {
			String errmsg = "Invalid input '" + (char)input + "'.\n"
				+ "Only hex numbers are expected."
				;
			throw new RuntimeException(errmsg);
		}
		return nibble ;
	}
}
