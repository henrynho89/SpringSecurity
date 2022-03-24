package org.diembo.base.entities.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.diembo.base.entities.GenericEntity;


@Entity
@Table( name = "QUESTIONNAIRE",
	uniqueConstraints={
		@UniqueConstraint(name="U_QUESTIONNAIRE_CODE", columnNames={"CODE"})
	}
)	
public class Questionnaire extends GenericEntity
{
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setIdToNull() {
		setId(null);
		
	}
	// .--------..--------..--------..--------..--------..--------..--------. //
		@Column(name = "ID", nullable=false)
		@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
				pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
		@Id
		@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
		private Long id;

		@Column(name = "CODE", length=30, nullable=false)
		private String code;

		@Column(name = "DESCRIPTION", length=255)
		private String description;
		
		@Column(name = "DONT_SHOW_OVERRIDE_PERIOD",  nullable=true)
		private Integer dontShowOverridePeriod;
		   
	    @Column(name = "DONT_SHOW_OVERRIDE_DATE", nullable=true)
	    private Date dontShowOverrideDate;
		
	    
		@Transient
		private List<QuestionnaireVersion>	questionnaireVersions;
		
	// .--------..--------..--------..--------..--------..--------..--------. //
	// .--------..--------..--------..--------..--------..--------..--------. //
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<QuestionnaireVersion> getQuestionnaireVersions() {
		return questionnaireVersions;
	}

	public void setQuestionnaireVersions(List<QuestionnaireVersion> questionnaireVersions) {
		this.questionnaireVersions = questionnaireVersions;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// .--------..--------..--------..--------..--------..--------..--------. //
	
	public Integer getDontShowOverridePeriod() {
		return dontShowOverridePeriod;
	}

	public void setDontShowOverridePeriod(Integer dontShowOverridePeriod) {
		this.dontShowOverridePeriod = dontShowOverridePeriod;
	}

	public Date getDontShowOverrideDate() {
		return dontShowOverrideDate;
	}

	public void setDontShowOverrideDate(Date dontShowOverrideDate) {
		this.dontShowOverrideDate = dontShowOverrideDate;
	}
	private static final long serialVersionUID = 1L;
}
