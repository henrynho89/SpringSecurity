package org.diembo.base.entities.impl;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.diembo.base.entities.GenericEntity;

@Entity
@Table( name = "QUESTION", 
	uniqueConstraints={
		//@UniqueConstraint(name="U_QUESTION_CODE", columnNames={"CODE"})
	}
)
public class Question extends GenericEntity{
	
	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long id;

	@Column(name = "DESCRIPTION", length=255)
	private String description;
	
	@Column(name = "QUESTION_TYPE", nullable = false, length=10)
	@Enumerated(EnumType.STRING)
	private QuestionType questionType;
	
	@Column(name = "RANK")
	private Integer rank;
	
	@Column(name = "WEIGHT")
	private Double weight;
	
	@ManyToOne
	@JoinColumn(name="QUESTIONNAIRE_VERSION_ID", foreignKey=@ForeignKey(name="FK_QUESTION_QUESTIONNAIRE_VERSION"))
	private QuestionnaireVersion questionnaireVersion;
	
	@Transient
	private List<InterviewAnswer> interviewAnswers;
	
	@Transient
	private List<Answer> answers;
	
	@Transient
	private List<QuestionCondition> questionConditions;


	public static enum QuestionType {
		MCQ			("MCQ"),
		MCQ_RANDOM	("MCQ_RANDOM"),
		RATING		("RATING")
		;
		public String getLabel() { return label; }
		private String label ;
		private QuestionType(String label) { this.label = label ; }
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public QuestionnaireVersion getQuestionnaireVersion() {
		return questionnaireVersion;
	}

	public void setQuestionnaireVersion(QuestionnaireVersion questionnaireVersion) {
		this.questionnaireVersion = questionnaireVersion;
	}

	public List<InterviewAnswer> getInterviewAnswers() {
		return interviewAnswers;
	}

	public void setInterviewAnswers(List<InterviewAnswer> interviewAnswers) {
		this.interviewAnswers = interviewAnswers;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<QuestionCondition> getQuestionConditions() {
		return questionConditions;
	}

	public void setQuestionConditions(List<QuestionCondition> questionConditions) {
		this.questionConditions = questionConditions;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setIdToNull() {
		setId(null);
	}

	private static final long serialVersionUID = 1L;

}
