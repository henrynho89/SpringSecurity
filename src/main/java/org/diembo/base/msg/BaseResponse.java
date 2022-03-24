package org.diembo.base.msg;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.diembo.base.utils.BasicItem;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
public class BaseResponse implements Serializable{


	private MessageInfo	messageInfo			= new MessageInfo();
	private Response	response			= new Response();

	private Long 	transactionId 			;
	private Long 	contractWalletItemId 	;
	private Balance	balance					;
	private Double	fees					;
	private Double	commission				;
	private String	reference				;	
	

	private String	strArg1					;
	private String	strArg2					;
	private String	strArg3					;
	private String	strArg4					;

	private Boolean	blnArg1					;
	private Boolean	blnArg2					;

	private Double	nbrArg1					;
	private Double	nbrArg2					;
	
	private Long	lngArg1					;
	private Long	lngArg2					;	
	
	private Date 	dteArg1      			;
	private Date 	dteArg2      			;
	
	private Long	idArg1					;


	private List<BasicItem>			items	;
	private List<Record>			records ;

	
	
	public List<BasicItem> getItems() {
		return items;
	}
	public List<Record> getRecords() {
		return records;
	}
	public void setRecords(List<Record> records) {
		this.records = records;
	}
	public void setItems(List<BasicItem> items) {
		this.items = items;
	}
	
	public Long getIdArg1() {
		return idArg1;
	}

	public void setIdArg1(Long idArg1) {
		this.idArg1 = idArg1;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	// ------------------------------------------------------- //
	// ------------------------------------------------------- //
	public Long getContractWalletItemId() {
		return contractWalletItemId;
	}

	public void setContractWalletItemId(Long contractWalletItemId) {
		this.contractWalletItemId = contractWalletItemId;
	}

	
	// ------------------------------------------------------- //
	public Balance getBalance() {
		return balance;
	}

	public void setBalance(Balance balance) {
		this.balance = balance;
	}
	
	
	
	// ------------------------------------------------------- //
	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}


	

	
	
	
	
	public Double getCommission() {
		return commission;
	}
	public void setCommission(Double commission) {
		this.commission = commission;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getStrArg1() {
		return strArg1;
	}

	public void setStrArg1(String strArg1) {
		this.strArg1 = strArg1;
	}

	public String getStrArg2() {
		return strArg2;
	}

	public void setStrArg2(String strArg2) {
		this.strArg2 = strArg2;
	}

	
	
	
	public String getStrArg3() {
		return strArg3;
	}

	public void setStrArg3(String strArg3) {
		this.strArg3 = strArg3;
	}

	public String getStrArg4() {
		return strArg4;
	}

	public void setStrArg4(String strArg4) {
		this.strArg4 = strArg4;
	}

	public Double getNbrArg1() {
		return nbrArg1;
	}

	public void setNbrArg1(Double nbrArg1) {
		this.nbrArg1 = nbrArg1;
	}

	public Double getNbrArg2() {
		return nbrArg2;
	}

	public void setNbrArg2(Double nbrArg2) {
		this.nbrArg2 = nbrArg2;
	}

	public Date getDteArg1() {
		return dteArg1;
	}

	public void setDteArg1(Date dteArg1) {
		this.dteArg1 = dteArg1;
	}

	public Date getDteArg2() {
		return dteArg2;
	}

	public void setDteArg2(Date dteArg2) {
		this.dteArg2 = dteArg2;
	}

	public Boolean getBlnArg1() {
		return blnArg1;
	}
	public void setBlnArg1(Boolean blnArg1) {
		this.blnArg1 = blnArg1;
	}
	public Boolean getBlnArg2() {
		return blnArg2;
	}
	public void setBlnArg2(Boolean blnArg2) {
		this.blnArg2 = blnArg2;
	}
	
	
	public Long getLngArg1() {
		return lngArg1;
	}
	public void setLngArg1(Long lngArg1) {
		this.lngArg1 = lngArg1;
	}
	public Long getLngArg2() {
		return lngArg2;
	}
	public void setLngArg2(Long lngArg2) {
		this.lngArg2 = lngArg2;
	}
	// ------------------------------------------------------- //
	// ------------------------------------------------------- //
	public MessageInfo getMessageInfo() {
		return messageInfo;
	}
	public void setMessageInfo(MessageInfo messageInfo) {
		this.messageInfo = messageInfo;
	}

	// ----------------------- //
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	// ------------------------------------------------------- //

	// ------------------------------------------------------- //
	// ------------------------------------------------------- //
	public BaseResponse() {}

	public BaseResponse(BaseRequest baseRequest) {
		if ( baseRequest != null ) {
			messageInfo = baseRequest.getMessageInfo() ;
		//	messageInfo.setDestination(baseRequest.getMessageInfo().getOriginator());
		//	messageInfo.setOriginator(baseRequest.getMessageInfo().getDestination());
		}
	}
	// ------------------------------------------------------- //

	private static final long serialVersionUID = 1L;}
