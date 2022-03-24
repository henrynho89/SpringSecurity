package org.diembo.base.msg;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;


	private String					reference		;
	private String					reconcNumber	;
	private Date					reconcDate		;
	private Code					code			;
	private String					reason			;
	private String					internalReason	;   //used to convert the error code in Bred DPCS case 
	private String					message			;
	private String[]				variables		;


	public static enum Code {
		Accepted			("Acceptée"),
		AlreadyProcessed	("Déjà traité"),
		Canceled			("Annulée"),
		Declined			("Déclinée"),
		Error				("Erreur"),
		InProgress			("En cours de traitement"),
		NotFound			("Non trouvé"),
		TimedOut			("Timeout"),
		TimedOut_Level_2	("TimedOut_Level_2"),
		Unknown				("Non confirmée"),
		;
		public String getLabel() {return label ; }
		private Code(String label){this.label = label ;}
		private String label ;
	}


	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}

	
	public String getReconcNumber() {
		return reconcNumber;
	}
	public void setReconcNumber(String reconcNumber) {
		this.reconcNumber = reconcNumber;
	}

	
	public Date getReconcDate() {
		return reconcDate;
	}
	public void setReconcDate(Date reconcDate) {
		this.reconcDate = reconcDate;
	}

	
	public Code getCode() {
		return code;
	}
	public void setCode(Code code) {
		this.code = code;
	}

	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	public String[] getVariables() {
		return variables;
	}
	public void setVariables(String[] variables) {
		this.variables = variables;
	}
	
	public String getInternalReason() {
		return internalReason;
	}
	public void setInternalReason(String internalReason) {
		this.internalReason = internalReason;
	}

	public void assignTo ( Response destination ) {
		destination.setCode			(this.getCode			());
		destination.setMessage		(this.getMessage		());
		destination.setReason		(this.getReason			());
		destination.setReconcDate	(this.getReconcDate		());
		destination.setReconcNumber	(this.getReconcNumber	());
		destination.setReference	(this.getReference		());
	}

}
