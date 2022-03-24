package org.diembo.base.entities.impl;

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

import org.diembo.base.entities.GenericEntity;

@Entity
@Table( name = "INTERVIEW_ANSWER", 
	uniqueConstraints={
		//@UniqueConstraint(name="U_QUESTIONNAIRE_SHEET_ANSWERS_CODE", columnNames={"CODE"})
	}
)
public class InterviewAnswer extends GenericEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long id;

	@Column(name = "VALUE", length=200)
	private String value;

	@ManyToOne
	@JoinColumn(name="INTERVIEW_ID", foreignKey=@ForeignKey(name="FK_INTERVIEW_ANSWERS_INTERVIEW"))
	private Interview interview;
	
	@ManyToOne
	@JoinColumn(name="ANSWER_ID", foreignKey=@ForeignKey(name="FK_INTERVIEW_ANSWERS_ANSWER"))
	private Answer answer;
	
	@ManyToOne
	@JoinColumn(name="QUESTION_ID", foreignKey=@ForeignKey(name="FK_INTERVIEW_ANSWERS_QUESTION"))
	private Question question;

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview questionnaireSheet) {
		this.interview = questionnaireSheet;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setIdToNull() {
		setId(null);
		
	}
	
	public InterviewAnswer() {
		super();
	}

	public InterviewAnswer(String value, Interview interview, Answer answer,
			Question question) {
		super();
		this.value = value;
		this.interview = interview;
		this.answer = answer;
		this.question = question;
	}

}
