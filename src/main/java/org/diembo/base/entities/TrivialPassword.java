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


@Entity
@Table( 
		name = "TRIVIAL_PASSWORD"
				//name = "SPC"
		)

public class TrivialPassword extends GenericEntity
{
	//Generate Class Body.
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof TrivialPassword)) return false;
		TrivialPassword other = (TrivialPassword) obj;
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
		return id;
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


	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "CODE", length=20, nullable=false)
	protected String code;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	   
	
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //



	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_BENEF_GROUP__INST"), nullable=false)
	private Institution institution;
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	private static final long serialVersionUID = 1L;

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //

}
