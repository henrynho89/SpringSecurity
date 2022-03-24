package org.diembo.base.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@javax.persistence.Entity
@Table( name = "OTP_DETAILS")

public class OtpDetail extends GenericEntity {


	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long id;


	@Column(name = "REFERENCE"  , length=30)
	private String reference;

	@Column(name = "OTP"  , length=30)
	private String otp;

	@Column(name = "EXPIRYDATE", nullable = false)
	protected Date expiryDate;
	
	@Column(name = "WRONG_TRIES")
	private Short wrongTries;

	@Column(name = "LOGDATE", nullable = false)
	protected Date logDate;
	
	@Column(name = "USED")
	private Boolean used;
	
	@Column(name = "USER_FIELD1" , length = 256)
	private String userField1;

	@Column(name = "USER_FIELD2" , length = 256)
	private String userField2;

	@Column(name = "USER_FIELD3" , length = 256)
	private String userField3;

	
	@Column(name = "USER_FIELD4" , length = 256)
	private String userField4;
	
	@Column(name = "USER_FIELD5" , length = 256)
	private String userField5;
	

	public Short getWrongTries() {
		return wrongTries;
	}

	public void setWrongTries(Short wrongTries) {
		this.wrongTries = wrongTries;
	}
	

	public String getUserField1() {
		return userField1;
	}

	public void setUserField1(String userField1) {
		this.userField1 = userField1;
	}
	
	public String getUserField2() {
		return userField2;
	}

	public void setUserField2(String userField2) {
		this.userField2 = userField2;
	}
	
	public String getUserField3() {
		return userField3;
	}

	public void setUserField3(String userField3) {
		this.userField3 = userField3;
	}

	public String getUserField4() {
		return userField4;
	}

	public void setUserField4(String userField4) {
		this.userField4 = userField4;
	}
	
	public String getUserField5() {
		return userField5;
	}

	public void setUserField5(String userField5) {
		this.userField5 = userField5;
	}
	

	public Boolean getUsed() {
		return used;
	}

	public void setUsed(Boolean used) {
		this.used = used;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	@Override
	public void setIdToNull() {
		setId(null);
	}


	
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getReference() {
		return this.reference;
	}


	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getOtp() {
		return this.otp;
	}
		

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	public Date getLogDate() {
		return this.logDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getExpiryDate() {
		return this.expiryDate;
	}


	private static final long serialVersionUID = 1L;

		
}
