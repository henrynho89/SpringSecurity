package org.diembo.base.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;



@Entity
@Table( name = "TRANSACTIONEVENTTYPE",
	uniqueConstraints={ 
		@UniqueConstraint(name="UQ_TRANSACTIONEVENTTYPE_CODE", columnNames={"TRANSACTIONEVENTTYPE_CODE"})
	}
)
public class TransactionEventType extends GenericEntity
{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "TRANSACTIONEVENTTYPE_ID", nullable=false)
	@TableGenerator(name = "MasterTokenGenerator", table = "TOKENSERIE", pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "MasterSerie")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "MasterTokenGenerator")
	
	protected Long transactioneventtype_id;
	public void setTransactioneventtype_id(Long value) {
		this.transactioneventtype_id = value;
	}
	public Long getTransactioneventtype_id(){
		return this.transactioneventtype_id;
	}


	@Column(name = "TRANSACTIONEVENTTYPE_CODE", length=30, nullable=false)
	protected String transactioneventtype_code;
	public void setTransactioneventtypeCode(String value) {
		this.transactioneventtype_code = value;
	}
	public String getTransactioneventtypeCode(){
		return this.transactioneventtype_code;
	}


	@Column(name = "NAME", length=140, nullable=false)
	protected String name;
	public void setName(String value) {
		this.name = value;
	}
	public String getName(){
		return this.name;
	}

	@Override
	public Long getId() {
		return getTransactioneventtype_id();
	}
	@Override
	public void setIdToNull() {
		setTransactioneventtype_id(null);
	}
}
