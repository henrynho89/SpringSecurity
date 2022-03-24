package org.diembo.base.utils;

import java.util.Date;

public class TransactionEntity {
	public static final byte defaultLanguage = 2;
	public static final int beneficiaryName1Length = 24;

	private byte freeByte1 = 0;
	private byte freeByte2 = 0;
	private byte languageIndex;
	private Date transactionDate;
	private byte service;
	private String merchantCode;
	private Double amount;
	private Double feesAmount;
	private String beta;
	private String contractBeta;

	// private String payerMSISDN;
	private String beneficiaryId;
	private byte beneficiaryIdTypeId;
	private String beneficiaryName;
	private String beneficiaryMSISDN;
	private String beneficiaryAccountNumber;
	private String merchantServiceCode;
	private String billContractNumber;
	private String billNumber;
	private String billSecretCode;
	private String customerKey;
	private byte[] pinDigest;
	private byte[] sessionKey;
	private String aliasCode;

	public TransactionEntity(byte service, String aliasCode) {
		this.service = service;
		this.transactionDate = new Date();
		this.aliasCode = aliasCode;
		this.languageIndex = defaultLanguage;
		this.amount = 0d;
	}


	public String getBeneficiaryName1() {
		String name1 = beneficiaryName;
		if (beneficiaryName.length() > beneficiaryName1Length) {
			name1 = beneficiaryName.substring(0, beneficiaryName1Length);
		}
		return name1;
	}

	public String getBeneficiaryName2() {
		String name2 = "";
		if (beneficiaryName.length() > beneficiaryName1Length) {
			name2 = beneficiaryName.substring(beneficiaryName1Length);
		}
		return name2;
	}

	public byte getFreeByte1() {
		return freeByte1;
	}

	public void setFreeByte1(byte freeByte1) {
		this.freeByte1 = freeByte1;
	}

	public byte getFreeByte2() {
		return freeByte2;
	}

	public void setFreeByte2(byte freeByte2) {
		this.freeByte2 = freeByte2;
	}

	public byte getLanguageIndex() {
		return languageIndex;
	}

	public void setLanguageIndex(byte languageIndex) {
		this.languageIndex = languageIndex;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public byte getService() {
		return service;
	}

	public void setService(byte service) {
		this.service = service;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getFeesAmount() {
		return feesAmount;
	}
	public void setFeesAmount(Double feesAmount) {
		this.feesAmount = feesAmount;
	}

	public String getBeta() {
		return beta;
	}

	public void setBeta(String beta) {
		this.beta = beta;
	}

	public String getContractBeta() {
		return contractBeta;
	}

	public void setContractBeta(String contractBeta) {
		this.contractBeta = contractBeta;
	}

	public String getBeneficiaryId() {
		return beneficiaryId;
	}

	public void setBeneficiaryId(String beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}

	public byte getBeneficiaryIdTypeId() {
		return beneficiaryIdTypeId;
	}

	public void setBeneficiaryIdTypeId(byte beneficiaryIdTypeId) {
		this.beneficiaryIdTypeId = beneficiaryIdTypeId;
	}

	public String getBeneficiaryName() {
		return beneficiaryName;
	}

	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}

	public String getBeneficiaryMSISDN() {
		return beneficiaryMSISDN;
	}

	public void setBeneficiaryMSISDN(String beneficiaryMSISDN) {
		this.beneficiaryMSISDN = beneficiaryMSISDN;
	}

	public String getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}


	public String getMerchantServiceCode() {
		return merchantServiceCode;
	}
	public void setMerchantServiceCode(String merchantServiceCode) {
		this.merchantServiceCode = merchantServiceCode;
	}
	
	public String getBillContractNumber() {
		return billContractNumber;
	}
	public void setBillContractNumber(String merchantAccountReference) {
		this.billContractNumber = merchantAccountReference;
	}

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}


	public String getBillSecretCode() {
		return billSecretCode;
	}

	public void setBillSecretCode(String billSecretCode) {
		this.billSecretCode = billSecretCode;
	}

	
	public String getCustomerKey() {
		return customerKey;
	}

	public void setCustomerKey(String customerKey) {
		this.customerKey = customerKey;
	}

	public byte[] getPinDigest() {
		return pinDigest;
	}

	public void setPinDigest(byte[] pinDigest) {
		this.pinDigest = pinDigest;
	}

	public byte[] getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(byte[] sessionKey) {
		this.sessionKey = sessionKey;
	}

	public String getAliasCode() {
		return aliasCode;
	}

	public void setAliasCode(String aliasCode) {
		this.aliasCode = aliasCode;
	}
}
