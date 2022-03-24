package org.diembo.base.entities.security;


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

import org.diembo.base.entities.GenericEntity;
import org.diembo.base.entities.Institution;
import org.diembo.base.entities.RoleCategory;


@Entity
@Table( name = "ROLETYPE", 
	uniqueConstraints={
		@UniqueConstraint(name="U_ROLETYPE__CODE__INST", columnNames={"ROLETYPE_CODE", "INSTITUTION_ID"})
	}
)	
public class RoleType extends GenericEntity {
	//Generate Class Body.
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof RoleType)) return false;
		RoleType other = (RoleType) obj;
		if (this.getRoletype_id() == null) {
			if (other.getRoletype_id() != null)return false;
		} else if (! this.getRoletype_id().equals(other.getRoletype_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getRoletype_id() == null) ? 0 : this.getRoletype_id().hashCode());
		return result;
	}


	@Override
	public Long getId() {
		return getRoletype_id();
	}
	@Override
	public void setIdToNull() {
		setRoletype_id(null);
	}
	
	
	@Column(name = "ROLETYPE_ID", nullable=false)
	@TableGenerator(name = "AdminTokenGenerator", table = "TOKENSERIE", pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "AdminSerie")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "AdminTokenGenerator")
	protected Long roletype_id;
	public void setRoletype_id(Long value) {
		this.roletype_id = value;
	}
	public Long getRoletype_id(){
		return this.roletype_id;
	}

	@ManyToOne
	@JoinColumn(name = "ROLECATEGORY_ID", foreignKey=@ForeignKey(name="FK_ROLETYPE_ROLECATTY_ROLECATE"), nullable=false)
	public RoleCategory roleCategory;
	 public RoleCategory getRoleCategory() {
		return roleCategory;
	}
	public void setRoleCategory(RoleCategory roleCategory) {
		this.roleCategory = roleCategory;
	}

	@Column(name = "ROLETYPE_CODE", length=30, nullable=false)
	protected String roleType_code;
	public void setRoleTypeCode(String value) {
		this.roleType_code = value;
	}
	public String getRoleTypeCode(){
		return this.roleType_code;
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
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_ROLETYPE__INST"), nullable=false)
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
