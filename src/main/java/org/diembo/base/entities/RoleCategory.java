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
@Table( name = "ROLECATEGORY", 
	uniqueConstraints={
		@UniqueConstraint(name="UROLE_CATEGORY__INST__CODE", columnNames={"INSTITUTION_ID", "ROLECATEGORY_CODE"})
	}
)	
public class RoleCategory extends GenericEntity
{
	//Generate Class Body.
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof RoleCategory)) return false;
		RoleCategory other = (RoleCategory) obj;
		if (this.getRolecategory_id() == null) {
			if (other.getRolecategory_id() != null)return false;
		} else if (! this.getRolecategory_id().equals(other.getRolecategory_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getRolecategory_id() == null) ? 0 : this.getRolecategory_id().hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return getRolecategory_id();
	}
	@Override
	public void setIdToNull() {
		setRolecategory_id(null);
	}


	@Column(name = "ROLECATEGORY_ID", nullable=false)
	@TableGenerator(name = "AdminTokenGenerator", table = "TOKENSERIE", pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "AdminSerie")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "AdminTokenGenerator")
	protected Long rolecategory_id;
	public void setRolecategory_id(Long value) {
		this.rolecategory_id = value;
	}
	public Long getRolecategory_id(){
		return this.rolecategory_id;
	}


	@Column(name = "ROLECATEGORY_CODE", length=30, nullable=false)
	protected String rolecategory_code;
	public void setRolecategoryCode(String value) {
		this.rolecategory_code = value;
	}
	public String getRolecategoryCode(){
		return this.rolecategory_code;
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
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_ROLE_CATEGORY__INST"), nullable=false)
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
