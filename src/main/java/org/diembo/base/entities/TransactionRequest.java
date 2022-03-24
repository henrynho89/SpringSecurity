package org.diembo.base.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name = "TRANSACTIONREQUEST")
public class TransactionRequest extends GenericEntity {
	private static final long serialVersionUID = 1L;

	public static final Long plNew						=    0L;
	public static final Long plInProgress				=   50L;
	public static final Long plDone						=  100L;
	
	public static final Long plInProgressOnReversal 	= -190L;
	public static final Long plDoneOnReversal 			= -201L; //  110L; // -201L; (XFS)
	
	public static final Long plFailed					= -100L;
	public static final Long plFailedOnReversal 		= -101L; 
	public static final Long plFailedOnConfirmation 	= -102L; 
		
	public static final Long plUnkown					=  -50L;
	public static final Long plUnkownOnReversal			=  -151L; //-51L; // -151L; (XFS)
	public static final Long plUnkownOnConfirmation		=  -52L;
	
	public static final String backEnd_plDone 			=  "100";
	public static final String backEnd_plInProgress		=  "50";
	public static final String backEnd_plUnknownStatus 	=  "-50";
	public static final String backEnd_plFailed 		=  "-100";
	
	
	public static final String backEnd_plDoneOnReversal     		=  "-201";
	public static final String backEnd_plUnkownOnReversal     		=  "-151";
	
	public static final String backEnd_plDoneOnManualReconciliation	=  "110";
	public static final String backEnd_plFailedOnManualReconciliation=  "-110";
	
	public static final String backEnd_plCleared                      =  "200";
	public static final String backEnd_plRefunded                     =  "300";
	public static final String backEnd_plExpired                      =  "-300";
	
	
//	public static final Long plCleared					=  200L;
//	public static final Long plRefunded					=  300L;
//	public static final Long plCancelled				= -200L;
//	public static final Long plExpired					= -300L;
	
	
	@Override
	public Long getId() {
		return getTransactionRequest_id();
	}

	@Override
	public void setIdToNull() {
		// transactionRequestId doesn't need and should never be modified
	}

	@Column(name = "TRANSACTIONREQUEST_ID", nullable = false)
	@TableGenerator(name = "MasterTokenGenerator", table = "TOKENSERIE", pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "MasterSerie")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MasterTokenGenerator")
	protected Long transactionRequest_id;

	public void setTransactionRequest_id(Long value) {
		this.transactionRequest_id = value;
	}

	public Long getTransactionRequest_id() {
		return this.transactionRequest_id;
	}

	public Long getTransactionRequestId() {
		return getTransactionRequest_id();
	}
	
	@ManyToOne
	@JoinColumn(name = "CURRENCY_ID", foreignKey=@ForeignKey(name="FK_TRANSACT_REQ__CURRENCY"))
	private Currency		currency		;
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Long getCurrencyId() {
		return this.currency == null ? null : this.currency.getCurrency_id();
	}
	
	public void setCurrencyId(Long currencyId) {
		if (this.currency == null) {
			this.currency = new Currency(); 
		}
		currency.setCurrency_id(currencyId);;
	}

	@Column(name = "PRODUCT_AMOUNT", nullable = false)
	private Double productAmount;
	
