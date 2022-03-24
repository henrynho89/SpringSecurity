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

import org.diembo.base.entities.Contract;
import org.diembo.base.entities.GenericEntity;
import org.diembo.entities.Persons;

@Entity
@Table( name = "INTERVIEW", 
	uniqueConstraints={
		//@UniqueConstraint(name="U_QUESTIONNAIRESHEET_CODE", columnNames={"CODE"})
	}
)
public class Interview extends GenericEntity{

	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long id;

	@Column(name = "DATE", length=30)
	private Date date;
	
	@Column(name = "COMPUTED_GRADE", length=30, nullable=false)
	private Double computedGrade;

	@ManyToOne
	@JoinColumn(name="PERSON_ID", foreignKey=@ForeignKey(name="FK_INTERVIEW_PERSONS"))
	private Persons	person;
	
	@ManyToOne
	@JoinColumn(name="CONTRACT_ID", foreignKey=@ForeignKey(name="FK_INTERVIEW_CONTRACT"))
	private Contract contract;
	
	@ManyToOne
	@JoinColumn(name="QUESTIONNAIRE_VERSION_ID", foreignKey=@ForeignKey(name="FK_INTERVIEW_QUESTIONNAIRE_VERSION"))
	private QuestionnaireVersion questionnaireVersion;
	
	@Transient
	private List<InterviewAnswer>	questionnaireSheetAnswers;


	public Persons getPerson() {
		return person;
	}

	public void setPerson(Persons person) {
		this.person = person;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public QuestionnaireVersion getQuestionnaireVersion() {
		return questionnaireVersion;
	}

	public void setQuestionnaireVersion(QuestionnaireVersion questionnaireVersion) {
		this.questionnaireVersion = questionnaireVersion;
	}

	public void setComputedGrade(Double computedGrade) {
		this.computedGrade = computedGrade;
	}

	public Double getComputedGrade() {
		return computedGrade;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setIdToNull() {
		setId(null);
		
	}
	public Interview(Date date, Double computedGrade, Persons person, Contract contract,
			QuestionnaireVersion questionnaireVersion) {
		super();
		this.date = date;
		this.computedGrade = computedGrade;
		this.person = person;
		this.contract = contract;
		this.questionnaireVersion = questionnaireVersion;
	}

	private static final long serialVersionUID = 1L;
}
