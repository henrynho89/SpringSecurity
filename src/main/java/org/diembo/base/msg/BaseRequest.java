package org.diembo.base.msg;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.diembo.base.utils.BasicItem;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BaseRequest implements Serializable{


	// ------------------------------------------------------------------------------------------- //
	// ------------------------------------------------------------------------------------------- //
	private MessageInfo				messageInfo		= new MessageInfo();
	private DeviceInfo				deviceInfo		= new DeviceInfo();
	private AppInfo					appInfo			= new AppInfo();


//	private String					institution		;  // institution_code
	private String					login			;  // "SidUser"
	private String					token			;
	private String					otp				;
	private String					otpReference	;
	
	private String					password		;  // "I1ll1I01&#I0O1IO00O"
	private String					newPassword		;  
	private String					digestedPassword;  
	
	
	private String					service			; 
	private String					parameter		;
	
	private String					strArg1			; // AccountCreditReq.contractIdentifier
	private String					strArg2			; // Sender Mobile Phone Number
	private String					strArg3			; // AccountCreditReq.purpose
	private String					strArg4			;
	private String					strArg5			;
	private List<String>			strings			;

	private Long					lngArg1			; // AccountCreditReq.Amount.value
	private Long					lngArg2			;
	private Long					lngArg3			;
	private List<Long>				longs			;

	
	private Double					nbrArg1			; // AccountCreditReq.Amount.value
	private Double					nbrArg2			;
	private Double					nbrArg3			;
	private List<Double>			numbers			;
	
	private Date 					dteArg1      	;
	private Date 					dteArg2      	;
	private Date 					dteArg3      	;
	private List<Date>				dates			;
	
	private Long					id				;
	
	private Boolean					blnArg1			;
	private Boolean					blnArg2			;
	private Boolean					blnArg3			;
	private List<Boolean>			booleans		;

	private Long 					page			;
	

	private List<BasicItem>			items			;
	
	
	private String contractIdentifierOrPseudo		;
	
	private String release							;
	private String ipAddress						;
	


	
	// ------------------------------------------------------------------------------------------- //
 	
	// ------------------------------------------------------------------------------------------- //
	// ------------------------------------------------------------------------------------------- //
	
	
	public List<BasicItem> getItems() {
		return items;
	}
	public void setItems(List<BasicItem> items) {
		this.items = items;
	}
	
//	public String getInstitution() {
//		return institution;
//	}
//	public void setInstitution(String institution) {
//		this.institution = institution;
//	}
	// --------------------------------------- //
	
	public DeviceInfo getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(DeviceInfo deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	// --------------------------------------- //
	
	public AppInfo getAppInfo() {
		return appInfo;
	}
	public void setAppInfo(AppInfo appInfo) {
		this.appInfo = appInfo;
	}
	


	public String getContractIdentifierOrPseudo() {
		return contractIdentifierOrPseudo;
	}
	public void setContractIdentifierOrPseudo(String contractIdentifierOrPseudo) {
		this.contractIdentifierOrPseudo = contractIdentifierOrPseudo;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	// --------------------------------------- //
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

	// --------------------------------------- //
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	// --------------------------------------- //
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	
	// --------------------------------------- //
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	
	// --------------------------------------- //
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	// --------------------------------------- //
	public String getStrArg1() {
		return strArg1;
	}
	public void setStrArg1(String strArg1) {
		this.strArg1 = strArg1;
	}
	
	// --------------------------------------- //
	public String getStrArg2() {
		return strArg2;
	}
	public void setStrArg2(String strArg2) {
		this.strArg2 = strArg2;
	}
	// --------------------------------------- //
	
	public String getStrArg3() {
		return strArg3;
	}
	public void setStrArg3(String strArg3) {
		this.strArg3 = strArg3;
	}
	
	// --------------------------------------- //

	public String getStrArg4() {
		return strArg4;
	}
	public void setStrArg4(String strArg4) {
		this.strArg4 = strArg4;
	}
	// --------------------------------------- //

	public String getStrArg5() {
		return strArg5;
	}
	public void setStrArg5(String strArg5) {
		this.strArg5 = strArg5;
	}
	
	// --------------------------------------- //
	public Double getNbrArg1() {
		return nbrArg1;
	}
	public void setNbrArg1(Double nbrArg1) {
		this.nbrArg1 = nbrArg1;
	}

	// --------------------------------------- //
	public Double getNbrArg2() {
		return nbrArg2;
	}
	public void setNbrArg2(Double nbrArg2) {
		this.nbrArg2 = nbrArg2;
	}
	
	// --------------------------------------- //
	public Double getNbrArg3() {
		return nbrArg3;
	}
	public void setNbrArg3(Double nbrArg3) {
		this.nbrArg3 = nbrArg3;
	}
	
	// --------------------------------------- //
	public Date getDteArg1() {
		return dteArg1;
	}
	public void setDteArg1(Date dteArg1) {
		this.dteArg1 = dteArg1;
	}
	
	// --------------------------------------- //
	public Date getDteArg2() {
		return dteArg2;
	}
	public void setDteArg2(Date dteArg2) {
		this.dteArg2 = dteArg2;
	}
	
	// --------------------------------------- //
	public Date getDteArg3() {
		return dteArg3;
	}
	public void setDteArg3(Date dteArg3) {
		this.dteArg3 = dteArg3;
	}
	// --------------------------------------- //
	public MessageInfo getMessageInfo() {
		return messageInfo;
	}
	public void setMessageInfo(MessageInfo messageInfo) {
		this.messageInfo = messageInfo;
	}
	
	// --------------------------------------- //
	public Boolean getBlnArg1() {
		return blnArg1;
	}
	public void setBlnArg1(Boolean blnArg1) {
		this.blnArg1 = blnArg1;
	}
	// --------------------------------------- //
	public Boolean getBlnArg2() {
		return blnArg2;
	}
	public void setBlnArg2(Boolean blnArg2) {
		this.blnArg2 = blnArg2;
	}
	// --------------------------------------- //
	public Boolean getBlnArg3() {
		return blnArg3;
	}
	public void setBlnArg3(Boolean blnArg3) {
		this.blnArg3 = blnArg3;
	}

	public Long getLngArg1() {
		return lngArg1;
	}
	public void setLngArg1(Long lngArg1) {
		this.lngArg1 = lngArg1;
	}
	public Long getLngArg2() {
		return lngArg2;
	}
	public void setLngArg2(Long lngArg2) {
		this.lngArg2 = lngArg2;
	}
	public Long getLngArg3() {
		return lngArg3;
	}
	public void setLngArg3(Long lngArg3) {
		this.lngArg3 = lngArg3;
	}
	public List<String> getStrings() {
		return strings;
	}
	public void setStrings(List<String> strings) {
		this.strings = strings;
	}
	public List<Long> getLongs() {
		return longs;
	}
	public void setLongs(List<Long> longs) {
		this.longs = longs;
	}
	public List<Double> getNumbers() {
		return numbers;
	}
	public void setNumbers(List<Double> numbers) {
		this.numbers = numbers;
	}
	public List<Date> getDates() {
		return dates;
	}
	public void setDates(List<Date> dates) {
		this.dates = dates;
	}
	public List<Boolean> getBooleans() {
		return booleans;
	}
	public void setBooleans(List<Boolean> booleans) {
		this.booleans = booleans;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}

	
	
	
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	// --------------------------------------- //
	public String getOtpReference() {
		return otpReference;
	}
	public void setOtpReference(String otpReference) {
		this.otpReference = otpReference;
	}
	

	
	public String getRelease() {
		return release;
	}
	public void setRelease(String release) {
		this.release = release;
	}
	
	public String getDigestedPassword() {
		return digestedPassword;
	}
	public void setDigestedPassword(String digestedPassword) {
		this.digestedPassword = digestedPassword;
	}


	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public BaseRequest() {}

	public BaseRequest(String reference ) {
		messageInfo.setReference(reference);
	}
	
	// ------------------------------------------------------------------------------------------- //
	// ------------------------------------------------------------------------------------------- //
	
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();

		str.append("BaseRequest {");
		str.append("messageInfo=").append(messageInfo.toString());
		str.append("}");

		return str.toString();
	}

	// ------------------------------------------------------------------------------------------- //
	// ------------------------------------------------------------------------------------------- //
	private static final long serialVersionUID = 1L;

}
