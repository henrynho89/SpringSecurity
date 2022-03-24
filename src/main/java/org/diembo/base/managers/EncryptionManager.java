package org.diembo.base.managers;


public interface EncryptionManager {
	
	String digestSH512(String dataToDigest); 
	
	String digest(String value, String salt);
	String computeCheckDigit(String data);
	String createJWT(String ch,String secretKey);
	
	byte[] encrypt(byte[] keyBytes, byte[] ivBytes, byte[] mes) throws Exception; 
	byte[] decrypt(byte[] keyBytes, byte[] ivBytes, byte[] bytes) throws Exception;

	   
}
