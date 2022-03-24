package org.diembo.base.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

@Entity
@Table( name = "CURRENCY",
	uniqueConstraints = {
		@UniqueConstraint(name="AK_UI_CURRENCY_CODE_CURRENCY"	, columnNames={"CURRENCY_CODE"}), 
		@UniqueConstraint(name="AK_UI_ISOCODE_CURRENCY"			, columnNames={"ISOCODE"}),
		@UniqueConstraint(name="AK_UI_SHORTCODE_CURRENCY"		, columnNames={"SHORTCODE"})
	}
)
public class Currency extends GenericEntity
{

	@Override
	public Long getId() {
		return getCurrency_id();
	}
	@Override
	public void setIdToNull() {
		setCurrency_id(null);
	}
	
	@Column(name = "CURRENCY_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long currency_id;
	public Long getCurrency_id() {
		return currency_id;
	}

	public void setCurrency_id(Long currency_id) {
		this.currency_id = currency_id;
	}

	@Column(name = "CURRENCY_CODE", length=30, nullable=false)
	private String currency_code;
	public String getCurrencyCode() {
		return currency_code;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currency_code = currencyCode;
	}

	
	@Column(name = "NAME", length=140, nullable=false)
	private String name;
	public void setName(String value) {
		this.name = value;
	}
	public String getName(){
		return this.name;
	}
	
	@Column(name = "ISOCODE", length=3, nullable=false)
	private String isoCode;
	public String getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	@Column(name = "SHORTCODE", length=3, nullable=false)
	private String shortCode;
	public String getShortCode() {
		return shortCode;
	}
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	
	@Column(name = "RANK", nullable=false)
	private Long rank;
	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}


	@Column(name = "EXT_CODE", length=30)
	private String extCode;
	public void setExtCode(String extCode) {
		this.extCode = extCode;
	}
	public String getExtCode(){
		return this.extCode;
	}


	/**
	 * Additional fields ( 1 to 2)
	 */

	@Column(name = "USER_FIELD1" , length = 60)
	private String userField1;
	public void setUserField1(String value) {
        this.userField1 = value;
    }
    public String getUserField1() {
        return this.userField1;
    }

	@Column(name = "USER_FIELD2" , length = 60)
	private String userField2;
	public void setUserField2(String value) {
        this.userField2 = value;
    }
    public String getUserField2() {
        return this.userField2;
    }
    
	private static final long serialVersionUID = 1L;
}
