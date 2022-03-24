package org.diembo.base.entities;


import java.util.Collection;

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
@Table( name = "CUSTOMERCATEGORY", 
		uniqueConstraints={
			@UniqueConstraint(name="U_CUST_CATEGORY__CODE__INST", columnNames={"CUSTOMERCATEGORY_CODE", "INSTITUTION_ID"})
		}
)
public class CustomerCategory extends GenericEntity
{
	@Override
	public Long getId() {
		return getCustomerCategory_id();
	}
	@Override
	public void setIdToNull() {
		setCustomerCategory_id(null);
	}
	
	@Column(name = "CUSTOMERCATEGORY_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	protected Long customerCategory_id;
	public void setCustomerCategory_id(Long value) {
		this.customerCategory_id = value;
	}
	public Long getCustomerCategory_id(){
		return this.customerCategory_id;
	}


	@Column(name = "CUSTOMERCATEGORY_CODE", length=30, nullable=false)
	protected String customerCategory_code;
	public void setCustomerCategoryCode(String value) {
		this.customerCategory_code = value;
	}
	public String getCustomerCategoryCode(){
		return this.customerCategory_code;
	}


	@Column(name = "NAME", length=140, nullable=false)
	protected String name;
	public void setName(String value) {
		this.name = value;
	}
	public String getName(){
		return this.name;
	}


	@Column(name = "RANK", nullable=false)
	protected Long rank;
	public void setRank(Long value) {
		this.rank = value;
	}
	public Long getRank(){
		return this.rank;
	}

	@Transient
	private Collection<CustomerType> customerTypes ;
	public Collection<CustomerType> getCustomerTypes() {
		return customerTypes;
	}
	public void setCustomerTypes(Collection<CustomerType> customerTypes) {
		this.customerTypes = customerTypes;
	}

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_CUST_CATEGORY__INST"), nullable=false)
	private Institution institution;
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	private static final long serialVersionUID = 1L;

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
}
