package org.diembo.base.entities;

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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

@Entity
@Table( name = "INSTITUTION", 
		uniqueConstraints={
				@UniqueConstraint(name="AK_UI_INSTITUTION_INSTITUT", 	columnNames={"INSTITUTION_CODE"}),
				@UniqueConstraint(name="AK_UI_INSTITUTION_BANK", 		columnNames={"BANK_CODE"})
			}	
)
public class Institution extends GenericEntity
{

	@Override
	public Long getId() {
		return getInstitution_id();
	}
	@Override
	public void setIdToNull() {
		setInstitution_id(null);
	}


	@Column(name = "INSTITUTION_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long institution_id;

	@Column(name = "INSTITUTION_CODE", length=30, nullable=false)
	private String institution_code;

	@Column(name = "BANK_CODE", length=30, nullable=false)
	private String bankCode;
	
	@Column(name = "BIC", length=10, nullable=true)
	private String bic;
	
	@Column(name = "NAME", length=140, nullable=false)
	private String name;
	
	@Column(name = "BUSINESSDATEMANAGEMENT", nullable=false)
	private Boolean businessDateManagement = true;
	
	@Column(name = "NOTES", length=256)
	private String notes;
	
	@Column(name = "TELEPHONE_CODE")
	private String telephoneCode;

	@Column(name = "TIME_ZONE")
	private String timeZone;
	
	@ManyToOne
	@JoinColumn(name="CURRENCY_ID", foreignKey=@ForeignKey(name="FK_INSTITUTION_INSTCURR_CURRENCY"), nullable=false)
	public Currency currency;
	
	
	
	
	public Long getInstitution_id() {
		return institution_id;
	}

	public void setInstitution_id(Long institution_id) {
		this.institution_id = institution_id;
	}

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	public String getInstitutionCode() {
		return institution_code;
	}
	public void setInstitutionCode(String institutionCode) {
		this.institution_code = institutionCode;
	}


	// .~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String banckCode) {
		this.bankCode = banckCode;
	}

	
	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	
	public String getTelephoneCode() {
		return telephoneCode;
	}
	public void setTelephoneCode(String telephoneCode) {
		this.telephoneCode = telephoneCode;
	}
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	public void setNotes(String value) {
		this.notes = value;
	}
	public String getNotes(){
		return this.notes;
	}

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	public void setName(String value) {
		this.name = value;
	}
	public String getName(){
		return this.name;
	}

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	public Boolean getBusinessDateManagement() {
		return businessDateManagement;
	}
	public void setBusinessDateManagement(Boolean businessDateManagement) {
		this.businessDateManagement = businessDateManagement;
	}
	
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}


	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	private static final long serialVersionUID = 1L;
}
