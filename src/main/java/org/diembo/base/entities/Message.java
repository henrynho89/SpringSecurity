package org.diembo.base.entities;

import java.util.ArrayList;
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


@Entity
@Table( name = "MESSAGE", 
	uniqueConstraints={
		@UniqueConstraint(name="U_MESSAGE_CODE", columnNames={"MESSAGE_CODE"})
	}
)	
public class Message extends GenericEntity
{

	// .--------..--------..--------..--------..--------..--------..--------. //
	// .--------..--------..--------..--------..--------..--------..--------. //
	@Override
	public Long getId() {
		return getMessage_id();
	}
	@Override
	public void setIdToNull() {
		setMessage_id(null);
	}
	// .--------..--------..--------..--------..--------..--------..--------. //
	
	// .--------..--------..--------..--------..--------..--------..--------. //
	// .--------..--------..--------..--------..--------..--------..--------. //
	@Column(name = "MESSAGE_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long message_id;

	@Column(name = "MESSAGE_CODE", length=100, nullable=false)
	private String message_code;

	@Column(name = "DEFAULTVALUE", length=600, nullable=false)
	private String defaultValue;
	
	@Column(name = "TITLE", length=100, nullable=true)
	private String title;
	
	@Column(name = "MESSAGE_CODE_EXTERNAL", length=100, nullable=true)
	private String messageCodeExternal;
	
	@Transient
	private List<InstitutionMessage>	institutionMessages;

	
	@Transient
	private String value;
	// .--------..--------..--------..--------..--------..--------..--------. //


	
	public Long getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Long message_id) {
		this.message_id = message_id;
	}

	// ------------------------------------------------------------
	public String getMessageCode() {
		return message_code;
	}
	public void setMessageCode(String messageCode) {
		this.message_code = messageCode;
	}

	// ------------------------------------------------------------
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	// .--------..--------..--------. //
	public String getMessageCodeExternal() {
		return messageCodeExternal;
	}
	public void setMessageCodeExternal(String messageCodeExternal) {
		this.messageCodeExternal = messageCodeExternal;
	}
	// ------------------------------------------------------------
	public List<InstitutionMessage> getInstitutionMessages() {
		return institutionMessages;
	}
	public void setInstitutionMessages(List<InstitutionMessage> institutionMessages) {
		this.institutionMessages = institutionMessages;
	}
	public void addInstitutionMessages(InstitutionMessage institutionMessage) {
		if ( this.institutionMessages == null ) {
			this.institutionMessages = new ArrayList<InstitutionMessage>();
		}
		this.institutionMessages.add(institutionMessage);
	}

	
	// ------------------------------------------------------------
	@Override
	public String toString() {
		String result = "Message [message_code: " + message_code + "]" ;
		return result ;
	}


	
	private static final long serialVersionUID = 1L;
}
