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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)

@Entity
@Table( name = "MSISDN"

)
public class Msisdn extends GenericEntity
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


	@Column(name = "CODE", length=30, nullable=false)
	private String code;
	public void setCode(String value) {
		this.code = value;
	}
	public String getCode(){
		return this.code;
	}

	
	@Column(name = "HOSTED", length=30)
	private Boolean hosted;
	public void setHosted(Boolean value) {
		this.hosted = value;
	}
	public Boolean getHosted(){
		return this.hosted;
	}


	@ManyToOne
	@JoinColumn(name="ACCOUNT_ID", foreignKey=@ForeignKey(name="FK_MSISDN_ACCOUNT"))
	private Account account;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account value) {
		this.account = value;
	}
	


	@ManyToOne
	@JoinColumn(name="CONTRACT_ID", foreignKey=@ForeignKey(name="FK_MSISDN_CONTRACT"))
	private Contract contract;
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	
	@Transient
	private Boolean noSms = false;
	public Boolean getNoSms() {
		return noSms;
	}
	public void setNoSms(Boolean noSms) {
		this.noSms = noSms;
	}


	private static final long serialVersionUID = 1L;
}
