package org.diembo.base.entities;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;


@Entity
@Table( name = "COUNTRY",
	uniqueConstraints={
		@UniqueConstraint(name="AK_UI_COUNTRY_CODE_COUNTRY", columnNames={"COUNTRY_CODE"})
	}
)
public class Country extends GenericEntity
{
	@Override
	public Long getId() {
		return getCountry_id();
	}
	@Override
	public void setIdToNull() {
		setCountry_id(null);
	}
	
	@Column(name = "COUNTRY_ID", nullable=false)
	@TableGenerator(name = "ControlsTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlsTokenGenerator")
	private Long country_id;
	public void setCountry_id(Long value) {
		this.country_id = value;
	}
	public Long getCountry_id(){
		return this.country_id;
	}


	@Column(name = "COUNTRY_CODE", length=30, nullable=false)
	private String country_code;
	public void setCountryCode(String value) {
		this.country_code = value;
	}
	public String getCountryCode(){
		return this.country_code;
	}

	@Column(name = "TELEPHONE_PREFIX", length=30, nullable=false)
	private String telephonePrefix ;	
	public String getTelephonePrefix() {
		return telephonePrefix;
	}
	public void setTelephonePrefix(String telephonePrefix) {
		this.telephonePrefix = telephonePrefix;
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
	

	@Column(name = "EXT_CODE", length=30)
	private String extCode;
	public void setExtCode(String extCode) {
		this.extCode = extCode;
	}
	public String getExtCode(){
		return this.extCode;
	}

	@Column(name = "IBAN_COMPLIANCE", nullable=false)
	private Boolean ibanCompliance;
	public Boolean getIbanCompliance() {
		return ibanCompliance;
	}
	public void setIbanCompliance(Boolean ibanCompliance) {
		this.ibanCompliance = ibanCompliance;
	}
	
	@Column(name = "IBAN_COUNTRY_CODE", nullable=false)
	private String ibanCountryCode;
	public String getIbanCountryCode() {
		return ibanCountryCode;
	}
	public void setIbanCountryCode(String ibanCountryCode) {
		this.ibanCountryCode = ibanCountryCode;
	}

	@Column(name = "IBAN_CHECKSUM", nullable=false)
	private String ibanChecksum;
	public String getIbanChecksum() {
		return ibanChecksum;
	}
	public void setIbanChecksum(String ibanChecksum) {
		this.ibanChecksum = ibanChecksum;
	}

	@Column(name = "BBAN_FORMAT", nullable=false)
	private String bbanFormat;
	public String getBbanFormat() {
		return bbanFormat;
	}
	public void setBbanFormat(String bbanFormat) {
		this.bbanFormat = bbanFormat;
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
    
	@Column(name = "IBAN_LENGTH", nullable=false)
	private Long ibanLength;
	public Long getIbanLength() {
		return ibanLength;
	}
	public void setIbanLength(Long ibanLength) {
		this.ibanLength = ibanLength;
	}

	
	@Transient
	private List<City> citys;
	public List<City> getCitys() {
		return citys;
	}
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}

	@Transient
	private List<Region> regions;
	public List<Region> getRegions() {
		return regions;
	}
	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}
	
	
	private static final long serialVersionUID = 1L;

}
