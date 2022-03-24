package org.diembo.base.managers;

import org.diembo.base.utils.ByteUtils;

public interface ParameterManager {

	
	public final byte[] 	keyBytes 			= ByteUtils.hexStringToBytes("A19C874838D93FE0394E3D0392C391A7");
	public final byte[] 	ivBytes 			= ByteUtils.hexStringToBytes("74838635BC9A917FE60C9E339A38874A"); 
	public static String 	passwordPrefix 		= "^_^-^_";
	public static String 	keysSep 			= "____";

	public static int 		sessionLifeTime 	= 5 * 60 /* in seconds */;
	
	
	public static long 		selfEnrollCustomerTypeId = 0l;

	public static String 	CountryCode = "212";

	public static String 	institutionCode = "Bcep";
	public static String 	locationCode = "780";
	public static long 		customerRoleId = 0;

	public static String 	alphaType = "CapitalAlphanumeric";
	public static String 	alphaChkUnique = "Yes";
	public static int 		alphaLength = 8;
	public static int 		alphaMaxTries = 30;

	public static int 		wsContractInitialPl = 0;
	
	public static String 	fakePhoneNumber = "+00000000000";
	
	public static String 	browserDeviceCode = "default";


	String getSaphirParameter(String parameterCode);
	
	String getSaphirParameterIfAny(String parameterCode);
	
	boolean isImplicitAttachement();
	
	String getSaphirParameterByInstitution(String parameterCode, Long institutionId);
	
	String getSaphirParameterByInstitutionIfAny(String parameterCode, Long institutionId);
	
	// -------- ABB
	// String macKey = "A605E5D159F10EAB584434534FEF5D04";
	// String acquirerId = "350";
	// String outlet = "123456789012345";
	// String channelId = "1";
	// String location = "ABB Place Cheque Postaux";
	// String mtcSystem = "GALL";
	// -------- ABB

	// -------- BCEP
//		 String macKey			= "0623BA43DB3C98BDA029A271C2F7A3F6";
//		 String acquirerId		= "833";
//		 String outlet			= "123456789012345"; 
//		 String channelId		= "1";
//		 String location		= "BARIDMOBILEMPayment";
//		 String mtcSystem		= "GALL";
	// -------- BCEP
	/*
	 * Code : 069
	 * 
	 * Type canal : 2 (Mobile) mtc.channelType 2
	 * 
	 * Mode paiement : 3 (Mpayment)
	 * 
	 * mtc.modeId 3 mtc.timeoutDelay 90000
	 * 
	 */

}
