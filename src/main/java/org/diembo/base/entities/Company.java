package org.diembo.base.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "COMPANY", 
	uniqueConstraints={
		@UniqueConstraint(name="U_LEGAL_ID_NUMBER"			, columnNames={"LEGAL_ID_NUMBER"})
	}
)	
public class Company extends GenericEntity {


	@Column(name = "ID", nullable = false)
	@TableGenerator(name = "MasterTokenGenerator", table = "TOKENSERIE", pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "MasterSerie")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MasterTokenGenerator")
	private Long id;

	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setIdToNull() {
		this.id = null;
	}
	public void setId(Long value) {
		this.id = value;
	}

	
	
	@Column(name = "NAME", length=140, nullable = false)
	private String name;

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

 
	@Column(name = "LONG_NAME", length=140, nullable = false)
	private String longName;

	public String getLongName() {
		return this.longName;
	}
	public void setLongName(String longName) {
		this.longName = longName;
	}

	public String getCompanyDetails() {
		return getName() + " " + getLongName() ;
	}
	

	
	@Column(name = "LEGAL_ID_NUMBER", length=30, nullable = false)
	private String legalIdNumber;
	public String getLegalIdNumber() {
		return this.legalIdNumber;
	}
	public void setLegalIdNumber(String legalIdNumber) {
		this.legalIdNumber = legalIdNumber;
	}
	

	@Column(name = "LEGAL_ID_DATE", nullable = false)
	private java.util.Date legalIdDate;
	public void setLegalIdDate(java.util.Date value) {
		this.legalIdDate = value;
	}
	public java.util.Date getLegalIdDate() {
		return this.legalIdDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="LEGAL_ID_CITY_ID", foreignKey=@ForeignKey(name="FK_POEPLE__LEGAL_CITY"), nullable=false)
	private City legalIdCity;
	public City getLegalIdCity() {
		return this.legalIdCity;
	}
	public void setLegalIdCity(City legalIdCity) {
		this.legalIdCity = legalIdCity;
	}
	
	
	@Column(name = "LEGAL_ID_NUMBER_2", length=30, nullable = false)
	private String legalIdNumber2;
	public String getLegalIdNumber2() {
		return this.legalIdNumber2;
	}
	public void setLegalIdNumber2(String legalIdNumber2) {
		this.legalIdNumber2 = legalIdNumber2;
	}

	@Column(name = "LEGAL_ID_NUMBER_3", length=30, nullable = false)
	private String legalIdNumber3;
	public String getLegalIdNumber3() {
		return this.legalIdNumber3;
	}
	public void setLegalIdNumber3(String legalIdNumber3) {
		this.legalIdNumber3 = legalIdNumber3;
	}

	@Column(name = "LEGAL_ID_NUMBER_4", length=30, nullable = false)
	private String legalIdNumber4;
	public String getLegalIdNumber4() {
		return this.legalIdNumber4;
	}
	public void setLegalIdNumber4(String legalIdNumber4) {
		this.legalIdNumber4 = legalIdNumber4;
	}

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="COMPANY_TYPE_ID", foreignKey=@ForeignKey(name="FK_COMPANY_TYPE_ID"), nullable=false)
	private CompanyType companyType;
	public CompanyType getCompanyType() {
		return companyType;
	}
	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}	

	@Column(name = "CREATION_DATE", nullable = false)
	private Date creationDate;
	public Date getCreationDate() {
		return this.creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	

	@Column(name = "PHONE1", length=30)
	private String phone1;
	public void setPhone1(String value) {
		this.phone1 = value;
	}
	public String getPhone1() {
		return this.phone1;
	}

	@Column(name = "PHONE2", length=30)
	private String phone2;
	public void setPhone2(String value) {
		this.phone2 = value;
	}
	public String getPhone2() {
		return this.phone2;
	}

	@Column(name = "FAX", length=30)
	private String fax;
	public void setFax(String value) {
		this.fax = value;
	}
	public String getFax() {
		return this.fax;
	}

	@Column(name = "EMAIL", length=60)
	private String email;
	public void setEmail(String value) {
		this.email = value;
	}
	public String getEmail() {
		return this.email;
	}
	
	
	
	@Column(name = "NUM", length=10)
	private String num;

	public void setNum(String value) {
		this.num = value;
	}

	public String getNum() {
		return this.num;
	}

	@Column(name = "STREET_NAME_1", length= 500, nullable = false)
	private String streetName1;

	public void setStreetName1(String value) {
		this.streetName1 = value;
	}

	public String getStreetName1() {
		return this.streetName1;
	}

	@Column(name = "STREET_NAME_2", length= 500)
	private String streetName2;

	public void setStreetName2(String value) {
		this.streetName2 = value;
	}

	public String getStreetName2() {
		return this.streetName2;
	}

	@Column(name = "EXTENDED_ADDRESS", length=140)
	private String extendedAddress;

	public void setExtendedAddress(String value) {
		this.extendedAddress = value;
	}

	public String getExtendedAddress() {
		return this.extendedAddress;
	}

	@Column(name = "POSTAL_CODE", length=30)
	private String postalCode;

	public void setPostalCode(String value) {
		this.postalCode = value;
	}

	public String getPostalCode() {
		return this.postalCode;
	}
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CITY_ID", foreignKey=@ForeignKey(name="FK_CUSTOMER_NATIONALI_CITY"), nullable=false)
	private City city;
	public City getCity() {
		return this.city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	

	
	@Column(name = "HOLD", nullable = false)
	private Boolean hold = false;
	public Boolean getHold() {
		return hold;
	}
	public void setHold(Boolean hold) {
		this.hold = hold;
	}



	@Column(name = "HOLD_NOTES", length=140)
	private String holdnotes;
	public void setHoldnotes(String value) {
		this.holdnotes = value;
	}
	public String getHoldnotes() {
		return this.holdnotes;
	}
	

	
	@Column(name = "NOTES", length=256 )
	private String notes;
	public String getNotes() {
		return this.notes;
	}
	public void setNotes(String value) {
		this.notes = value;
	}

	

	@Column(name = "PRIVILEGE", nullable = false)
	private Long privilege =0L;
	public void setPrivilege(Long value) {
		this.privilege = value;
	}
	public Long getPrivilege() {
		return this.privilege;
	}

	@Column(name = "PRIVILEGE_REGISTRATION_DATE")
	private java.util.Date privilegeRegistrationDate;
	public Date getPrivilegeRegistrationDate() {
		return this.privilegeRegistrationDate;
	}
	public void setPrivilegeRegistrationDate(Date value) {
		this.privilegeRegistrationDate = value;
	}
	
	
	@Column(name = "EKHLASS_NOTIFICATION")
	private Boolean ekhlassNotification;
	public Boolean getEkhlassNotification() {
		return ekhlassNotification;
	}
	public void setEkhlassNotification(Boolean ekhlassNotification) {
		this.ekhlassNotification = ekhlassNotification;
	}



	@Column(name = "USERFIELD1", length= 60 )
	private String userfield1;

	public void setUserfield1(String value) {
		this.userfield1 = value;
	}
	public String getUserfield1() {
		return this.userfield1;
	}

	@Column(name = "USERFIELD2", length= 60 )
	private String userfield2;

	public void setUserfield2(String value) {
		this.userfield2 = value;
	}
	public String getUserfield2() {
		return this.userfield2;
	}



	private static final long serialVersionUID = 1L;


}
