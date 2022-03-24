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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.diembo.base.msg.Balance;
import org.diembo.entities.Persons;



@Entity
@Table( name = "TRANSFER_DETAILS")
public class TransferDetail extends GenericEntity {
	

	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long id;
	
	@Column(name = "AMOUNT", nullable = false)
	private Double amount;
	
	@Column(name = "TOTAL_FEES", nullable = false)
	private Double totalFees;
	
	public Double getTotalFees() {
		return totalFees;
	}

	public void setTotalFees(Double totalFees) {
		this.totalFees = totalFees;
	}

	
	@Column(name = "TRANSFERT_SCOPE", length = 20 ,nullable = false)
	private String transferScope;
	
	public String getTransferScope() {
		return transferScope;
	}

	public void setTransferScope(String transferScope) {
		this.transferScope = transferScope;
	}


	public String getBackEndAuthorizationNumber() {
		return backEndAuthorizationNumber;
	}

	public void setBackEndAuthorizationNumber(String backEndAuthorizationNumber) {
		this.backEndAuthorizationNumber = backEndAuthorizationNumber;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@ManyToOne
	@JoinColumn(name="SERVICE_ID", foreignKey=@ForeignKey(name="FK_TRANSFER_DETAIL_SERVICE"), nullable=false)
	private Service service;

	
	@ManyToOne
	@JoinColumn(name="CURRENCY_ID", foreignKey=@ForeignKey(name="FK_TRANSFER_DETAIL_CURRENCY"), nullable=false)
	private Currency currency;
	
	@Column(name = "BACKEND_AUTHORIZATION_NUMBER", nullable=true, length = 60)
	private String	backEndAuthorizationNumber;
	
	

	@ManyToOne
	@JoinColumn(name = "INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_TRANSFER_DETAIL__INST"), nullable=false)
	private Institution institution;
	
	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", foreignKey=@ForeignKey(name="FK_TRANSFER_DETAIL__CUSTOMER"), nullable=true)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "CONTRACT_ID", foreignKey=@ForeignKey(name="FK_TRANSFER_DETAIL__CONTRACT"), nullable=true)
	private Contract contract;

	
	@Column(name = "BENEFICIARY_BRANCH_BIC", length=30)
	private String beneficiaryBranchBic;

	@Column(name = "BENEFICIARY_ACCOUNT_NUMBER", length=30, nullable = false)
	private String beneficiaryAccountNumber;
	
	@Column(name = "BENEFICIARY_FIRSTNAME", length=30)
	private String beneficiaryFirstName;
	
	@Column(name = "BENEFICIARY_LASTNAME", length=30)
	private String beneficiaryLastName;

	@Column(name = "BENEFICIARY_MSISDN", length=30)
	private String beneficiaryMsisdn;

	@Column(name = "SENDER_NAME", length=30)
	private String senderName;
	
	public String getBeneficiaryMsisdn() {
		return beneficiaryMsisdn;
	}

