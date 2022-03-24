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

import org.diembo.base.entities.Branch;
import org.diembo.base.entities.GenericEntity;
import org.diembo.base.entities.Institution;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@Entity
@Table(name = "ROLE", 
	uniqueConstraints={
		@UniqueConstraint(name="U_ROLE__CODE__INST", columnNames={"ROLE_CODE", "INSTITUTION_ID"})
	}
)	
public class Role extends GenericEntity {
	// Generate Class Body.
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Role))
			return false;
		Role other = (Role) obj;
		if (this.getRole_id() == null) {
			if (other.getRole_id() != null)
				return false;
		} else if (!this.getRole_id().equals(other.getRole_id()))
			return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((this.getRole_id() == null) ? 0 : this.getRole_id()
						.hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return getRole_id();
	}

	@Override
	public void setIdToNull() {
		setRole_id(null);
	}

	@Column(name = "ROLE_ID", nullable = false)
	@TableGenerator(name = "AdminTokenGenerator", table = "TOKENSERIE", pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "AdminSerie")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "AdminTokenGenerator")
	protected Long role_id;

	public void setRole_id(Long value) {
		this.role_id = value;
	}

	public Long getRole_id() {
		return this.role_id;
	}

	@ManyToOne
	@JoinColumn(name = "ROLETYPE_ID", foreignKey=@ForeignKey(name="FK_ROLE_ROLETYPE_ROLETYPE"), nullable = false)
	protected RoleType roleType;
	
	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public RoleType getRoleType() {
		return this.roleType;
	}

	@Deprecated
	public Long getRoletype_id() {
		return this.roleType == null ? null : this.roleType.getRoletype_id();
	}

	// @ManyToOne
	// @JoinColumn(name = "ROLETYPE_ID", nullable=false)
	// public RoleType roletype;
	// public RoleType getRoleType() {
	// return roletype;
	// }
	// public void setRoleType(RoleType roletype) {
	// this.roletype = roletype;
	// }

	@ManyToOne
	@JoinColumn(name = "UPROLE_ID", foreignKey=@ForeignKey(name="FK_ROLE_UPROLE_ID_ROLE"), nullable = true)
	public Role upRole;

	public Role getUpRole() {
		return upRole;
	}

	public void setUpRole(Role upRole) {
		this.upRole = upRole;
	}

	@ManyToOne
	@JoinColumn(name = "PROFILE_ID", foreignKey=@ForeignKey(name="FK_ROLE_PROFILE_R_PROFILE"), nullable = false)
	public Profile profile;

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@ManyToOne
	@JoinColumn(name = "BRANCH_ID", foreignKey=@ForeignKey(name="FK_ROLE_BRCHROLE_BRANCH"), nullable = false)
	public Branch branch;

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	@Column(name = "ROLE_CODE", length=30, nullable = false)
	protected String role_code;

	public void setRoleCode(String value) {
		this.role_code = value;
	}

	public String getRoleCode() {
		return this.role_code;
	}

	@Column(name = "NAME", length=140, nullable = false)
	protected String name;

	public void setName(String value) {
		this.name = value;
	}

	public String getName() {
		return this.name;
	}

	@Column(name = "PHONE", length=30)
	protected String phone;

	public void setPhone(String value) {
		this.phone = value;
	}

	public String getPhone() {
		return this.phone;
	}

	@Column(name = "ONLINEROLE", nullable = false)
	protected Long onlinerole=0L;

	public void setOnlinerole(Long value) {
		this.onlinerole = value;
	}
	public Long getOnlinerole() {
		return this.onlinerole;
	}
//	public void setOnlinerole(boolean value) {
//		if (value) {
//			this.onlinerole = 1L;
//		} else {
//			this.onlinerole = 0L;
//		}
//	}
//
//	public boolean getOnlinerole() {
//		return (this.onlinerole == 1L);
//	}

	@Column(name = "IPADDRESS", length=30)
	protected String ipaddress;

	public void setIpaddress(String value) {
		this.ipaddress = value;
	}

	public String getIpaddress() {
		return this.ipaddress;
	}

	@Column(name = "USERFIELD1", length=60)
	protected String userfield1;

	public void setUserfield1(String value) {
		this.userfield1 = value;
	}

	public String getUserfield1() {
		return this.userfield1;
	}

	@Column(name = "USERFIELD2", length=60)
	protected String userfield2;

	public void setUserfield2(String value) {
		this.userfield2 = value;
	}

	public String getUserfield2() {
		return this.userfield2;
	}

	@Column(name = "USERFIELD3", length=60)
	protected String userfield3;

	public void setUserfield3(String value) {
		this.userfield3 = value;
	}

	public String getUserfield3() {
		return this.userfield3;
	}

	@Column(name = "USERFIELD4", length=60)
	protected String userfield4;

	public void setUserfield4(String value) {
		this.userfield4 = value;
	}

	public String getUserfield4() {
		return this.userfield4;
	}

	@Column(name = "USERFIELD5", length=60)
	protected String userfield5;

	public void setUserfield5(String value) {
		this.userfield5 = value;
	}

	public String getUserfield5() {
		return this.userfield5;
	}

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_ROLE__INST"), nullable=false)
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
