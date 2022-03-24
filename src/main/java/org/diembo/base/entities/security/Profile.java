package org.diembo.base.entities.security;

import java.util.List;

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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.diembo.base.entities.GenericEntity;
import org.diembo.base.entities.Institution;
import org.diembo.base.entities.SaphirFunction;
import org.diembo.base.entities.SaphirFunctionGrant;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

@Entity
@Table( name = "PROFILE",
	uniqueConstraints = {
		@UniqueConstraint(name="U_PROFILE__INST__CODE"		, columnNames={"INSTITUTION_ID", "PROFILE_CODE"})
	}
)
public class Profile extends GenericEntity
{
	//Generate Class Body.
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Profile)) return false;
		Profile other = (Profile) obj;
		if (this.getProfile_id() == null) {
			if (other.getProfile_id() != null)return false;
		} else if (! this.getProfile_id().equals(other.getProfile_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getProfile_id() == null) ? 0 : this.getProfile_id().hashCode());
		return result;
	}
	@Override
	public Long getId() {
		return getProfile_id();
	}
	@Override
	public void setIdToNull() {
		setProfile_id(null);
	}

	@Column(name = "PROFILE_ID", nullable=false)
	@TableGenerator(name = "AdminTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "AdminSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "AdminTokenGenerator")
	protected Long profile_id;
	public void setProfile_id(Long value) {
		this.profile_id = value;
	}
	public Long getProfile_id(){
		return this.profile_id;
	}


	@Column(name = "PROFILE_CODE", length=30, nullable=false)
	protected String profile_code;
	public void setProfileCode(String value) {
		this.profile_code = value;
	}
	public String getProfileCode(){
		return this.profile_code;
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

	
	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_PROFILE__INST"), nullable=false)
	private Institution institution;
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}


	
	@Transient
	private List<SaphirFunction>  saphirFunctions;
	public List<SaphirFunction> getSaphirFunctions() {
		return saphirFunctions;
	}
	public void setSaphirFunctions(List<SaphirFunction> saphirFunctions) {
		this.saphirFunctions = saphirFunctions;
	}
	
	@Transient
	public List<SaphirFunctionGrant> saphirFunctionGrants;
	public List<SaphirFunctionGrant> getSaphirFunctionGrants() {
		return saphirFunctionGrants;
	}
	public void setSaphirFunctionGrants(List<SaphirFunctionGrant> saphirFunctionGrants) {
		this.saphirFunctionGrants = saphirFunctionGrants;
	}

	// .---------------------------------------------------------------------------. //


	private static final long serialVersionUID = 1L;


	// .---------------------------------------------------------------------------. //

}
