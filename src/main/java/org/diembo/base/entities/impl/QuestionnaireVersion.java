package org.diembo.base.entities.impl;

import java.util.Date;
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
import org.diembo.entities.Persons;


@Entity
@Table( name = "QUESTIONNAIRE_VERSION", 
	uniqueConstraints={
		@UniqueConstraint(name="U_QUESTIONNAIREVERSION_CODE", columnNames={"CODE"})
	}
)	
public class QuestionnaireVersion extends GenericEntity
{

	// .--------..--------..--------..--------..--------..--------..--------. //
	// .--------..--------..--------..--------..--------..--------..--------. //
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setIdToNull() {
		setId(null);
	}
	// .--------..--------..--------..--------..--------..--------..--------. //
	
	// .--------..--------..--------..--------..--------..--------..--------. //
	// .--------..--------..--------..--------..--------..--------..--------. //
	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long id;

	@Column(name = "CODE", length=30, nullable=false)
	private String code;
	
	@Column(name = "ENABLED")
	private Boolean enabled;
	
	@ManyToOne
	@JoinColumn(name="CREATED_BY_PERSON", foreignKey=@ForeignKey(name="FK_QUESTIONNAIRE_CREATED_BY_PERSON"), nullable=false)
	private Persons	createdByPerson;
	
	@Column(name = "CREATION_DATE",  nullable=false)
	private Date creationDate;
	
	@ManyToOne
	@JoinColumn(name="ENABLED_BY_PERSON", foreignKey=@ForeignKey(name="FK_QUESTIONNAIRE_ENABLED_BY_PERSON"))
	private Persons	enabledByPerson;
	

	@Column(name = "ENABLED_DATE")
	private Date enabledDate;
	
	@ManyToOne
	@JoinColumn(name="QUESTIONNAIRE_ID", foreignKey=@ForeignKey(name="FK_QUESTIONNAIRE_VERSION_QUESTIONNAIRE"), nullable=false)
	private Questionnaire questionnaire;
	
	@Transient
	private List<Question>	questions;
	
	@Transient
	private List<Interview> interviews;

	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public Boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Persons getCreatedByPerson() {
		return createdByPerson;
	}
	public void setCreatedByPerson(Persons createdBy) {
		this.createdByPerson = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date createdAt) {
		this.creationDate = createdAt;
	}
	public Persons getEnabledByPerson() {
		return enabledByPerson;
	}
	public void setEnabledByPerson(Persons enabledBY) {
		this.enabledByPerson = enabledBY;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}
	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}
	public List<Interview> getInterviews() {
		return interviews;
	}
	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getEnabledDate() {
		return enabledDate;
	}
	public void setEnabledDate(Date enabledDate) {
		this.enabledDate = enabledDate;
	}

	private static final long serialVersionUID = 1L;
}
