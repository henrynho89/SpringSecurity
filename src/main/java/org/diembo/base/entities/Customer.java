package org.diembo.base.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import org.diembo.base.entities.security.Role;
import org.diembo.entities.Persons;


@Entity
@Table( name = "CUSTOMERS"

)
public class Customer extends GenericEntity
{

	
	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "ControlsTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlsTokenGenerator")
	private Long id;

	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public void setIdToNull() {
		this.id = null;
	}

	@Column(name = "CODE", length = 30, nullable = false)
	private String code;
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return this.code;
	}

	@Column(name = "USER_FIELD_1", length = 150)
	private String userField1;
	public void setUserField1(String userField1) {
		this.userField1 = userField1;
	}
	public String getUserField1() {
		return this.userField1;
	}
	
	
	@Column(name = "USER_FIELD_2", length = 150)
	private String userField2;
	public void setUserField2(String userField2) {
		this.userField2 = userField2;
	}
	public String getUserField2() {
		return this.userField2;
	}
	
	
	@Column(name = "USER_FIELD_3", length = 150)
	private String userField3;
	public void setUserField3(String userField3) {
		this.userField3 = userField3;
	}
	public String getUserField3() {
		return this.userField3;
	}
	
	
	@Column(name = "USER_FIELD_4", length = 150)
	private String userField4;
	public void setUserField4(String userField4) {
		this.userField4 = userField4;
	}
	public String getUserField4() {
		return this.userField4;
	}
	
	
	@Column(name = "USER_FIELD_5", length = 150)
	private String userField5;
	public void setUserField5(String userField5) {
		this.userField5 = userField5;
	}
	public String getUserField5() {
		return this.userField5;
	}
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_CUSTOMERS__INST"), nullable=false)
	private Institution institution;
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	
	@ManyToOne
	@JoinColumn(name="PERSON_ID", foreignKey=@ForeignKey(name="FK_CUSTOMERS__PERSON"), nullable=false)
	protected Persons person;
	public Persons getPerson() {
		return person;
	}
	public void setPerson(Persons person) {
		this.person = person;
	}


	@ManyToOne
	@JoinColumn(name="COMPANY_ID", foreignKey=@ForeignKey(name="FK_CUSTOMERS__COMPANY"))
	protected Company company;
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company value) {
		this.company = value;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CUSTOMER_TYPE_ID", foreignKey=@ForeignKey(name="FK_CUSTOMERS__CUSTOMERTYPE"), nullable=false)
	private CustomerType customerType;
	public CustomerType getCustomerType() {
		return customerType;
	}
	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}
	
	

	@OneToMany(mappedBy="customer")
	private List<Contract> contracts;
	public List<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	
	@OneToMany(mappedBy="customer")
	private List<Account> accounts;
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	
	@OneToMany(mappedBy="customer")
	private List<Card> cards;
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="BRANCH_ID", foreignKey=@ForeignKey(name="FK_CUSTOMER_BRANCH"), nullable=false)
	private Branch branch;
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="ROLE_ID", foreignKey=@ForeignKey(name="FK_CUSTOMER_ROLE"), nullable=false)
	private Role role;
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	

	
	
	@Transient
	protected Persons advisor;
	public Persons getAdvisor() {
		return advisor;
	}
	public void setAdvisor(Persons advisor) {
		this.advisor = advisor;
	}

	
	@Transient
	public String getFirstName(){
		if (company != null) {
			return "";
		} else {
			return person==null? null: person.getFirstName();	
		}
	}
	
	@Transient
	public String getLastName(){
		if (company != null) {
			return company.getName();
		} else {
			return person==null? null: person.getLastName();	
		}
	}
	
	@Transient
	public String getCustomerName(){
		if (company != null) {
			return company.getName();
		} else {
			return person==null? null: person.getFirstName() +  " " + person.getLastName();	
		}
	}
	
	
	@Transient
	public String getEmail(){
		if (company != null) {
			return company.getEmail();
		} else {
			return person==null? null: person.getEmail();	
		}
	}
	
	@Transient
	public String getStreetName1(){
		if (company != null) {
			return company.getStreetName1();
		} else {
			return person==null? null: person.getStreetName1();	
		}
	}
	
	@Transient
	public String getStreetName2(){
		if (company != null) {
			return company.getStreetName2();
		} else {
			return person==null? null: person.getStreetName2();	
		}
	}
	
	@Transient
	public City getCity(){
		if (company != null) {
			return company.getCity();
		} else {
			return person==null? null: person.getCity();	
		}
	}
	
	
	
	@Transient
	public void setEmail(String email){
		if (company != null) {
			 company.setEmail(email);
		} else {
			 person.setEmail(email);	
		}
	}
	
	@Transient
	public String getCustomerMobilePhoneNumber(){
		if (company != null) {
			return company.getPhone1();
		} else {
			if ((person != null) && (person.getMsisdn() != null) ){
				return person.getMsisdn().getCode();
			} else {
				return null;
			}
		}
	}
	
	
	@Transient
	public String getCustomerLegalIdNumber(){
		if (company != null) {
			return company.getLegalIdNumber();
		} else {
			return person==null? null: person.getLegalIdNumber();
		}
	}
	
	
	
	
	@Transient
	public String getBic(){
		if (company != null) {
			return "To be done";
		} else {
			return "To be done";	
		}
	}
	
	@Transient
	private List<Persons> linkableCustomers = new ArrayList<Persons>();
	public List<Persons> getLinkableCustomers() {
		return linkableCustomers;
	}
	public void setLinkableCustomers(List<Persons> linkableCustomers) {
		this.linkableCustomers = linkableCustomers;
	}
	
	

	private static final long serialVersionUID = 1L;
}
