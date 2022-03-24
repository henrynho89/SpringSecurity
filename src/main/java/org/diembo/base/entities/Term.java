package org.diembo.base.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table( name = "TERM",
	uniqueConstraints={ 
		@UniqueConstraint(name="AK_UI_TERM_TERM", columnNames={"TERM_CODE"})
	}
)
public class Term extends GenericEntity {
	
	private static final long serialVersionUID = 1L;
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Term)) return false;
		Term other = (Term) obj;
		if (this.getTerm_id() == null) {
			if (other.getTerm_id() != null)return false;
		} else if (! this.getTerm_id().equals(other.getTerm_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getTerm_id() == null) ? 0 : this.getTerm_id().hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return getTerm_id();
	}
	@Override
	public void setIdToNull() {
		setTerm_id(null);
	}

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "AdminTokenGenerator")
	protected Long term_id;
	public void setTerm_id(Long value) {
		this.term_id = value;
	}
	public Long getTerm_id(){
		return this.term_id;
	}


	@Column(name = "TERM_CODE", length=30, nullable=false)
	protected String term_code;
	public void setTermCode(String value) {
		this.term_code = value;
	}
	public String getTermCode(){
		return this.term_code;
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
}
