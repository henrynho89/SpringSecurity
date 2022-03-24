package org.diembo.base.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;


@Entity
@Table( name = "PERSONHOLDREASON", 
	uniqueConstraints={
		@UniqueConstraint(name="AK_PERSHLDRSN_CODE_PERSONHO", columnNames={"PERSONHOLDREASON_CODE"})
	}
)	
public class PersonHoldReason extends GenericEntity {
	
	private static final long serialVersionUID = 1L;
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof PersonHoldReason)) return false;
		PersonHoldReason other = (PersonHoldReason) obj;
		if (this.getPersonHoldReason_id() == null) {
			if (other.getPersonHoldReason_id() != null)return false;
		} else if (! this.getPersonHoldReason_id().equals(other.getPersonHoldReason_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getPersonHoldReason_id() == null) ? 0 : this.getPersonHoldReason_id().hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return getPersonHoldReason_id();
	}
	@Override
	public void setIdToNull() {
		setPersonHoldReason_id(null);
	}
	
	@Column(name = "PERSONHOLDREASON_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	protected Long personHoldReason_id;
	public Long getPersonHoldReason_id() {
		return personHoldReason_id;
	}

	public void setPersonHoldReason_id(Long personHoldReason_id) {
		this.personHoldReason_id = personHoldReason_id;
	}

	@Column(name = "PERSONHOLDREASON_CODE", length=30, nullable=false)
	protected String personHoldReason_code;
	public String getPersonHoldReasonCode() {
		return personHoldReason_code;
	}
	public void setPersonHoldReasonCode(String personHoldReason_code) {
		this.personHoldReason_code = personHoldReason_code;
	}

	@Column(name = "NAME", length=140, nullable=false)
	protected String name;
	public void setName(String value) {
		this.name = value;
	}
	public String getName(){
		return this.name;
	}
	@Column(name = "HOLDLEVEL", nullable=false)
	protected Long holdLevel;
	public Long getHoldLevel() {
		return holdLevel;
	}

	public void setHoldLevel(Long holdLevel) {
		this.holdLevel = holdLevel;
	}

	@Column(name = "RANK", nullable=false)
	protected Long rank;
	public void setRank(Long value) {
		this.rank = value;
	}
	public Long getRank(){
		return this.rank;
	}
}
