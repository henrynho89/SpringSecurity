package org.diembo.base.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;


@Entity
@Table( name = "SERVICEGROUP",
	uniqueConstraints={ 
		@UniqueConstraint(name="U_SERVICEGROUP__CODE__INST", columnNames={"SERVICEGROUP_CODE", "INSTITUTION_ID"})
	}
)
public class ServiceGroup extends GenericEntity
{
	//Generate Class Body.
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof ServiceGroup)) return false;
		ServiceGroup other = (ServiceGroup) obj;
		if (this.getServiceGroup_id() == null) {
			if (other.getServiceGroup_id() != null)return false;
		} else if (! this.getServiceGroup_id().equals(other.getServiceGroup_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getServiceGroup_id() == null) ? 0 : this.getServiceGroup_id().hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return getServiceGroup_id();
	}
	@Override
	public void setIdToNull() {
		setServiceGroup_id(null);
	}

	@Column(name = "SERVICEGROUP_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	protected Long serviceGroup_id;
	public void setServiceGroup_id(Long value) {
		this.serviceGroup_id = value;
	}
	public Long getServiceGroup_id(){
		return this.serviceGroup_id;
	}


	@Column(name = "SERVICEGROUP_CODE", length=30, nullable=false)
	protected String serviceGroup_code;
	public void setServiceGroupCode(String value) {
		this.serviceGroup_code = value;
	}
	public String getServiceGroupCode(){
		return this.serviceGroup_code;
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
	
	
	@OneToMany(mappedBy="serviceGroup")   
	public Collection<Service> services;
	public Collection<Service> getServices() {
		return services;
	}
	public void setServices(Collection<Service> services) {
		this.services = services;
	}

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_SERVICEGROUP__INST"), nullable=false)
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
