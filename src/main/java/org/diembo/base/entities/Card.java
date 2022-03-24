package org.diembo.base.entities;


import java.util.Date;

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


@Entity
@Table(name = "CARD",
	uniqueConstraints={
		@UniqueConstraint(name="U_IDENTIFIER"		, columnNames={"IDENTIFIER"}),
		@UniqueConstraint(name="U_NUMBER__INST"		, columnNames={"NUMBER"	, "INSTITUTION_ID"}) 
	}
)	


public class Card extends GenericEntity {

	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "CountryTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie" )
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "CountryTokenGenerator")
	private Long id;

	
	@Column(name = "IDENTIFIER", nullable=false) 
	private String identifier;
	
	@Column(name = "NUMBER", nullable=false) 
	private String number;
	
	@Column(name = "NAME", nullable=true) 
	private String name;
	
	@Column(name = "HOLDER_TITLE", nullable=true) 
	private String holderTitle;
	
	@Column(name = "HOLDER_FIRST_NAME", nullable=true) 
	private String holderFirstName;
	
	@Column(name = "HOLDER_LAST_NAME", nullable=true) 
	private String holderLastName;
	
	@Column(name = "HOLDER_PHONE1", nullable=true) 
	private String holderPhone1;
	
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", foreignKey=@ForeignKey(name="FK_CARD__CUSTOMER"))
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "CARD_TYPE_ID", foreignKey=@ForeignKey(name="FK_CARD__CARD_TYPE"))
	private CardType cardType;
	
	@Column(name = "CREATION_DATE", nullable=false)
	private Date creationDate;
	
	@Column(name = "RECEPTION_DATE", nullable=true)
	private Date receptionDate;
	
	@Column(name = "ACTIVATION_DATE", nullable=true)
	private Date activationDate;
	
	@Column(name = "EXPIRY_DATE", nullable=true)
	private Date expiryDate;
	
	@Column(name = "TERMINATION_DATE", nullable=true)
	private Date terminationDate;
	
	@Column(name = "PRIMARY_CARD", nullable=false)
	private Boolean primaryCard;	
	
	@Column(name = "STATUS", nullable=false)
	private Status status;
	
	@Column(name = "INTERNET_STATUS", nullable=false) 
	private InternetStatus internetStatus; 
	
	@Column(name = "ENDOWMENT_ENABLED") 
	private Boolean endowmentEnabled;
	
	@Column(name = "ENDOWMENT_STATUS")
	private EndowmentStatus endowmentStatus;

	@Column(name = "INTERNATIONAL_ENABLED") 
	private Boolean internationalEnabled;
	
	@Column(name = "CVV2") 
	private String	cvv2;


	@Column(name = "STATUS_DATE", nullable=true)
	private Date statusDate;
	
	@Column(name = "BALANCE", nullable=true)
	private Double balance;
	

	@Column(name = "CARD_LIMIT", nullable=true)
	private Double cardLimit; 
	
	@Column(name = "CARD_WITHDRAWAL_LIMIT", nullable=true)
	private Double cardWithdrawalLimit; 
	
	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_CARD__INST"), nullable=false)
	private Institution institution;
	
	@ManyToOne
	@JoinColumn(name = "BRANCH_ID", foreignKey=@ForeignKey(name="FK_CARD__BRANCH"))
	private Branch branch;

	@ManyToOne
	@JoinColumn(name = "ACCOUNT_ID", foreignKey=@ForeignKey(name="FK_CARD__ACCOUNT"))
	private Account account;

	@ManyToOne
	@JoinColumn(name="CONTRACT_ID", foreignKey=@ForeignKey(name="FK_CARD__CONTRACT"), nullable=true)
	protected Contract contract;
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract value) {
		this.contract = value;
	}
	
	
	
	// -------------------------------------------------------
	@Column(name = "ACCOUNT_NUMBER", nullable=true) 
	private String accountNumber;


	// -------------------------------------------------------
	@Transient
	private String alias;
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}	
	// -------------------------------------------------------

	
	// -------------------------------------------------------
	@Transient
	private OppositionReason oppositionReason;
	public OppositionReason getOppositionReason() {
		return oppositionReason;
	}
	public void setOppositionReason(OppositionReason oppositionReason) {
		this.oppositionReason = oppositionReason;
	}
	// -------------------------------------------------------
	
	

	// -------------------------------------------------------
	@Transient
	private String network;
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	// -------------------------------------------------------
	
	
	// -------------------------------------------------------
	@Transient
	private String cmsStatus;
	public String getCmsStatus() {
		return cmsStatus;
	}
	public void setCmsStatus(String cmsStatus) {
		this.cmsStatus = cmsStatus;
	}
	// -------------------------------------------------------
	

	@Override
	public void setIdToNull() {
		setId(null);
	}

	public Long getId(){
		return this.id;
	}
	public void setId(Long value) {
		this.id = value;
	}

	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getHolderTitle() {
		return holderTitle;
	}

	public void setHolderTitle(String holderTitle) {
		this.holderTitle = holderTitle;
	}

	public String getHolderFirstName() {
		return holderFirstName;
	}

	public void setHolderFirstName(String holderFirstName) {
		this.holderFirstName = holderFirstName;
	}

	public String getHolderLastName() {
		return holderLastName;
	}

	public void setHolderLastName(String holderLastName) {
		this.holderLastName = holderLastName;
	}

	public String getHolderPhone1() {
		return holderPhone1;
	}

	public void setHolderPhone1(String holderPhone1) {
		this.holderPhone1 = holderPhone1;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
	
	
	public Date getReceptionDate() {
		return receptionDate;
	}

	public void setReceptionDate(Date receptionDate) {
		this.receptionDate = receptionDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}



	public void setPrimaryCard(Boolean primaryCard) {
		this.primaryCard = primaryCard;
	}
	public Boolean getPrimaryCard() {
		return primaryCard;
	}
	


	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
		
//	public void assignStatusFromString(String status) {
//		this.status = Card.Status.valueOf(status);
//	}


	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public Institution getInstitution() {
		return institution;
	}
	
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}


	public String getAccountNumber() {
		return accountNumber;
	}

	public Double getCardLimit() {
		return cardLimit;
	}

	public void setCardLimit(Double cardLimit) {
		this.cardLimit = cardLimit;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}



	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	

	public InternetStatus getInternetStatus() {
		return internetStatus;
	}

	public void setInternetStatus(InternetStatus internetStatus) {
		this.internetStatus = internetStatus;
	}
	


	private static final long serialVersionUID = 1L;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public static enum Status   {
		ACTIVE, 
		PENDING, 
		OPPOSED,
		CANCELED,
		EXPIRED,
		//ORDER_PROGRESS
	}

	public static enum InternetStatus   {
		ACTIVE, 
		INACTIVE
	}	
	public static enum EndowmentStatus   {
		A, // Active
		P, // Pending
		I  // Inactive
	}
	public static enum OppositionReason   {
		Stollen,
		Lost,
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
	private Boolean isExternalEndowment;
	public void setIsExternalEndowment(Boolean isExternalEndowment) {
		this.isExternalEndowment = isExternalEndowment;
	}
	public Boolean getIsExternalEndowment() {
		return isExternalEndowment;
	}
	
	public Boolean getEndowmentEnabled() {
		return endowmentEnabled;
	}
	public void setEndowmentEnabled(Boolean endowmentEnabled) {
		this.endowmentEnabled = endowmentEnabled;
	}
	public EndowmentStatus getEndowmentStatus() {
		return endowmentStatus;
	}
	public void setEndowmentStatus(EndowmentStatus endowmentStatus) {
		this.endowmentStatus = endowmentStatus;
	}
	public Boolean getInternationalEnabled() {
		return internationalEnabled;
	}
	public void setInternationalEnabled(Boolean internationalEnabled) {
		this.internationalEnabled = internationalEnabled;
	}
	public String getCvv2() {
		return cvv2;
	}
	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}
	public Double getCardWithdrawalLimit() {
		return cardWithdrawalLimit;
	}
	public void setCardWithdrawalLimit(Double cardWithdrawalLimit) {
		this.cardWithdrawalLimit = cardWithdrawalLimit;
	}
	
}