	public Double getProductAmount() {
		return productAmount == null ? 0d : productAmount;
	}

	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
	}

	@ManyToOne
	@JoinColumn(name = "SERVICE_ID", foreignKey=@ForeignKey(name="FK_TRANSACT_TR_TRANST_SERVICE"), nullable=false)
	protected Service service;

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Long getServiceIdentifier() {
		return service == null ? null : service.getIdentifier();
	}

	public void setServiceIdentifier(Long serviceIdentifier) {
		if ( service == null ) {
			service = new Service();
		}
		service.setIdentifier(serviceIdentifier);
	}

	public Long getServiceId() {
		return this.service == null ? null : this.service.getService_id();
	}
	
	public void setServiceId(Long serviceId) {
		if (this.service == null) {
			this.service = new Service(); 
		}
		service.setService_id(serviceId);
	}

	@Deprecated
	public Long getService_id() {
		return getServiceId();
	}
	
	@Deprecated
	public void setService_id(Long serviceId) {
		setServiceId(serviceId);
	}

	@ManyToOne
	@JoinColumn(name = "SERVICEGROUP_ID", foreignKey=@ForeignKey(name="FK_TRANSACT_TR_TRANSC_SERVICEG"))
	protected ServiceGroup serviceGroup;

	public void setServiceGroup(ServiceGroup serviceGroup) {
		this.serviceGroup = serviceGroup;
	}

	public ServiceGroup getServiceGroup() {
		return this.serviceGroup;
	}

	public Long getServiceGroupId() {
		return this.serviceGroup == null ? null : this.serviceGroup.getServiceGroup_id();
	}

	public void setServiceGroupId(Long serviceGroupId) {
		if (this.serviceGroup == null) {
			this.serviceGroup = new ServiceGroup(); 
		}
		serviceGroup.setServiceGroup_id(serviceGroupId);
	}

	@Deprecated
	public Long getServiceGroup_id() {
		return getServiceGroupId();
	}

	@Deprecated
	public void setServiceGroup_id(Long serviceGroupId) {
		setServiceGroupId(serviceGroupId);
	}
	
	
	@ManyToOne
	@JoinColumn(name = "CONTRACT_ID", foreignKey=@ForeignKey(name="FK_TRANSACT_TR_CONTRA_CONTRACT"), nullable=false)
	protected Contract contract;

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Long getContractId() {
		return this.contract == null ? null : this.contract.getContract_id();
	}
	
	public void setContractId(Long contractId) {
		if (this.contract == null) {
			this.contract = new Contract(); 
		}
		contract.setContract_id(contractId);
	}
	
	@Column(name = "CANCELED", nullable = false)
	protected Long canceled = 0L;
	public void setCanceled(Long value) {
		this.canceled = value;
	}
	public Long getCanceled() {
		return this.canceled;
	}
	
