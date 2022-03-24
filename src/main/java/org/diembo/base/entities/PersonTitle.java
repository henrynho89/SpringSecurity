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
@Table( name = "PERSONTITLE", 
	uniqueConstraints={
		@UniqueConstraint(name="FK_PERSON_TITLE__INST__CODE", columnNames={"INSTITUTION_ID", "PERSONTITLE_CODE"})
	}
)	
public class PersonTitle extends GenericEntity
{
	//Generate Class Body.
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof PersonTitle)) return false;
		PersonTitle other = (PersonTitle) obj;
		if (this.getPersonTitle_id() == null) {
			if (other.getPersonTitle_id() != null)return false;
		} else if (! this.getPersonTitle_id().equals(other.getPersonTitle_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getPersonTitle_id() == null) ? 0 : this.getPersonTitle_id().hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return getPersonTitle_id();
	}
	@Override
	public void setIdToNull() {
		setPersonTitle_id(null);
	}

	@Column(name = "PERSONTITLE_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	protected Long personTitle_id;
	public void setPersonTitle_id(Long value) {
		this.personTitle_id = value;
	}
	public Long getPersonTitle_id(){
		return this.personTitle_id;
	}


	@Column(name = "PERSONTITLE_CODE", length=30, nullable=false)
	protected String personTitle_code;
	public void setPersonTitleCode(String value) {
		this.personTitle_code = value;
	}
	public String getPersonTitleCode(){
		return this.personTitle_code;
	}


	@Column(name = "NAME", length=140, nullable=false)
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


	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_PERSON_TITLE__INST"), nullable=false)
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
