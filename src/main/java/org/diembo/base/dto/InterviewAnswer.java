package org.diembo.base.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.diembo.entities.Answer;
import org.diembo.entities.GenericEntity;
import org.diembo.entities.Interview;
import org.diembo.entities.Question;

@Entity
public class InterviewAnswer extends GenericEntity{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID", nullable=false)
	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "VALUE", length=200)
	private String value;

	@ManyToOne
	@JoinColumn(name="INTERVIEW_ID")
	private Interview interview;
	
	@ManyToOne
	@JoinColumn(name="ANSWER_ID")
	private Answer answer;
	
	@ManyToOne
	@JoinColumn(name="QUESTION_ID")
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

}
