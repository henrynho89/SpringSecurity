package org.diembo.base.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.diembo.base.utils.ByteUtils;
import org.diembo.entities.Persons;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "CONTRACT", 
	uniqueConstraints={
		@UniqueConstraint(name="U_CONTRACT_CODE__INST"		, columnNames={"CONTRACT_CODE"	, "INSTITUTION_ID"}), 
//		@UniqueConstraint(name="U_CONTRACT_MSISDN__INST"	, columnNames={"MSISDN"		  	, "INSTITUTION_ID"}),
//		@UniqueConstraint(name="AK_UI_ALPHA_CONTRACT"		, columnNames={"ALPHA"	  		, "INSTITUTION_ID"})
	}
)	
public class Contract extends GenericEntity {

	public static final int pl_NewlyCreated = 0;
	public static final int pl_WaitingForKeysSetInitialization 	=  10;
	public static final int pl_WaitingForKeysSetRegeneration 	=  20;
	public static final int pl_WaitingForValidationCodeEntry 	=  30;
	public static final int pl_SubscriptionCompleted 			= 100;

	
	public static final int rt_binaryResponse = 0;
    public static final int rt_textResponse = 1;

    
	@Override
	public Long getId() {
		return contract_id;
	}

	@Override
	public void setIdToNull() {
		this.contract_id = null;
	}

	@Column(name = "CONTRACT_ID", nullable = false)
	@TableGenerator(name = "MasterTokenGenerator", table = "TOKENSERIE", pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "MasterSerie")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MasterTokenGenerator")
	protected Long contract_id;

	public void setContract_id(Long value) {
		this.contract_id = value;
	}

	public Long getContract_id() {
		return this.contract_id;
	}

	