//	public void setCanceled(boolean value) {
//		if (value) {
//			this.canceled = 1L;
//		} else {
//			this.canceled = 0L;
//		}
//	}
//
//	public boolean getCanceled() {
//		return (this.canceled == 1L);
//	}


	@ManyToOne
	@JoinColumn(name = "CHANNEL_ID", foreignKey=@ForeignKey(name="FK_TRANSACT_TR_CHANNE_CHANNEL"), nullable=false)
	public Channel channel;
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Long getChannelId() {
		return channel == null ? null : channel.getId();
	}
	public void setChannelId(Long channelId) {
		if ( channel == null ) {
			channel = new Channel();
		}
		channel.setChannel_id(channelId);
	}

	@ManyToOne
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_TRANSACT_TR_INSTIT_INSTITUT"), nullable=false)
	protected Institution institution;

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Institution getInstitution() {
		return this.institution;
	}

	public Long getInstitutionId() {
		return this.institution == null ? null : this.institution.getInstitution_id();
	}

	public void setInstitutionId(Long institutionId) {
		if (this.institution == null) {
			this.institution = new Institution(); 
		}
		institution.setInstitution_id(institutionId);
	}

	@Deprecated
	public Long getInstitution_id() {
		return getInstitutionId();
	}

	@Deprecated
	public void setInstitution_id(Long institutionId) {
		setInstitutionId(institutionId);
	}

	@Column(name = "APPLICATIONRELEASE")
	protected Long applicationRelease;

	public void setApplicationRelease(Long value) {
		this.applicationRelease = value;
	}

	public Long getApplicationRelease() {
		return this.applicationRelease;
	}

	@Column(name = "TRANSACTIONREQUESTDATE", nullable = false)@Temporal(TemporalType.TIMESTAMP)
	protected java.util.Date transactionRequestDate;

	public void setTransactionRequestDate(java.util.Date value) {
		this.transactionRequestDate = value;
	}

	public java.util.Date getTransactionRequestDate() {
		return this.transactionRequestDate;
	}

	@Column(name = "TRANSACTIONREQUESTSERVERDATE", nullable = false)@Temporal(TemporalType.TIMESTAMP)
	protected java.util.Date transactionRequestServerDate;

	public void setTransactionRequestServerDate(java.util.Date value) {
		this.transactionRequestServerDate = value;
	}

	public java.util.Date getTransactionRequestServerDate() {
		return this.transactionRequestServerDate;
	}

	@Column(name = "PAYERMSISDN", length=20, nullable = false)
	protected String payerMsisdn;

	public void setPayerMsisdn(String value) {
		this.payerMsisdn = value;
	}

	public String getPayerMsisdn() {
		return this.payerMsisdn;
	}

	@Column(name = "AMOUNT", nullable = false)
	protected Double amount;
	public void setAmount(Double value) {
		this.amount = value;
	}
	public Double getAmount() {
		return amount == null ? 0d : amount;
	}

	@Column(name = "PAYERFEES", nullable = false)
	protected Double payerFees;
	public void setPayerFees(Double value) {
		this.payerFees = value;
	}
	public Double getPayerFees() {
		return payerFees == null ? 0d : payerFees;
	}

	@Column(name = "PAYERCONNECTIONFEES", nullable = false)
	protected Double payerConnectionFees;
	public void setPayerConnectionFees(Double value) {
		this.payerConnectionFees = value;
	}
	public Double getPayerConnectionFees() {
		return payerConnectionFees == null ? 0d : payerConnectionFees;
	}

	@Column(name = "PAYERVALUEDATE", nullable = false)@Temporal(TemporalType.TIMESTAMP)
	protected Date payerValueDate;

	public void setPayerValueDate(Date value) {
		this.payerValueDate = value;
	}

	public Date getPayerValueDate() {
		return this.payerValueDate;
	}

	@Column(name = "PAYEEFEES", nullable = false)
	protected Double payeeFees;
	public void setPayeeFees(Double value) {
		this.payeeFees = value;
	}
	public Double getPayeeFees() {
		return payeeFees == null ? 0d : payeeFees;
	}

	@Column(name = "PAYEECONNECTIONFEES", nullable = false)
	protected Double payeeConnectionFees;
	public void setPayeeConnectionFees(Double value) {
		this.payeeConnectionFees = value;
	}
	public Double getPayeeConnectionFees() {
		return payeeConnectionFees == null ? 0d : payeeConnectionFees;
	}

	@Column(name = "PAYEEVALUEDATE", nullable = false)@Temporal(TemporalType.TIMESTAMP)
	protected Date payeeValueDate;
	public void setPayeeValueDate(Date value) {
		this.payeeValueDate = value;
	}
	public Date getPayeeValueDate() {
		return this.payeeValueDate;
	}


	@Column(name = "PAYERFEESVAT", nullable = false)
	protected Double payerFeesVat;
	public void setPayerFeesVat(Double value) {
		this.payerFeesVat = value;
	}
	public Double getPayerFeesVat() {
		return payerFeesVat == null ? 0d : payerFeesVat;
	}

	@Column(name = "PAYERCONNECTIONFEESVAT", nullable = false)
	protected Double payerConnectionFeesVat;
	public void setPayerConnectionFeesVat(Double value) {
		this.payerConnectionFeesVat = value;
	}
	public Double getPayerConnectionFeesVat() {
		return payerConnectionFeesVat == null ? 0d : payerConnectionFeesVat;
	}

	@Column(name = "PAYEEFEESVAT", nullable = false)
	protected Double payeeFeesVat;
	public void setPayeeFeesVat(Double value) {
		this.payeeFeesVat = value;
	}
	public Double getPayeeFeesVat() {
		return payeeFeesVat == null ? 0d : payeeFeesVat;
	}

	@Column(name = "PAYEECONNECTIONFEESVAT", nullable = false)
	protected Double payeeConnectionFeesVat;
	public void setPayeeConnectionFeesVat(Double value) {
		this.payeeConnectionFeesVat = value;
	}
	public Double getPayeeConnectionFeesVat() {
		return payeeConnectionFeesVat == null ? 0d : payeeConnectionFeesVat;
	}

	@Column(name = "FEESPAYMENTMODE", nullable = false)
	protected Integer feesPaymentMode;

	public void setFeesPaymentMode(Integer value) {
		this.feesPaymentMode = value;
	}

	public Integer getFeesPaymentMode() {
		return this.feesPaymentMode;
	}
	
	
	@Column(name = "USER_COMMISSION", nullable = false)
	protected Double userCommission;
	public void setUserCommission(Double value) {
		this.userCommission = value;
	}
	public Double getUserCommission() {
		return userCommission == null ? 0d : userCommission;
	}
	
	
	@Column(name = "USER_COMMISSION_VAT", nullable = false)
	protected Double userCommissionVat;
	public void setUserCommissionVat(Double value) {
		this.userCommissionVat = value;
	}
	public Double getUserCommissionVat() {
		return userCommissionVat == null ? 0d : userCommissionVat;
	}
	
	
	@Column(name = "LOYALTYGAINS", nullable = false)
	protected Double loyaltyGains;
	public void setLoyaltyGains(Double value) {
		this.loyaltyGains = value;
	}
	public Double getLoyaltyGains() {
		return loyaltyGains == null ? 0d : loyaltyGains;
	}

	@Column(name = "BENEFICIARY_ID", length=30)
	protected String beneficiaryId;

	public void setBeneficiaryId(String value) {
		this.beneficiaryId = value;
	}

	public String getBeneficiaryId() {
		return this.beneficiaryId;
	}

	@Column(name = "BENEFICIARYIDTYPE_ID")
	protected Long beneficiaryIdTypeId;

	public void setBeneficiaryIdTypeId(Long value) {
		this.beneficiaryIdTypeId = value;
	}

	public Long getBeneficiaryIdTypeId() {
		return this.beneficiaryIdTypeId;
	}

	@Column(name = "BENEFICIARYNAME", length=140)
	protected String beneficiaryName;

	public void setBeneficiaryName(String value) {
		this.beneficiaryName = value;
	}

	public String getBeneficiaryName() {
		return this.beneficiaryName;
	}

	@Column(name = "BENEFICIARYMSISDN", length=20)
	protected String beneficiaryMsisdn;

	public void setBeneficiaryMsisdn(String value) {
		this.beneficiaryMsisdn = value;
	}

	public String getBeneficiaryMsisdn() {
		return this.beneficiaryMsisdn;
	}

	@Column(name = "BENEFICIARYACCOUNTNUMBER", length=34)
	protected String beneficiaryAccountNumber;

	public void setBeneficiaryAccountNumber(String value) {
		this.beneficiaryAccountNumber = value;
	}

	public String getBeneficiaryAccountNumber() {
		return this.beneficiaryAccountNumber;
	}

	@Column(name = "CUSTOMERKEY", length=30)
	protected String customerKey;

	public void setCustomerKey(String value) {
		this.customerKey = value;
	}

	public String getCustomerKey() {
		return this.customerKey;
	}

	@Transient
	protected String pinDigest;
	public void setPinDigest(String value) {
		this.pinDigest = value;
	}
	public String getPinDigest() {
		return this.pinDigest;
	}

	@Transient
	protected String sessionKey;
	public void setSessionKey(String value) {
		this.sessionKey = value;
	}
	public String getSessionKey() {
		return this.sessionKey;
	}
	

	@Column(name = "MERCHANTSERVICECODE", length=4)
	protected String merchantServiceCode;
	public String getMerchantServiceCode() {
		return merchantServiceCode;
	}
	public void setMerchantServiceCode(String merchantServiceCode) {
		this.merchantServiceCode = merchantServiceCode;
	}
	
	@Column(name = "BILLCONTRACTNUMBER", length=30)
	protected String billContractNumber;

	public void setBillContractNumber(String value) {
		this.billContractNumber = value;
	}

	public String getBillContractNumber() {
		return this.billContractNumber;
	}

	@Column(name = "BILLSECRETCODE", length=10)
	protected String billSecretCode;

	public void setBillSecretCode(String billSecretCode) {
		this.billSecretCode = billSecretCode;
	}

	public String getBillSecretCode() {
		return this.billSecretCode;
	}

	
	@Column(name = "BILLNUMBER", length=140)
	protected String billNumber;

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public String getBillNumber() {
		return this.billNumber;
	}

	
	@Column(name = "PROGRESSLEVEL", nullable = false)
	protected Long progressLevel;
	public void setProgressLevel(Long value) {
		this.progressLevel = value;
	}
	public Long getProgressLevel() {
		return this.progressLevel;
	}

	
	@Column(name = "RELATEDTRANSACTIONREQUEST_ID")
	protected Long relatedTransactionRequest_id;
	public void setRelatedTransactionRequest_id(Long value) {
		this.relatedTransactionRequest_id = value;
	}
	public Long getRelatedTransactionRequest_id() {
		return this.relatedTransactionRequest_id;
	}


	@Column(name = "LANGUAGEINDEX", nullable = false)
	protected Byte languageIndex;

	public void setLanguageIndex(Byte value) {
		this.languageIndex = value;
	}

	public Byte getLanguageIndex() {
		return this.languageIndex;
	}

	@Column(name = "ORIGINALMESSAGE" , length=300, nullable=false)
	protected String originalMessage;
	public void setOriginalMessage(String value) {
		this.originalMessage = value;
	}
	public String getOriginalMessage() {
		return this.originalMessage ;
	}
