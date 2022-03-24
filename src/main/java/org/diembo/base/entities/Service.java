package org.diembo.base.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@Entity
@Table( name = "SERVICE",
	uniqueConstraints={ 
		@UniqueConstraint(name="U_SERVICE__CODE__INST", columnNames={"SERVICE_CODE", "INSTITUTION_ID"}),
		@UniqueConstraint(name="U_SERVICE__IDENTIFIER__INST", columnNames={"IDENTIFIER", "INSTITUTION_ID"})
	}
)
public class Service extends GenericEntity
{
	@Override
	public Long getId() {
		return getService_id();
	}
	@Override
	public void setIdToNull() {
		setService_id(null);
	}

	@Column(name = "SERVICE_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long service_id;
	public void setService_id(Long value) {
		this.service_id = value;
	}
	public Long getService_id(){
		return this.service_id;
	}


	@ManyToOne
	@JoinColumn(name = "SERVICEGROUP_ID", foreignKey=@ForeignKey(name="FK_SERVICE_TRANSACCA_SERVICEG"), nullable=false)
	public ServiceGroup serviceGroup;
	 public ServiceGroup getServiceGroup() {
		return serviceGroup;
	}
	public void setServiceGroup(ServiceGroup serviceGroup) {
		this.serviceGroup = serviceGroup;
	}

	@ManyToOne 
	@JoinColumn(name="DEFAULT_CURRENCY_ID", foreignKey=@ForeignKey(name="SERVICE_DEFAULT_CURRENCY_ID_FKEY"))
	private Currency defaultCurrency;
	
	public Currency getDefaultCurrency() {
		return defaultCurrency;
	}
	public void setDefaultCurrency(Currency defaultCurrency) {
		this.defaultCurrency = defaultCurrency;
	}
	
	
	@Column(name = "SERVICE_CODE", length=30, nullable=false)
	private String service_code; // should be kept with this name (with _code) because of genericDao
	public void setServiceCode(String value) {
		this.service_code = value;
	}
	public String getServiceCode(){
		return this.service_code;
	}

	@Column(name = "IDENTIFIER", nullable=false)
	private Long identifier;
	public void setIdentifier(Long identifier) {
		this.identifier = identifier;
	}
	public Long getIdentifier(){
		return this.identifier;
	}

	@Column(name = "NAME", length=140, nullable=false)
	private String name;
	public void setName(String value) {
		this.name = value;
	}
	public String getName(){
		return this.name;
	}


	@Column(name = "RANK", nullable=false)
	private Long rank;
	public void setRank(Long value) {
		this.rank = value;
	}
	public Long getRank(){
		return this.rank;
	}


	@Column(name = "AMOUNTMULTIPLE", nullable=false)
	private Long amountMultiple;
	public void setAmountMultiple(Long value) {
		this.amountMultiple = value;
	}
	public Long getAmountMultiple(){
		return this.amountMultiple;
	}
	
	@Column(name = "BACKENDSERVICE_CODE", length=30, nullable=false)
	private String backendServiceCode;
	public void setBackendServiceCode(String value) {
		this.backendServiceCode = value;
	}
	public String getBackendServiceCode(){
		return this.backendServiceCode;
	}
	
	@Column(name = "BACKEND_REVERSAL_SERVICE_CODE", length=30, nullable=false)
	private String backendReversalServiceCode;
	public void setBackendReversalServiceCode(String value) {
		this.backendReversalServiceCode = value;
	}
	public String getBackendReversalServiceCode(){
		return this.backendReversalServiceCode;
	}
	
	@Column(name = "ABBREVIATION", length=3, nullable=false)
	private String abbreviation;
	public void setAbbreviation(String value) {
		this.abbreviation = value;
	}
	public String getAbbreviation(){
		return this.abbreviation;
	}
	
	@Column(name = "BENEFICIARYNOTIFICATION", nullable = false)
	private Long beneficiaryNotification = 0L;

	public void setBeneficiaryNotification(Long value) {
		this.beneficiaryNotification = value;
	}
	public Long getBeneficiaryNotification() {
		return this.beneficiaryNotification;
	}
	
//	public void setBeneficiaryNotification(boolean value) {
//		if (value) {
//			this.beneficiaryNotification = 1L;
//		} else {
//			this.beneficiaryNotification = 0L;
//		}
//	}
//
//	public boolean getBeneficiaryNotification() {
//		return (this.beneficiaryNotification == 1L);
//	}
	
	@Column(name = "TO_BE_LOGGED", nullable = false)
	private Boolean toBeLogged = false;	
	public Boolean getToBeLogged() {
		return toBeLogged;
	}
	public void setToBeLogged(Boolean toBeLogged) {
		this.toBeLogged = toBeLogged;
	}

	@Column(name = "HOLD", nullable = false)
	private Boolean hold = false;
	public void setHold(Boolean value) {
		this.hold = value;
	}
	public Boolean getHold() {
		return this.hold;
	}
//	public void setHold(boolean value) {
//		if (value) {
//			this.hold = 1L;
//		} else {
//			this.hold = 0L;
//		}
//	}
//	public boolean getHold() {
//		return (this.hold == 1L);
//	}
//	
	
	@Column(name = "FEES", nullable = false)
	protected Double fees = 0.0;
	public void setFees(Double value) {
		this.fees = value;
	}
	public Double getFees() {
		return this.fees;
	}
	
	
	@Column(name = "COMMISSION", nullable = false)
	protected Double commission = 0.0;
	public void setCommission(Double value) {
		this.commission = value;
	}
	public Double getCommission() {
		return this.commission;
	}
	

	@Column(name = "AUTHORIZATION_NEEDED", nullable=true)
	private Boolean authorizationNeeded;
	public Boolean getAuthorizationNeeded() {
		return authorizationNeeded;
	}
	public void setAuthorizationNeeded(Boolean authorizationNeeded) {
		this.authorizationNeeded = authorizationNeeded;
	}
	
	
	@Column(name = "AMOUNTAUTHORIZATIONNEEDED", nullable = false)
	private Long amountAuthorizationNeeded = 0L;

	public void setAmountAuthorizationNeeded(Long value) {
		this.amountAuthorizationNeeded = value;
	}
	public Long getAmountAuthorizationNeeded() {
		return this.amountAuthorizationNeeded;
	}
//	public void setAmountAuthorizationNeeded(boolean value) {
//		if (value) {
//			this.amountAuthorizationNeeded = 1L;
//		} else {
//			this.amountAuthorizationNeeded = 0L;
//		}
//	}
//	public boolean getAmountAuthorizationNeeded() {
//		return (this.amountAuthorizationNeeded == 1L);
//	}

	
	@Column(name = "FEESAUTHORIZATIONNEEDED", nullable = false)
	private Long feesAuthorizationNeeded = 0L;
	public void setFeesAuthorizationNeeded(Long value) {
		this.feesAuthorizationNeeded = value;
	}
	public Long getFeesAuthorizationNeeded() {
		return this.feesAuthorizationNeeded;
	}
//	public void setFeesAuthorizationNeeded(boolean value) {
//		if (value) {
//			this.feesAuthorizationNeeded = 1L;
//		} else {
//			this.feesAuthorizationNeeded = 0L;
//		}
//	}
//	public boolean getFeesAuthorizationNeeded() {
//		return (this.feesAuthorizationNeeded == 1L);
//	}

	@Column(name = "CAN_BE_REVERSED", nullable = true)
	private Boolean canBeReversed;
	public void setCanBeReversed(Boolean canBeReversed) {
		this.canBeReversed = canBeReversed;
	}
	public Boolean getCanBeReversed() {
		return canBeReversed;
	}
	
	
	@OneToMany(mappedBy="service") 
	public List<ChannelService> channelServices;
	public List<ChannelService> getChannelServices() {
		return channelServices;
	}
	public void setChannelServices(List<ChannelService> channelServices) {
		this.channelServices = channelServices;
	}


	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_SERVICE__INST"), nullable=false)
	private Institution institution;
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@Transient
	private List<ServiceCurrency> serviceCurrency;
	public List<ServiceCurrency> getServiceCurrency() {
		return serviceCurrency;
	}
	public void setServiceCurrency(List<ServiceCurrency> serviceCurrency) {
		this.serviceCurrency = serviceCurrency;
	}

	
	
	private static final long serialVersionUID = 1L;

}
