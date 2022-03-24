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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Entity
@Table( name = "FAMILYSITUATION", 
	uniqueConstraints={
		@UniqueConstraint(name="U_FAMILY_SITUATION__INST__CODE", columnNames={"INSTITUTION_ID", "FAMILYSITUATION_CODE"})
	}
)	
	
public class FamilySituation extends GenericEntity
{
	//Generate Class Body.
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof FamilySituation)) return false;
		FamilySituation other = (FamilySituation) obj;
		if (this.getFamilySituation_id() == null) {
			if (other.getFamilySituation_id() != null)return false;
		} else if (! this.getFamilySituation_id().equals(other.getFamilySituation_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getFamilySituation_id() == null) ? 0 : this.getFamilySituation_id().hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return getFamilySituation_id();
	}
	@Override
	public void setIdToNull() {
		setFamilySituation_id(null);
	}
	
	@Column(name = "FAMILYSITUATION_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	protected Long familySituation_id;
	public void setFamilySituation_id(Long value) {
		this.familySituation_id = value;
	}
	public Long getFamilySituation_id(){
		return this.familySituation_id;
	}


	@Column(name = "FAMILYSITUATION_CODE", length=30, nullable=false)
	protected String familySituation_code;
	public void setFamilySituationCode(String value) {
		this.familySituation_code = value;
	}
	public String getFamilySituationCode(){
		return this.familySituation_code;
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
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_FAMILY_SITUATION__INST"), nullable=false)
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
