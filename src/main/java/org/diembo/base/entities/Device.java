package org.diembo.base.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name = "DEVICE")	

public class Device extends GenericEntity {
	
	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "CountryTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie" )
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "CountryTokenGenerator")
	private Long id;

	@Column(name = "CODE") 
	private String code;

	@Column(name = "PLATEFORM") 
	private String plateform;

	@Column(name = "MODEL") 
	private String model;

	@Column(name = "BRAND") 
	private String brand;	
	
	@Column(name = "OS_VERSION") 
	private String osVersion;
	
	@Column(name = "FCM_ADDRESS" , length=250)
	private String fcmAddress;
	
	
	@Override
	public void setIdToNull() {
		setId(null);
	}
	
	public Long getId(){
		return this.id;
	}
	public void setId(Long value) {
		this.id = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPlateform() {
		return plateform;
	}

	public void setPlateform(String plateform) {
		this.plateform = plateform;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getFcmAddress() {
		return fcmAddress;
	}
	public void setFcmAddress(String fcmAddress) {
		this.fcmAddress = fcmAddress;
	}

	private static final long serialVersionUID = 1L;
}