//	public void setOriginalMessage(byte[] value) {
//		this.originalMessage = ByteUtils.bytesToHexString(value);
//	}
//	public byte[] getOriginalMessageAsByteArray() {
//		return this.originalMessage == null ? null : ByteUtils.hexStringToBytes(this.originalMessage);
//	}

	@Column(name = "QUERYSTRING_ID", nullable = false)
	protected Long queryString_id;

	public void setQueryString_id(Long value) {
		this.queryString_id = value;
	}

	public Long getQueryString_id() {
		return this.queryString_id;
	}

	@Column(name = "LOGIN", length=30, nullable = false)
	protected String login;

	public void setLogin(String value) {
		this.login = value;
	}

	public String getLogin() {
		return this.login;
	}

	@Column(name = "ERRORCODE", length=30)
	protected String errorCode;

	public void setErrorCode(String value) {
		this.errorCode = value;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

	@Column(name = "ERRORMESSAGE", length=256)
	protected String errorMessage;

	public void setErrorMessage(String value) {
		if (value == null) {
			this.errorMessage = null;
			return;
		}

		int lMax = 255;
		if (value.length() < lMax) {
			lMax = value.length();
		}

		this.errorMessage = value.substring(0, lMax);
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	@Column(name = "ROLLBACK_ERRORMESSAGE", length=256)
	protected String rollback_errormessage;

	public void setRollback_errormessage(String value) {
		this.rollback_errormessage = value;
	}

	public String getRollback_errormessage() {
		return this.rollback_errormessage;
	}

	@Column(name = "ROLLBACK_ERRORNUMBER")
	protected Long rollback_errornumber;

	public void setRollback_errornumber(Long value) {
		this.rollback_errornumber = value;
	}

	public Long getRollback_errornumber() {
		return this.rollback_errornumber;
	}

	
	@Column(name = "BACKEND_TRANSACTIONNUMBER", length=140)
	protected String backendTransactionNumber;
	public String getBackendTransactionNumber() {
		return backendTransactionNumber;
	}
	public void setBackendTransactionNumber(String backendTransactionNumber) {
		this.backendTransactionNumber = backendTransactionNumber;
	}
	
	@Column(name = "BACKEND_AUTHORISATIONNUMBER", length=140)
	protected String backEndAuthorisationNumber;
	public String getBackEndAuthorisationNumber() {
		return backEndAuthorisationNumber;
	}
	public void setBackEndAuthorisationNumber(String backEndAuthorisationNumber) {
		this.backEndAuthorisationNumber = backEndAuthorisationNumber;
	}


	@Column(name = "BACKEND_PROGRESSLEVEL", length=30)
	protected String backEndProgressLevel;
	public String getBackEndProgressLevel() {
		return backEndProgressLevel;
	}
	public void setBackEndProgressLevel(String backEndProgressLevel) {
		this.backEndProgressLevel = backEndProgressLevel;
	}

	@Column(name = "BACKEND_ERRORMESSAGE", length=256)
	protected String backEndErrorMessage;
	public String getBackEndErrorMessage() {
		return backEndErrorMessage;
	}
	public void setBackEndErrorMessage(String backEndErrorMessage) {
		this.backEndErrorMessage = backEndErrorMessage;
	}

	@Column(name = "BACKEND_ERRORNUMBER", length=30)
	protected String backEndErrorNumber;	
	public String getBackEndErrorNumber() {
		return backEndErrorNumber;
	}

	public void setBackEndErrorNumber(String backEndErrorNumber) {
		this.backEndErrorNumber = backEndErrorNumber;
	}
	
	
	@Column(name = "BACKEND_ARC", length=30)
	protected String backendArc;
	public String getBackendArc() {
		return backendArc;
	}
	public void setBackendArc(String backendArc) {
		this.backendArc = backendArc;
	}
	
	@Column(name = "BACKEND_TRC", length=30)
	protected String backendTrc;
	public String getBackendTrc() {
		return backendTrc;
	}
	public void setBackendTrc(String backendTrc) {
		this.backendTrc = backendTrc;
	}
	
	@Column(name = "BACKEND_ASYS", length=30)
	protected String backendASys;
	public String getBackendASys() {
		return backendASys;
	}
	public void setBackendASys(String backendASys) {
		this.backendASys = backendASys;
	}
	
	@Column(name = "BACKEND_TSYS", length=30)
	protected String backendTSys;
	public String getBackendTSys() {
		return backendTSys;
	}
	public void setBackendTSys(String backendTSys) {
		this.backendTSys = backendTSys;
	}
	
	
	// BackEnd authorization fees: any fees that is applied to the transaction
	// by the BackEnd at authorization time in addition to those managed by
	// SaphirMFS.
	@Column(name = "BACKEND_AUTHORIZATIONFEES", nullable = true)
	protected Double backendAuthorizationFees;
	public void setBackendAuthorizationFees(Double value) {
		this.backendAuthorizationFees = value;
	}
	public Double getBackendAuthorizationFees() {
		return backendAuthorizationFees == null ? 0d : backendAuthorizationFees;
	}

	// BackEnd authorization fees: any fees that is applied to the transaction
	// by the BackEnd at transaction time in addition to those managed by
	// SaphirMFS.
	@Column(name = "BACKEND_TRANSACTIONFEES", nullable = true)
	protected Double backendTransactionFees;
	public void setBackendTransactionFees(Double value) {
		this.backendTransactionFees = value;
	}
	public Double getBackendTransactionFees() {
		return backendTransactionFees == null ? 0d : backendTransactionFees;
	}

	public double getTotalPayerFees() {
//		double totalPayerFees = (this.getPayerFees() * (1 + this
//				.getPayerFeesVat()))
//				+ (this.getPayerConnectionFees() * (1 + this
//						.getPayerConnectionFeesVat()));
		double totalPayerFees =
				this.getPayerFees() + this.getPayerFeesVat() + 
				this.getPayerConnectionFees() + this.getPayerConnectionFeesVat();
		return totalPayerFees;
	}
	
	public double getTotalPayeeFees() {
//		double totalPayeeFees = (this.getPayeeFees() * (1 + this
//				.getPayeeFeesVat()))
//				+ (this.getPayeeConnectionFees() * (1 + this
//						.getPayeeConnectionFeesVat()));
		double totalPayeeFees =
				this.getPayeeFees() + this.getPayeeFeesVat() + 
				this.getPayeeConnectionFees() + this.getPayeeConnectionFeesVat();
		return totalPayeeFees;
	}
	
	public double getTotalUserCommission() {
		double totalUserCommission =
				this.getUserCommission() + this.getUserCommissionVat();
		return totalUserCommission;
	}
	
	@Transient
	private String merchantCode;
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	
	@Transient
	private String merchantName;
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	
	/*
	 * 
	 @Column(name = "ALIASCODE", length=5, nullable = false)
	protected String aliasCode;
	public void setAliasCode(String value) {
		this.aliasCode = value;
	}

	public String getAliasCode() {
		return this.aliasCode;
	}
	
		*/
	
	
	
	// --------------------------------------------------------------------------------
	// FOR BRED USE     O N L Y
	// --------------------------------------------------------------------------------
	@Column(name = "WALLETITEMNUMBER", length=30, nullable = false)
	@Deprecated
	private String walletItemNumber;
	public String getWalletItemNumber() {
		return walletItemNumber;
	}
	public void setWalletItemNumber(String walletItemNumber) {
		this.walletItemNumber = walletItemNumber;
	}	
	// --------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------

	
	
	
	@Transient
	private Branch branch;
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Branch getBranch() {
		return branch;
	}
	
	
	
	@ManyToOne
	@JoinColumn(name = "DEBIT_ACCOUNT_ID", foreignKey=@ForeignKey(name="FK_TRANSACT_ACCOUNT_DEBIT"), nullable=false)
	protected Account debitAccount;
	public Account getDebitAccount() {
		return debitAccount;
	}
	public void setDebitAccount (Account debitAccount) {
		this.debitAccount = debitAccount;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "CREDIT_ACCOUNT_ID", foreignKey=@ForeignKey(name="FK_TRANSACT_ACCOUNT_CREDIT"))
	protected Account creditAccount;
	public Account getCreditAccount() {
		return creditAccount;
	}
	public void setCreditAccount (Account creditAccount) {
		this.creditAccount = creditAccount;
	}
	
	@ManyToOne
	@JoinColumn(name = "FEES_ACCOUNT_ID", foreignKey=@ForeignKey(name="FK_TRANSACT_ACCOUNT_FEES"))
	protected Account feesAccount;
	public Account getFeesAccount() {
		return feesAccount;
	}
	public void setFeesAccount (Account feesAccount) {
		this.feesAccount = feesAccount;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "COMMISSION_ACCOUNT_ID", foreignKey=@ForeignKey(name="FK_TRANSACT_ACCOUNT_COMMISSION"))
	protected Account commissionAccount;
	public Account getCommissionAccount() {
		return commissionAccount;
	}
	public void setCommissionAccount (Account commissionAccount) {
		this.commissionAccount = commissionAccount;
	}
	
	
	/*
	@Transient
	protected Long lisId;
	public Long getLisId() {
		return this.lisId;
	}
	public void setLisId(Long lisId) {
		this.lisId = lisId;
	}


	@Transient
	protected String lisFileName;
	public String getLisFileName() {
		return this.lisFileName;
	}
	public void setLisFileName(String lisFileName) {
		this.lisFileName = lisFileName;
	}


	
	@Transient
	protected Double lisAmount;
	public Double getLisAmount() {
		return this.lisAmount;
	}
	public void setLisAmount(Double lisAmount) {
		this.lisAmount = lisAmount;
	}

	
	@Transient
	protected String lisArn;
	public String getLisArn() {
		return this.lisArn;
	}
	public void setLisArn(String lisArn) {
		this.lisArn = lisArn;
	}

	
	
	@Transient
	protected String lisRrn;
	public String getLisRrn() {
		return this.lisRrn;
	}
	public void setLisRrn(String lisRrn) {
		this.lisRrn = lisRrn;
	}

	
	
	@Transient
	protected Date lisReconciliationDate;
	public Date getLisReconciliationDate() {
		return lisReconciliationDate;
	}
	public void setLisReconciliationDate(Date lisReconciliationDate) {
		this.lisReconciliationDate = lisReconciliationDate;
	}

*/
	@Transient
	protected Long setLisFilesCount;
	public Long getLisFilesCount() {
		return this.setLisFilesCount;
	}
	public void setLisFilesCount(Long setLisFilesCount) {
		this.setLisFilesCount = setLisFilesCount;
	}

  	
	@Transient
	protected Long wonDisputes;
	public Long getWonDisputes() {
		return this.wonDisputes;
	}
	public void setWonDisputes(Long wonDisputes) {
		this.wonDisputes = wonDisputes;
	}

	
	
	
	@Transient
	protected Long lostDisputes;
	public Long getLostDisputes() {
		return lostDisputes;
	}
	public void setLostDisputes(Long lostDisputes) {
		this.lostDisputes = lostDisputes;
	}
  	
  	
	@Transient
	protected Long pendingDisputes;
	public Long getPendingDisputes() {
		return pendingDisputes;
	}
	public void setPendingDisputes(Long pendingDisputes) {
		this.pendingDisputes = pendingDisputes;
	}
  	
	    

/*	@Transient
	private ContractWalletItem contractWalletItem;
	public void setContractWalletItem(ContractWalletItem contractWalletItem) {
		this.contractWalletItem = contractWalletItem;
	}
	public ContractWalletItem getContractWalletItem() {
		return contractWalletItem;
	}
*/
}
