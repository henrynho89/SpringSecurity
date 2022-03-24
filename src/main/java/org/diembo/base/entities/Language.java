package org.diembo.base.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;



@Entity
@Table( name = "LANGUAGE", 
		uniqueConstraints={
			@UniqueConstraint(name="AK_LANGUAGE_CODE_LANGUAGE", columnNames={"LANGUAGE_CODE"})
		}
)
public class Language extends GenericEntity
{
	//Generate Class Body.
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Language)) return false;
		Language other = (Language) obj;
		if (this.getLanguage_id() == null) {
			if (other.getLanguage_id() != null)return false;
		} else if (! this.getLanguage_id().equals(other.getLanguage_id()))return false;
		return true;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getLanguage_id() == null) ? 0 : this.getLanguage_id().hashCode());
		return result;
	}

	@Override
	public Long getId() {
		return getLanguage_id();
	}
	@Override
	public void setIdToNull() {
		setLanguage_id(null);
	}

	@Column(name = "LANGUAGE_ID", nullable=false)
	@TableGenerator(name = "AdminTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "AdminSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "AdminTokenGenerator")
	protected Long language_id;
	public void setLanguage_id(Long value) {
		this.language_id = value;
	}
	public Long getLanguage_id(){
		return this.language_id;
	}


	@Column(name = "LANGUAGE_CODE", length=30, nullable=false)
	protected String language_code;
	public void setLanguageCode(String value) {
		this.language_code = value;
	}
	public String getLanguageCode(){
		return this.language_code;
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
	
	@Column(name = "ISO_CODE_639_3", length=3, nullable=false)
    protected String iso_code_639_3;
	public String getIso_code_639_3() {
		return iso_code_639_3;
	}
	public void setIso_code_639_3(String iso_code_639_3) {
		this.iso_code_639_3 = iso_code_639_3;
	}

	private static final long serialVersionUID = 1L;

}
