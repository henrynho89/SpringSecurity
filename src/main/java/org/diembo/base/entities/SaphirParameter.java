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
@Table( name = "SAPHIRPARAMETER", 
	uniqueConstraints={
		@UniqueConstraint(name="AK_UI_SAPHIRPARAMETER_SAPHIRPA", columnNames={"SAPHIRPARAMETER_CODE"})
	}
)	
public class SaphirParameter extends GenericEntity {

	private static final long serialVersionUID = 1L;
	
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof SaphirParameter)) return false;
		SaphirParameter other = (SaphirParameter) obj;
		if (this.getSaphirparameter_id() == null) {
			if (other.getSaphirparameter_id() != null)return false;
		} else if (! this.getSaphirparameter_id().equals(other.getSaphirparameter_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getSaphirparameter_id() == null) ? 0 : this.getSaphirparameter_id().hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return getSaphirparameter_id();
	}
	@Override
	public void setIdToNull() {
		setSaphirparameter_id(null);
	}

	@Column(name = "SAPHIRPARAMETER_ID", nullable=false)
	@TableGenerator(name = "AdminTokenGenerator", table = "TOKENSERIE", pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "AdminSerie")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "AdminTokenGenerator")
	protected Long saphirparameter_id;
	public void setSaphirparameter_id(Long value) {
		this.saphirparameter_id = value;
	}
	public Long getSaphirparameter_id(){
		return this.saphirparameter_id;
	}


	@Column(name = "SAPHIRPARAMETER_CODE", length=30, nullable=false)
	protected String code;
	public void setCode(String value) {
		this.code = value;
	}
	public String getCode(){
		return this.code;
	}


	@Column(name = "NAME", length=140, nullable=false)
	protected String name;
	public void setName(String value) {
		this.name = value;
	}
	public String getName(){
		return this.name;
	}


	@Column(name = "VALUE", length=280, nullable=false)
	protected String value;
	public void setValue(String value) {
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
	
	@ManyToOne
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_SAPHIRPARAMETER_INSTITUTION"))
	protected Institution institution ;

	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}
	
}
