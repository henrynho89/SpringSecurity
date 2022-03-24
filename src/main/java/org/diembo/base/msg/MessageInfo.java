package org.diembo.base.msg;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.diembo.base.enums.BackendSystem;
import org.diembo.base.enums.MessageCode;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class MessageInfo implements Serializable {
	
	private String					accessChannel		;
	private String					language			;
	private Date					transactionTime		;
	
	private String					userLocation 		;
	private int						appRelease			;
	private String 					userIpAddress	= "192.168.0.1";

	private String					reference		= UUID.randomUUID().toString();
	
	private BackendSystem 			originator;
	
	private MessageCode				messageCode			;
	
	private String					institutionCode		;  


	public BackendSystem getOriginator() {
		return originator;
	}
	public void setOriginator(BackendSystem originator) {
		this.originator = originator;
	}
	
	
	public String getVersion() {
		return VERSION;
	}
	public String getAccessChannel() {
		return accessChannel;
	}
	public void setAccessChannel(String accessChannel) {
		this.accessChannel = accessChannel;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Date getTransactionTime() {
		return transactionTime;
	}
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	public String getUserLocation() {
		return userLocation;
	}
	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}
	public int getAppRelease() {
		return appRelease;
	}
	public void setAppRelease(int appRelease) {
		this.appRelease = appRelease;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setVersion(String version) {
	}
	
	public MessageCode getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(MessageCode messageCode) {
		this.messageCode = messageCode;
	}
	
	
	public String getUserIpAddress() {
		return userIpAddress;
	}
	public void setUserIpAddress(String userIpAddress) {
		this.userIpAddress = userIpAddress;
	}
	
	
	public String getInstitutionCode() {
		return institutionCode;
	}
	public void setInstitutionCode(String institutionCode) {
		this.institutionCode = institutionCode;
	}
	
	
	public String toString() {
		StringBuffer str = new StringBuffer() ;

		str.append("MessageInfo {")
		.append(", ").append("reference=").append(reference)
		.append(", ").append("timestamp=").append(transactionTime)
		.append(", ").append("language=").append(language)
		.append(", ").append("accessChannel=").append(accessChannel)
		.append(", ").append("userLocation=").append(userLocation)
		.append(", ").append("version=").append(VERSION)
		.append("}");

		return str.toString();
	}
	

	private static final String VERSION = null;
//	static {
//		Properties props = new Properties();
//		try {
//			props.load(Class.class.getResourceAsStream("/MessageInfo.properties"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		VERSION = props.getProperty("version");
//	}
	private static final long serialVersionUID = 1L;
	
}
