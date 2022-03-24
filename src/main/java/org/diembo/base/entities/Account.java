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
import javax.persistence.UniqueConstraint;

@Entity
@Table(
	name = "ACCOUNT", 
	uniqueConstraints={
			@UniqueConstraint(name="U_ACCOUNT__BBAN", columnNames={"INSTITUTION_ID", "BBAN"}),
			@UniqueConstraint(name="U_ACCOUNT__IBAN", columnNames={"IBAN"}),
		@UniqueConstraint(name="U_ACCOUNT__ACCOUNT_NUMBER", columnNames={"ACCOUNT_NUMBER"}), 
	}
)


public class Account extends GenericEntity {
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	@Column(name = "ID", nullable=false, precision = 20, scale = 0)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long 						id;

	@ManyToOne@JoinColumn(name="INSTITUTION_ID", nullable=false, foreignKey=@ForeignKey(name="FK_INSTITUTION"))
	private Institution			institution;


	@Column(name = "ACCOUNT_NUMBER", length = 30, nullable=false)
	private String		accountNumber;
	
	@Column(name = "BBAN", length = 50, nullable=false)
	private String					bban;
	
	@Column(name = "IBAN", length = 50, nullable=false)
	private String					iban;
	
	@Column(name = "CLEARING_CODE", length = 30)
	private String					clearingCode;
	
	@ManyToOne@JoinColumn(name="ACCOUNT_TYPE_ID", nullable=false, foreignKey=@ForeignKey(name="FK_ACCOUNT__ACCOUNT_TYPE"))
	private AccountType			accountType;


	@ManyToOne@JoinColumn(name="CUSTOMER_ID", foreignKey=@ForeignKey(name="FK_ACCOUNT__CUST"), nullable=false)
	private Customer				customer;

	@ManyToOne@JoinColumn(name="BRANCH_ID", foreignKey=@ForeignKey(name="FK_ACCOUNT__BRANCH"), nullable=false)
	private Branch				branch;

	
	@Column(name = "BALANCE", precision = 20, scale = 5)
	private Double					balance;
	
	
	@Column(name = "AVAILABLE_BALANCE", precision = 20, scale = 5)
	private Double	availableBalance;
	
	
	@Column(name = "BLOCKED_AMOUNT", precision = 20, scale = 5)
	private Double					blockedAmount;
	
	@Column(name = "FACILITY", precision = 20, scale = 5)
	private Double					facility;
	

	@ManyToOne
	@JoinColumn(name="CURRENCY_ID", foreignKey=@ForeignKey(name="FK_ACCOUNT_INSTCURR_CURRENCY"), nullable=false)
	public Currency currency;


	@Column(name = "LONG_LABEL", length = 140)
	private String					longLabel;

	@Column(name = "SHORT_LABEL", length = 20, nullable=false)
	private String					shortLabel;

	@Column(name = "STATUS", length = 1)@Enumerated(EnumType.STRING)
	private Status					status;

	@Column(name = "STATUS_DATE")@Temporal(TemporalType.TIMESTAMP)
	private Date						statusDate;

	@Column(name = "CREATION_DATE", nullable=false)@Temporal(TemporalType.TIMESTAMP)
	private Date						creationDate;

	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	public static enum Status {
		P, // On Validation Process (in progress)
		N, // Normal
		H, // Hold
		T, // Terminated
		TP,// Terminated Pending
	}
	

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	public void setId(Long id){
		this.id = id;
	}
	@Override
	public Long getId() {
		return id;
	}

	// ------------------------------------------------------------------------------------------
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
	// ------------------------------------------------------------------------------------------
	

	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	// ------------------------------------------------------------------------------------------
	
	public String getBban() {
		return bban;
	}
	public void setBban(String bban) {
		this.bban = bban;
	}

	// ------------------------------------------------------------------------------------------

	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	// ------------------------------------------------------------------------------------------

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountNumber(){
		return this.accountNumber;
	}

	// ------------------------------------------------------------------------------------------

	public void setLongLabel(String longLabel) {
		this.longLabel = longLabel;
	}
	public String getLongLabel(){
		return this.longLabel;
	}

	// ------------------------------------------------------------------------------------------

	public void setShortLabel(String shortLabel) {
		this.shortLabel = shortLabel;
	}
	public String getShortLabel(){
		return this.shortLabel;
	}

	// ------------------------------------------------------------------------------------------

	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	// ------------------------------------------------------------------------------------------

	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	
	
	
	// ------------------------------------------------------------------------------------------
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	// ------------------------------------------------------------------------------------------

	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	
	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	
	public Double getAvailableBalance() {
		return availableBalance;
	}
	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}
	public Double getBlockedAmount() {
		return blockedAmount;
	} 
	public void setBlockedAmount(Double blockedAmount) {
		this.blockedAmount = blockedAmount;
	}
	public Double getFacility() {
		return facility;
	}
	public void setFacility(Double facility) {
		this.facility = facility;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	@Override
	public void setIdToNull() {
		setId(null); 
	}
	
 	public String getClearingCode() {
		return clearingCode;
	}
	public void setClearingCode(String clearingCode) {
		this.clearingCode = clearingCode;
	}

	
	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	

	// ------------------------------------------------------------------------------------------
	// DEPRECATED
	// ------------------------------------------------------------------------------------------

	
	@Column(name = "NUM", length = 30)
	private String					num;
	
	
	@Column(name = "BACKEND_ACCOUNT_NUMBER", length = 30)
	private String					backendAccountNumber;
	
	@Deprecated
	public void setNum(String num) {
		this.num = num;
	}
	@Deprecated
	public String getNum(){
		return this.num;
	}

	public String getBackendAccountNumber() {
		return backendAccountNumber;
	}
	public void setBackendAccountNumber(String backendAccountNumber) {
		this.backendAccountNumber = backendAccountNumber;
	}

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------

	private static final long serialVersionUID = 1L;



	@Transient
	private Msisdn msisdn;
	public Msisdn getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(Msisdn msisdn) {
		this.msisdn = msisdn;
	}
	
	@Transient
	private Boolean isPaymentInstrument;
	public Boolean getIsPaymentInstrument() {
		return isPaymentInstrument;
	}
	public void setIsPaymentInstrument(Boolean isPaymentInstrument) {
		this.isPaymentInstrument = isPaymentInstrument;
	}
	
	
	@Transient
	private Boolean isExternal;
	public Boolean getIsExternal() {
		return isExternal;
	}
	public void setIsExternal(Boolean isExternal) {
		this.isExternal = isExternal;
	}


	@Transient
	private String alias;
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}

	

	// ------------------------------------------------------------------------------------------
	// ------------------------------------------------------------------------------------------
	
}
