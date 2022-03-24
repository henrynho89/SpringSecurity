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
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@JsonInclude(Include.NON_NULL)

@Entity
@Table( name = "CUSTOMERTYPE", 
		uniqueConstraints={
			@UniqueConstraint(name="U_CUST_TYPE__CODE__INST", columnNames={"CUSTOMERTYPE_CODE", "INSTITUTION_ID"})
		}
)
public class CustomerType extends GenericEntity
{
	@Override
	public Long getId() {
		return getCustomerType_id();
	}
	@Override
	public void setIdToNull() {
		setCustomerType_id(null);
	}
	
	@Column(name = "CUSTOMERTYPE_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long customerType_id;
	public void setCustomerType_id(Long value) {
		this.customerType_id = value;
	}
	public Long getCustomerType_id(){
		return this.customerType_id;
	}


	@ManyToOne
	@JoinColumn(name="CUSTOMERCATEGORY_ID", foreignKey=@ForeignKey(name="FK_CUSTOMER_CUSTCATTY_CUSTOMER"), nullable=false)
	private CustomerCategory customerCategory;
	public void setCustomerCategory(CustomerCategory customerCategory) {
		this.customerCategory = customerCategory;
	}
	public CustomerCategory getCustomerCategory(){
		return this.customerCategory;
	}


	@Column(name = "CUSTOMERTYPE_CODE", length=30, nullable=false)
	private String customerType_code;
	public void setCustomerTypeCode(String value) {
		this.customerType_code = value;
	}
	public String getCustomerTypeCode(){
		return this.customerType_code;
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


	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_CUSTTYPE__INST"), nullable=false)
	private Institution institution;
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	private static final long serialVersionUID = 1L;

}
