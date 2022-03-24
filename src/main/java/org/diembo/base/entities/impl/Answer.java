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
@Table( name = "ANSWER", 
	uniqueConstraints={
		//@UniqueConstraint(name="U_ANSWER_CODE", columnNames={"CODE"})
	}
)
public class Answer extends GenericEntity{

	private static final long serialVersionUID = 1L;

	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long id;

	@Column(name = "DESCRIPTION", length=255)
	private String description;
	
	@Column(name = "RANK", length=30)
	private Integer rank;
	
	@Column(name = "GRADE", length=30)
	private Double grade;
	
	@ManyToOne
	@JoinColumn(name="QUESTION_ID", foreignKey=@ForeignKey(name="FK_ANSWERS_QUESTION"))
	private Question question;
	
	@Column(name = "USER_INPUT_REQUIRED")
	private Boolean user_input_required;

	public Boolean getUser_input_required() {
		return user_input_required;
	}

	public void setUser_input_required(Boolean user_input_required) {
		this.user_input_required = user_input_required;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer displayRank) {
		this.rank = displayRank;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
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

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setIdToNull() {
		setId(null);
		
	}

}