	@ManyToOne
	@JoinColumn(name="CUSTOMER_ID", foreignKey=@ForeignKey(name="FK_CONTRACT_CONTRACT__CUSTOMER"), nullable=false)
	protected Customer customer;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer value) {
		this.customer = value;
	}
	
	@Column(name = "CONTRACT_CODE", length=30, nullable = false)
	protected String contract_code;

	public void setContractCode(String value) {
		this.contract_code = value;
	}

	public String getContractCode() {
		return this.contract_code;
	}

	@Column(name = "DESCRIPTION", length=256)
	protected String description;

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return this.description;
	}

	@Column(name = "STARTTIME", nullable = false)
	protected Date startTime;

	public void setStartTime(Date value) {
		this.startTime = value;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	@Column(name = "ENDTIME", nullable = false)
	protected Date endTime;

	public void setEndTime(Date value) {
		this.endTime = value;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	
	@Column(name = "DONTDISTURBSTARTTIME", nullable = false)
	protected Date dontDisturbStartTime = new Date(0);	
	public void setDontDisturbStartTime(Date value) {
		this.dontDisturbStartTime = value;
	}
	public Date getDontDisturbStartTime() {
		return this.dontDisturbStartTime;
	}

	@Column(name = "DONTDISTURBENDTIME", nullable = false)
	protected Date dontDisturbEndTime = new Date(0);
	public void setDontDisturbEndTime(Date value) {
		this.dontDisturbEndTime = value;
	}
	public Date getDontDisturbEndTime() {
		return this.dontDisturbEndTime;
	}

	@Column(name = "MSISDN2", length=30)
	protected String msisdn2;

	public void setMsisdn2(String value) {
		this.msisdn2 = value;
	}

	public String getMsisdn2() {
		return this.msisdn2;
	}

	@Column(name = "MSISDN3", length=30)
	protected String msisdn3;

	public void setMsisdn3(String value) {
		this.msisdn3 = value;
	}

	public String getMsisdn3() {
		return this.msisdn3;
	}

	@Column(name = "MSISDN4", length=30)
	protected String msisdn4;

	public void setMsisdn4(String value) {
		this.msisdn4 = value;
	}

	public String getMsisdn4() {
		return this.msisdn4;
	}

	@Column(name = "MSISDN5", length=30)
	protected String msisdn5;

	public void setMsisdn5(String value) {
		this.msisdn5 = value;
	}

	public String getMsisdn5() {
		return this.msisdn5;
	}

	@Column(name = "BALANCE", nullable=false)
	protected Double balance = 0d;

	public void setBalance(Double value) {
		this.balance = value;
	}

	public Double getBalance() {
		return this.balance ; // == null ? 0d : this.balance;
	}

	@Column(name = "EXTRABALANCE", nullable=false)
	protected Double extraBalance = 0d;

	public void setExtraBalance(Double value) {
		this.extraBalance = value;
	}

	public Double getExtraBalance() {
		return this.extraBalance ; // == null ? 0d : this.extraBalance;
	}

	@Column(name = "LOYALTYBALANCE", nullable=false)
	protected Double loyaltyBalance = 0d;

	public void setLoyaltyBalance(Double value) {
		this.loyaltyBalance = value;
	}

	public Double getLoyaltyBalance() {
		return this.loyaltyBalance ; // == null ? 0d : this.loyaltyBalance ;
	}

	@Column(name = "PASSWORD", length=256)
	protected String password;
	public void setPassword(String value) {
		this.password = value;
	}
	public String getPassword() {
		return this.password;
	}

	
	@Column(name = "BETA", length=6)
	protected String beta;
	public void setBeta(String value) {
		this.beta = value;
	}
	public String getBeta() {
		return this.beta;
	}

	@Column(name = "BETATYPE", nullable=false)
	protected Integer betaType = 0;
	public void setBetaType(Integer value) {
		this.betaType = value;
	}
	public Integer getBetaType() {
		return this.betaType ; // == null ? 0 : this.betaType;
	}

	@Column(name = "BETAGENERATIONDATE")
	protected Date betaGenerationDate;

	public void setBetaGenerationDate(Date value) {
		this.betaGenerationDate = value;
	}
	
	public Date getBetaGenerationDate() {
		return this.betaGenerationDate;
	}

	@Column(name = "BETAEXPIRYDATE")
	protected Date betaExpiryDate;

	public void setBetaExpiryDate(Date value) {
		this.betaExpiryDate = value;
	}

	public Date getBetaExpiryDate() {
		return this.betaExpiryDate;
	}

	
	@Column(name = "SUSPICIOUSATTEMPT1TIME")
	protected Date suspiciousAttempt1Time;

	public Date getSuspiciousAttempt1Time() {
		return suspiciousAttempt1Time;
	}

	public void setSuspiciousAttempt1Time(Date suspiciousAttempt1Time) {
		this.suspiciousAttempt1Time = suspiciousAttempt1Time;
	}

	@Column(name = "SUSPICIOUSATTEMPT2TIME")
	protected Date suspiciousAttempt2Time;

	public Date getSuspiciousAttempt2Time() {
		return suspiciousAttempt2Time;
	}

	public void setSuspiciousAttempt2Time(Date suspiciousAttempt2Time) {
		this.suspiciousAttempt2Time = suspiciousAttempt2Time;
	}

	@Column(name = "SUSPICIOUSATTEMPT3TIME")
	protected Date suspiciousAttempt3Time;

	public Date getSuspiciousAttempt3Time() {
		return suspiciousAttempt3Time;
	}

	public void setSuspiciousAttempt3Time(Date suspiciousAttempt3Time) {
		this.suspiciousAttempt3Time = suspiciousAttempt3Time;
	}

	@Column(name = "SUSPICIOUSPASSWORDATTEMPT1TIME")
	protected Date suspiciousPasswordAttempt1Time;
	public Date getSuspiciousPasswordAttempt1Time() {
		return suspiciousPasswordAttempt1Time;
	}
	public void setSuspiciousPasswordAttempt1Time(Date suspiciousPasswordAttempt1Time) {
		this.suspiciousPasswordAttempt1Time = suspiciousPasswordAttempt1Time;
	}

	@Column(name = "SUSPICIOUSPASSWORDATTEMPT2TIME")
	protected Date suspiciousPasswordAttempt2Time;
	public Date getSuspiciousPasswordAttempt2Time() {
		return suspiciousPasswordAttempt2Time;
	}
	public void setSuspiciousPasswordAttempt2Time(Date suspiciousPasswordAttempt2Time) {
		this.suspiciousPasswordAttempt2Time = suspiciousPasswordAttempt2Time;
	}

	@Column(name = "SUSPICIOUSPASSWORDATTEMPT3TIME")
	protected Date suspiciousPasswordAttempt3Time;
	public Date getSuspiciousPasswordAttempt3Time() {
		return suspiciousPasswordAttempt3Time;
	}
	public void setSuspiciousPasswordAttempt3Time(Date suspiciousPasswordAttempt3Time) {
		this.suspiciousPasswordAttempt3Time = suspiciousPasswordAttempt3Time;
	}

	@Column(name = "HOLD", nullable = false)
	protected Boolean hold = false;

	public Boolean isHold() {
		return this.hold;
	}
	public Boolean getHold() {
		return this.hold;
	}
	public void setHold(Boolean value) {
		this.hold = value;
	}
	

	@Column(name = "TERMINATED", nullable = false)
	protected Boolean terminated = false;
	public Boolean isTerminated() {
		return this.terminated;
	}
	public void setTerminated(Boolean value) {
		this.terminated = value;
	}
	public Boolean getTerminated() {
		return this.terminated;
	}

	
	@Column(name = "TERMINATIONTIME")
	protected Date terminationTime;

	public void setTerminationTime(Date value) {
		this.terminationTime = value;
	}

	public Date getTerminationTime() {
		return this.terminationTime;
	}


	@Column(name = "PROGRESSLEVEL", nullable = false)
	protected Integer progressLevel = 0;

	public void setProgressLevel(Integer value) {
		this.progressLevel = value;
	}

	public Integer getProgressLevel() {
		return this.progressLevel;
	}

	public String getProgressLevelName() {
		switch (this.progressLevel) {
		
		case pl_NewlyCreated:
			return "Attente de validation";
		
		case pl_WaitingForKeysSetInitialization:
			return "Attente code d'activation (1)";

		case pl_WaitingForKeysSetRegeneration:
			return "Attente code d'activation (2)";

		case pl_WaitingForValidationCodeEntry:
			return "Attente Code de Validation";

		case pl_SubscriptionCompleted:
			return "Actif";

		default:
			return "<< Inconnu>>";
		}
	}

	@Column(name = "PINDIGEST", length=256)
	private String pinDigest;
	public void setPinDigest(String value) {
		this.pinDigest = value;
	}
	public String getPinDigest() {
		return this.pinDigest;
	}

	@Column(name = "DESKEY_1",length=600)
	private String deskey_1;
	public void setDeskey_1(String value) {
		this.deskey_1 = value;
	}
	public String getDeskey_1() {
		return this.deskey_1;
	}

	@Column(name = "DESKEY_2",length=600)
	private String deskey_2;
	public void setDeskey_2(String value) {
		this.deskey_2 = value;
	}
	public String getDeskey_2() {
		return this.deskey_2;
	}

	@Column(name = "DESKEY_3",length=600)
	private String deskey_3;
	public void setDeskey_3(String value) {
		this.deskey_3 = value;
	}
	public String getDeskey_3() {
		return this.deskey_3;
	}

	@Column(name = "DESKEY1EXPIRYDATE")
	private Date desKey1ExpiryDate ;
	public void setDesKey1ExpiryDate(Date value) {
		this.desKey1ExpiryDate = value;
	}
	public Date getDesKey1ExpiryDate() {
		return this.desKey1ExpiryDate;
	}

	@Column(name = "DESKEY2EXPIRYDATE")
	private Date desKey2ExpiryDate ;
	public void setDesKey2ExpiryDate(Date value) {
		this.desKey2ExpiryDate = value;
	}
	public Date getDesKey2ExpiryDate() {
		return this.desKey2ExpiryDate;
	}

	@Column(name = "DESKEY3EXPIRYDATE")
	private Date desKey3ExpiryDate ;
	public void setDesKey3ExpiryDate(Date value) {
		this.desKey3ExpiryDate = value;
	}
	public Date getDesKey3ExpiryDate() {
		return this.desKey3ExpiryDate;
	}

	@Column(name = "RSAPUBLICKEYMODULUS", length=600)
	protected String rsaPublicKeyModulus;

	public void setRsaPublicKeyModulus(String value) {
		this.rsaPublicKeyModulus = value;
	}

	public String getRsaPublicKeyModulus() {
		return rsaPublicKeyModulus;
	}

	@Column(name = "RSAPUBLICKEYEXPONENT", length=24)
	protected String rsaPublicKeyExponent;

	public void setRsaPublicKeyExponent(String value) {
		this.rsaPublicKeyExponent = value;
	}

	public String getRsaPublicKeyExponent() {
		return this.rsaPublicKeyExponent;
	}



	@Column(name = "LASTTRANSACTIONREQUEST_ID")
	protected Long lastTransactionRequestId;
	public Long getLastTransactionRequestId() {
		return lastTransactionRequestId;
	}
	public void setLastTransactionRequestId(Long lastTransactionRequestId) {
		this.lastTransactionRequestId = lastTransactionRequestId;
	}

	
	@Column(name = "LASTTRANSACTIONTIME")
	protected Date lastTransactionTime;

	public void setLastTransactionTime(Date value) {
		this.lastTransactionTime = value;
	}
	public Date getLastTransactionTime() {
		return this.lastTransactionTime;
	}


	@Column(name = "LASTTRANSACTIONRESPONSE",length=2048)
	protected String lastTransactionResponse;

	public String getLastTransactionResponse() {
		return lastTransactionResponse;
	}

	public void setLastTransactionResponse(String lastTransactionResponse) {
		this.lastTransactionResponse = lastTransactionResponse;
	}

	@Column(name = "LASTTRANSACTIONRESPONSETYPE")
	protected Integer lastTransactionResponseType;
	public Integer getLastTransactionResponseType() {
		return lastTransactionResponseType ; // == null ? 0 : lastTransactionResponseType;
	}
	public void setLastTransactionResponseType(Integer lastTransactionResponseType) {
		this.lastTransactionResponseType = lastTransactionResponseType;
	}

	
	@Column(name = "APPLICATIONOPTIONS", length=120)
	protected String applicationOptions;

	public void setApplicationOptions(String value) {
		this.applicationOptions = value;
	}

	public String getApplicationOptions() {
		return this.applicationOptions;
	}
	
	@Column(name = "PSEUDO", length=30)
	private String pseudo;
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	
	@ManyToOne
	@JoinColumn(name="MAINCONTRACT_ID", foreignKey=@ForeignKey(name="FK_CONTRACT_MAINCONTRACT"))
	protected Contract mainContract;
	public Contract getMainContract() {
		return mainContract;
	}
	public void setMainContract(Contract mainContract) {
		this.mainContract = mainContract;
	}
	

	@Transient
	@Deprecated
	private Persons contractOwner;
	public Persons getContractOwner() {
		return contractOwner;
	}
	public void setContractOwner(Persons contractOwner) {
		this.contractOwner = contractOwner;
	}


	@Column(name = "PASSWORDWINDOWEND")
	protected Date passwordWindowEnd;

	public void setPasswordWindowEnd(Date value) {
		this.passwordWindowEnd = value;
	}
	
	public Date getPasswordWindowEnd() {
		return this.passwordWindowEnd;
	}
	
	@Column(name = "SESSIONID")
	protected Long sessionId;

	public void setSessionId(Long value) {
		this.sessionId = value;
	}
	
	public Long getSessionId() {
		return this.sessionId;
	}

	@Column(name = "SESSIONSTARTTIME") 
	protected Date sessionStartTime;

	public void setSessionStartTime(Date value) {
		this.sessionStartTime = value;
	}
	public Date getSessionStartTime() {
		return this.sessionStartTime;
	}

	@Column(name = "SESSIONTOKEN")
	protected Long sessionToken;

	public void setSessionToken(Long value) {
		this.sessionToken = value;
	}
	
	public Long getSessionToken() {
		return this.sessionToken;
	}

	@Column(name = "MSISDN", length=30)
	protected String msisdn;
	public void setMsisdn(String value) {
		this.msisdn = value;
	}
	public String getMsisdn() {
		return this.msisdn;
	}	
	
	// -------------------------------------------------------
	// Deprecated: This is kept here only for Mobserve use
	// -------------------------------------------------------
	@Column(name = "ALPHA", length=60)
	@Deprecated
	private String alpha;
	@Deprecated
	public void setAlpha(String value) {
		this.alpha = value;
	}
	@Deprecated
	public String getAlpha() {
		return this.alpha;
	} 
	// -------------------------------------------------------

	
	//-------------------------------------------------
	public void setContractLastResponse(TransactionRequest transactionRequest, Byte[] encryptedMessageDES) {
		setContractLastResponse(transactionRequest, ByteUtils.bytesToHexString(encryptedMessageDES), 0);
	}
	public void setContractLastResponse(TransactionRequest transactionRequest, String message) {
		setContractLastResponse(transactionRequest, message, 1);
	}
	private void setContractLastResponse(TransactionRequest transactionRequest, String lastResponse, int type) {
		if (lastResponse != null && lastResponse.length() > 2048) {
			lastResponse = "";
		}
		this.setLastTransactionRequestId(transactionRequest.getId());
		this.setLastTransactionTime(transactionRequest.getTransactionRequestServerDate());
		this.setLastTransactionResponse(lastResponse);
		this.setLastTransactionResponseType(type);
	}

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_CONTRACT__INST"), nullable=false)
	private Institution institution;
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	

	@Transient
	private List<Service> services;
	public List<Service> getServices() {
		return services;
	}
	public void setServices(List<Service> services) {
		this.services = services;
	}
	

	@ManyToOne
	@JoinColumn(name="CREATED_BY", foreignKey=@ForeignKey(name="FK_CONTRACT__PERSON"), nullable=true)
	protected Persons createdBy;
	public Persons getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Persons createdBy) {
		this.createdBy = createdBy;
	}
	
	
	@ManyToOne
	@JoinColumn(name="TERMINATED_BY", foreignKey=@ForeignKey(name="FK_CONTRACT__TERMINATED_BY"), nullable=true)
	protected Persons terminatedBy;
	public Persons getTerminatedBy() {
		return terminatedBy;
	}
	public void setTerminatedBy(Persons terminatedBy) {
		this.terminatedBy = terminatedBy;
	}

	@Transient
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	private static final long serialVersionUID = 1L;

}
