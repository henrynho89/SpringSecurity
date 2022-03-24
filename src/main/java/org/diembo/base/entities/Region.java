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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table( name = "REGION")
public class Region extends GenericEntity {

	private static final long serialVersionUID = 1L;
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Region)) return false;
		Region other = (Region) obj;
		if (this.getId() == null) {
			if (other.getId() != null)return false;
		} else if (! this.getId().equals(other.getId()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getId() == null) ? 0 : this.getId().hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return this.id;
	}
	@Override
	public void setIdToNull() {
		setId(null);
	}
	
	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	protected Long id;
	public void setId(Long value) {
		this.id = value;
	}
	


	@Column(name = "CODE", length=30)
	protected String code;
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode(){
		return this.code;
	}

	@Column(name = "NAME", length=140)
	protected String name;
	public void setName(String value) {
		this.name = value;
	}
	public String getName(){
		return this.name;
	}


	@Column(name = "RANK")
	protected Long rank;
	public void setRank(Long value) {
		this.rank = value;
	}
	public Long getRank(){
		return this.rank;
	}

	@ManyToOne
	@JoinColumn(name = "COUNTRY_ID", foreignKey=@ForeignKey(name="FK_REGION_COUNTRY"), nullable=false)
	public Country country;
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	@OneToMany(mappedBy="region")
	public Collection<City> cities;
	public Collection<City> getCities() {
		return cities;
	}
	public void setCities(Collection<City> cities) {
		this.cities = cities;
	}
	
}
