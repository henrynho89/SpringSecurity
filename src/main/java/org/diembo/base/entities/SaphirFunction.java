package org.diembo.base.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)

@Entity
@Table( name = "SAPHIRFUNCTION", 
	uniqueConstraints={
		@UniqueConstraint(name="AK_SAPHIRFUNCTION_COD_SAPHIRFU", columnNames={"SAPHIRFUNCTION_CODE"})
	}
)	
public class SaphirFunction extends GenericEntity {
	
	private static final long serialVersionUID = 1L;
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof SaphirFunction)) return false;
		SaphirFunction other = (SaphirFunction) obj;
		if (this.getSaphirfunction_id() == null) {
			if (other.getSaphirfunction_id() != null)return false;
		} else if (! this.getSaphirfunction_id().equals(other.getSaphirfunction_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getSaphirfunction_id() == null) ? 0 : this.getSaphirfunction_id().hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return getSaphirfunction_id();
	}
	@Override
	public void setIdToNull() {
		setSaphirfunction_id(null);
	}

	@Column(name = "SAPHIRFUNCTION_ID", nullable=false)
	@TableGenerator(name = "AdminTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "AdminSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "AdminTokenGenerator")	
	protected Long saphirfunction_id;
	public Long getSaphirfunction_id() {
		return saphirfunction_id;
	}
	public void setSaphirfunction_id(Long saphirfunction_id) {
		this.saphirfunction_id = saphirfunction_id;
	}

	
	@Column(name = "SAPHIRFUNCTION_CODE", length=60, nullable=false)
	protected String saphirFunction_code;
	public String getSaphirFunctionCode() {
		return saphirFunction_code;
	}
	public void setSaphirFunctionCode(String saphirFunction_code) {
		this.saphirFunction_code = saphirFunction_code;
	}

	
	@Column(name = "NAME", length=140, nullable=false)
	protected String name;
	public void setName(String value) {
		this.name = value;
	}
	public String getName(){
		return this.name;
	}


	@Column(name = "NOTES", length=256, nullable=false)
	protected String notes;
	public void setNotes(String value) {
		this.notes = value;
	}
	public String getNotes(){
		return this.notes;
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
