package org.diembo.base.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.diembo.entities.GenericEntity;
import org.diembo.entities.Persons;
import org.diembo.entities.QuestionnaireVersion;

@Entity
public class Interview extends GenericEntity{

	@Column(name = "ID", nullable=false)
	@GeneratedValue
	private Long id;

	@Column(name = "DATE", length=30)
	private Date date;
	
	@Column(name = "COMPUTED_GRADE", length=30, nullable=false)
	private Double computedGrade;

	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Persons	person;
	
	@ManyToOne
	@JoinColumn(name="QUESTIONNAIRE_VERSION_ID")
	private QuestionnaireVersion questionnaireVersion;
	
	@Transient
	private List<InterviewAnswer>	questionnaireSheetAnswers;


	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIdToNull() {
		// TODO Auto-generated method stub
		
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getComputedGrade() {
		return computedGrade;
	}

	public void setComputedGrade(Double computedGrade) {
		this.computedGrade = computedGrade;
	}

	public Persons getPerson() {
		return person;
	}

	public void setPerson(Persons person) {
		this.person = person;
	}

	public QuestionnaireVersion getQuestionnaireVersion() {
		return questionnaireVersion;
	}

	public void setQuestionnaireVersion(QuestionnaireVersion questionnaireVersion) {
		this.questionnaireVersion = questionnaireVersion;
	}

	public List<InterviewAnswer> getQuestionnaireSheetAnswers() {
		return questionnaireSheetAnswers;
	}

	public void setQuestionnaireSheetAnswers(List<InterviewAnswer> questionnaireSheetAnswers) {
		this.questionnaireSheetAnswers = questionnaireSheetAnswers;
	}

	public void setId(Long id) {
		this.id = id;
	}



	private static final long serialVersionUID = 1L;

}
