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


@Entity
@Table(name = "APP",
uniqueConstraints={
		@UniqueConstraint(name="U_APP_CODE__INST"		, columnNames={"CODE"	, "INSTITUTION_ID"}), 
	})	

public class App extends GenericEntity {

	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "CountryTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie" )
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "CountryTokenGenerator")
	private Long id;

	@Column(name = "NAME") 
	private String name;

	@Column(name = "CODE") 
	private String code;

	@ManyToOne
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_APP__INSTITUTION"))
	private Institution institution; 
	
	@Transient
	private List<AppVersion> appVersions;
	
	public List<AppVersion> getAppVersions() {
		return appVersions;
	}

	public void setAppVersions(List<AppVersion> appVersions) {
		this.appVersions = appVersions;
	}

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

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}


	private static final long serialVersionUID = 1L;
}