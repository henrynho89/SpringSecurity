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
@Table( name = "POSTALCODE", 
	uniqueConstraints={
		@UniqueConstraint(name="AK_UI_POSTALCODE_POSTALCO", columnNames={"POSTALCODE_CODE"})
	}
)	
public class PostalCode extends GenericEntity {
	
	private static final long serialVersionUID = 1L;
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof PostalCode)) return false;
		PostalCode other = (PostalCode) obj;
		if (this.getPostalCode_id() == null) {
			if (other.getPostalCode_id() != null)return false;
		} else if (! this.getPostalCode_id().equals(other.getPostalCode_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getPostalCode_id() == null) ? 0 : this.getPostalCode_id().hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return getPostalCode_id();
	}
	@Override
	public void setIdToNull() {
		setPostalCode_id(null);
	}
	
	@Column(name = "POSTALCODE_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	protected Long postalCode_id;
	public void setPostalCode_id(Long value) {
		this.postalCode_id = value;
	}
	public Long getPostalCode_id(){
		return this.postalCode_id;
	}


	@Column(name = "POSTALCODE_CODE", length=30, nullable=false)
	protected String postalCode_code;
	public void setPostalCodeCode(String value) {
		this.postalCode_code = value;
	}
	public String getPostalCodeCode(){
		return this.postalCode_code;
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
	@JoinColumn(name = "CITY_ID", foreignKey=@ForeignKey(name="FK_POSTALCO_CITY_POSA_CITY"), nullable=false)
	public City city;
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
}