	public void setBeneficiaryMsisdn(String beneficiaryMsisdn) {
		this.beneficiaryMsisdn = beneficiaryMsisdn;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	@Column(name = "BENEFICIARY_WALLETITEM_NUMBER", length=30, nullable = false)
	private String beneficiaryWalletItemNumber;
	
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Column(name = "BENEFICIARY_WALLETITEM_TYPE", length=30, nullable = false)
	private String beneficiaryWalletItemType;
	
	@Column(name = "CODE", length = 20, nullable = false)
	private String code;
	
	@Column(name = "REFERENCE", length = 20, nullable = false)
	private String reference;
	
	@Column(name = "SOURCE_ACCOUNT_NUMBER", length=30, nullable = false)
	private String sourceAccountNumber;
	
	@Column(name = "SOURCE_WALLETITEM_NUMBER", length=30, nullable = false)
	private String sourceWalletitemNumber;
	
	@Column(name = "SOURCE_WALLETITEM_TYPE", length=30, nullable = false)
	private String sourceWalletitemType;
	
	@Column(name = "STATUS", nullable=false)
	private TransferStatus status;

	@Column(name = "STATUS_MESSAGE", nullable=true)
	private String statusMessage;
	
	@Column(name = "purpose", length=160)
	private String purpose;
	
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	
	@Column(name = "STATUS_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date statusDate;
	
	@ManyToOne
	@JoinColumn(name = "TRANSACTION_REQUEST_ID", foreignKey=@ForeignKey(name="FK_TRANSFER_DETAIL__TRANS_REQ"), nullable=true)
	private TransactionRequest transactionRequest;

	
	@ManyToOne
	@JoinColumn(name = "PERSON_ID", foreignKey=@ForeignKey(name="FK_TRANSFER_REQ__TRANS_REQ"), nullable=true)
	private Persons person;
	
	
	@Transient
	private Balance debitAccountBalance;	
	
	@Transient
	private Balance creditAccountBalance;
	
	
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
	

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}



	public String getBeneficiaryBranchBic() {
		return beneficiaryBranchBic;
	}

	public void setBeneficiaryBranchBic(String beneficiaryBranchBic) {
		this.beneficiaryBranchBic = beneficiaryBranchBic;
	}

	public String getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public String getBeneficiaryFirstName() {
		return beneficiaryFirstName;
	}

	public void setBeneficiaryFirstName(String beneficiaryFirstName) {
		this.beneficiaryFirstName = beneficiaryFirstName;
	}

	public String getBeneficiaryLastName() {
		return beneficiaryLastName;
	}

	public void setBeneficiaryLastName(String beneficiaryLastName) {
		this.beneficiaryLastName = beneficiaryLastName;
	}


	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}


	public TransactionRequest getTransactionRequest() {
		return transactionRequest;
	}

	public void setTransactionRequest(TransactionRequest transactionRequest) {
		this.transactionRequest = transactionRequest;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
	
	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Persons getPerson() {
		return person;
	}

	public void setPerson(Persons person) {
		this.person = person;
	}

	
	public Balance getDebitAccountBalance() {
		return debitAccountBalance;
	}

	public void setDebitAccountBalance(Balance debitAccountBalance) {
		this.debitAccountBalance = debitAccountBalance;
	}

	public Balance getCreditAccountBalance() {
		return creditAccountBalance;
	}

	public void setCreditAccountBalance(Balance creditAccountBalance) {
		this.creditAccountBalance = creditAccountBalance;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public String getBeneficiaryWalletItemNumber() {
		return beneficiaryWalletItemNumber;
	}

	public void setBeneficiaryWalletItemNumber(String beneficiaryWalletItemNumber) {
		this.beneficiaryWalletItemNumber = beneficiaryWalletItemNumber;
	}

	public String getBeneficiaryWalletItemType() {
		return beneficiaryWalletItemType;
	}

	public void setBeneficiaryWalletItemType(String beneficiaryWalletItemType) {
		this.beneficiaryWalletItemType = beneficiaryWalletItemType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSourceAccountNumber() {
		return sourceAccountNumber;
	}

	public void setSourceAccountNumber(String sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}

	public String getSourceWalletitemNumber() {
		return sourceWalletitemNumber;
	}

	public void setSourceWalletitemNumber(String sourceWalletitemNumber) {
		this.sourceWalletitemNumber = sourceWalletitemNumber;
	}

	public String getSourceWalletitemType() {
		return sourceWalletitemType;
	}

	public void setSourceWalletitemType(String sourceWalletitemType) {
		this.sourceWalletitemType = sourceWalletitemType;
	}

	public TransferStatus getStatus() {
		return status;
	}

	public void setStatus(TransferStatus status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	@Transient
	public String backendProgressLevel;
	public String getBackendProgressLevel() {
		return backendProgressLevel;
	}

	public void setBackendProgressLevel(String backendProgressLevel) {
		this.backendProgressLevel = backendProgressLevel;
	}
	
	

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public TransferDetail(){
	}
	

	
	
	public enum TransferStatus  {		
		InProgress,
		Done,
		Failed,
		Expired		
		;
	}
	
	
	private static final long serialVersionUID = 1L;

}
