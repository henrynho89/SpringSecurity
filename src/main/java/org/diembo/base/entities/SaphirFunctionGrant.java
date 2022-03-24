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

import org.diembo.base.entities.security.Profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@Entity
@Table( name = "SAPHIRFUNCTIONGRANT", 
	uniqueConstraints={
		@UniqueConstraint(name="U_SAPHIRFUNCTIONGRANT_FUN_PROF", columnNames={"SAPHIRFUNCTION_ID", "PROFILE_ID"})
	}
)	
	
public class SaphirFunctionGrant extends GenericEntity {
	
	private static final long serialVersionUID = 1L;
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof SaphirFunctionGrant)) return false;
		SaphirFunctionGrant other = (SaphirFunctionGrant) obj;
		if (this.getSaphirfunctiongrant_id() == null) {
			if (other.getSaphirfunctiongrant_id() != null)return false;
		} else if (! this.getSaphirfunctiongrant_id().equals(other.getSaphirfunctiongrant_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getSaphirfunctiongrant_id() == null) ? 0 : this.getSaphirfunctiongrant_id().hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return getSaphirfunctiongrant_id();
	}
	@Override
	public void setIdToNull() {
		setSaphirfunctiongrant_id(null);
	}

	
	@Column(name = "SAPHIRFUNCTIONGRANT_ID", nullable=false)
	@TableGenerator(name = "AdminTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "AdminSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "AdminTokenGenerator")
	protected Long saphirfunctiongrant_id;
	public void setSaphirfunctiongrant_id(Long value) {
		this.saphirfunctiongrant_id = value;
	}
	public Long getSaphirfunctiongrant_id(){
		return this.saphirfunctiongrant_id;
	}

	@Column(name = "HOLD", nullable=false)
	protected Boolean hold = false;
	public Boolean getHold() {
		return hold;
	}
	public void setHold(Boolean hold) {
		this.hold = hold;
	}

	@Column(name = "DESCRIPTION", length=256)
	protected String description;
	public void setDescription(String value) {
		this.description = value;
	}
	public String getDescription(){
		return this.description;
	}
	
	@ManyToOne
	@JoinColumn(name = "SAPHIRFUNCTION_ID", foreignKey=@ForeignKey(name="FK_SAPHIRFU_SAFUPRSAF_SAPHIRFU"), nullable=false)
	public SaphirFunction saphirFunction;
	public SaphirFunction getSaphirFunction() {
		return saphirFunction;
	}
	public void setSaphirFunction(SaphirFunction saphirFunction) {
		this.saphirFunction = saphirFunction;
	}

	@ManyToOne
	@JoinColumn(name = "PROFILE_ID", foreignKey=@ForeignKey(name="FK_SAPHIRFU_PROPROSAF_PROFILE"), nullable=false)
	public Profile profile;
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}	
}
