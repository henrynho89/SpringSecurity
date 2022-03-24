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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)


@Entity
@Table( name = "INSTITUTIONMESSAGE", 
		uniqueConstraints={
			@UniqueConstraint(name="U_INSTITUTIONMESSAGE_1", columnNames={"MESSAGE_ID" , "LANGUAGE_ID", "INSTITUTION_ID"})
		}

)
public class InstitutionMessage extends GenericEntity {
	
	
	@Override
	public Long getId() {
		return getInstitutionMessage_id();
	}
	@Override
	public void setIdToNull() {
		setInstitutionMessage_id(null);
	}
	
	
	
	
	@Column(name = "INSTITUTIONMESSAGE_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long institutionMessage_id;

	@ManyToOne
	@JoinColumn(name="MESSAGE_ID", foreignKey=@ForeignKey(name="FK_INSTITMESSAGE_MESSAGE"), nullable=false)
	private Message message;
	
	@ManyToOne
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_INSTITMESSAGE_INSTITUTION"), nullable=true)
	private Institution institution;
	
	@ManyToOne
	@JoinColumn(name="LANGUAGE_ID", foreignKey=@ForeignKey(name="FK_INSTITMESSAGE_LANGUAGE"), nullable=true)
	private Language language;
	
	@Column(name = "VALUE", length=600, nullable=false)
	private String value;
	
	@Column(name = "TITLE", length=100, nullable=true)
	private String title;
	

	
	
	public Long getInstitutionMessage_id() {
		return institutionMessage_id;
	}
	public void setInstitutionMessage_id(Long institutionMessage_id) {
		this.institutionMessage_id = institutionMessage_id;
	}

	
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}

	
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}

	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	
	@Override
	public String toString() {
		String result = "InstitutionMessage [institution: " + institution.getInstitutionCode() + ", language: " + language.getLanguageCode() + ", message: " + message.getMessageCode() + "]" ;
		return result ;
	}
	
	
	
	private static final long serialVersionUID = 1L;
}
