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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@Entity
@Table( name = "CITY",
		uniqueConstraints={
			@UniqueConstraint(name="AK_UI_CITY_CODE_CITY", columnNames={"CITY_CODE"})
		}
)

@JsonInclude(Include.NON_NULL)
public class City extends GenericEntity {

	private static final long serialVersionUID = 1L;
	@Override
	public Long getId() {
		return getCity_id();
	}
	@Override
	public void setIdToNull() {
		setCity_id(null);
	}
	
	@Column(name = "CITY_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	protected Long city_id;
	public void setCity_id(Long value) {
		this.city_id = value;
	}
	public Long getCity_id(){
		return this.city_id;
	}


	@Column(name = "CITY_CODE" , length = 30, nullable=false)
	protected String city_code;
	public void setCityCode(String value) {
		this.city_code = value;
	}
	public String getCityCode(){
		return this.city_code;
	}


	@Column(name = "NAME", length = 140, nullable=false)
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

	@ManyToOne
	@JoinColumn(name="COUNTRY_ID", foreignKey=@ForeignKey(name="FK_CITY_COUNTYCIT_COUNTRY"), nullable=false)
	public Country country;
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	@ManyToOne
	@JoinColumn(name="REGION_ID", foreignKey=@ForeignKey(name="FK_CITY_REGION"), nullable=true)
	public Region region;
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
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
    
    
    @Transient
	private Double 				longitude;
    @Transient
	private Double 				latitude;
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
    
    

}
