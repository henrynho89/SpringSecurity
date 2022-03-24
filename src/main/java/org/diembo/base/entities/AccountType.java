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



@Entity
@Table(
	name = "ACCOUNT_TYPE", 
	uniqueConstraints={
		@UniqueConstraint(name="U_ACCOUNT_TYPE__INST__CODE", columnNames={"INSTITUTION_ID", "CODE"})
	}
)
public class AccountType extends GenericEntity {
	
	

	@Column(name = "ID", nullable=false, precision = 20, scale = 0)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long id;

	@ManyToOne@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_ACCOUNT__INST"))
	private Institution				institution;

	@Column(name = "CODE", length = 30, nullable=false)
	private String					code;

	@Column(name = "NAME", length = 140)
	private String					name;
	
	@Column(name = "MIN_BALANCE", precision = 20, scale = 5, nullable = false)
	private Double					minBalance;
	
	@Column(name = "MAX_BALANCE", precision = 20, scale = 5, nullable = false)
	private Double					maxBalance;

	
	

	public void setId(Long id){
		this.id = id;
	}
	@Override
	public Long getId() {
		return id;
	}



	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}



	public void setCode(String code) {
		this.code = code;
	}
	public String getCode(){
		return this.code;
	}



	public void setName(String name) {
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public Double getMinBalance() {
		return minBalance;
	}
	public void setMinBalance(Double minBalance) {
		this.minBalance = minBalance;
	}
	public Double getMaxBalance() {
		return maxBalance;
	}
	public void setMaxBalance(Double maxBalance) {
		this.maxBalance = maxBalance;
	}

	@Override
	public void setIdToNull() {
		setId(null); 
	}

	private static final long serialVersionUID = 1L;
	
}
