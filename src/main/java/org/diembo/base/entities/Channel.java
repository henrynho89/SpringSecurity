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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;


@Entity
@Table( name = "CHANNEL", 
uniqueConstraints={
		@UniqueConstraint(name="U_CHANNEL__INDEX__INST", columnNames={"CHANNELINDEX", "INSTITUTION_ID"}), 
		@UniqueConstraint(name="U_CHANNEL__CODE__INST", columnNames={"CHANNEL_CODE", "INSTITUTION_ID"})
	}
)
public class Channel extends GenericEntity
{
	@Override
	public Long getId() {
		return getChannel_id();
	}
	@Override
	public void setIdToNull() {
		setChannel_id(null);
	}
	
	@Column(name = "CHANNEL_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long channel_id;
	public Long getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(Long channel_id) {
		this.channel_id = channel_id;
	}


	@Column(name = "CHANNELINDEX", nullable=false)
	private Byte channelIndex;
	public Byte getChannelIndex() {
		return channelIndex;
	}
	public void setChannelIndex(Byte channelIndex) {
		this.channelIndex = channelIndex;
	}


	@Column(name = "CHANNEL_CODE", length=30, nullable=false)
	private String channel_code;
	public void setChannelCode(String value) {
		this.channel_code = value;
	}
	public String getChannelCode(){
		return this.channel_code;
	}


	@Column(name = "NAME", length=140, nullable=false)
	private String name;
	public void setName(String value) {
		this.name = value;
	}
	public String getName(){
		return this.name;
	}


	@Column(name = "RANK", nullable=false)
	private Long rank;
	public void setRank(Long value) {
		this.rank = value;
	}
	public Long getRank(){
		return this.rank;
	}
	

	@Column(name = "HOLD", nullable = false)
	private Long hold = 0L;
	public void setHold(Long value) {
		this.hold = value;
	}
	public Long getHold() {
		return this.hold;
	}
	
	public void setHoldAsBoolean(boolean value) {
		if (value) {
			this.hold = 1L;
		} else {
			this.hold = 0L;
		}
	}
	public boolean getHoldAsBoolean() {
		return (this.hold == 1L);
	}
	
	@Column(name = "ENABLE_TOKEN_VALIDATION", nullable=true)
	private Boolean enableTokenValidation;
	public void setEnableTokenValidation(Boolean enableTokenValidation) {
		this.enableTokenValidation = enableTokenValidation;
	}
	public Boolean getEnableTokenValidation(){
		return this.enableTokenValidation;
	}
	
	@Column(name = "ENABLE_OTP_VALIDATION", nullable=true)
	private Boolean enableOtpValidation;
	public void setEnableOtpValidation(Boolean enableOtpValidation) {
		this.enableOtpValidation = enableOtpValidation;
	}
	public Boolean getEnableOtpValidation(){
		return this.enableOtpValidation;
	}
	

	

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~..~~~~~~~~. //

	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_CHANNEL__INST"), nullable=false)
	private Institution institution;
	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	
	@Transient
	private Boolean enableOtpValidationNoLongerNeeded = false;
	public Boolean getEnableOtpValidationNoLongerNeeded() {
		return enableOtpValidationNoLongerNeeded==null?false:enableOtpValidationNoLongerNeeded;
	}
	public void setEnableOtpValidationNoLongerNeeded(Boolean enableOtpValidationNoLongerNeeded) {
		this.enableOtpValidationNoLongerNeeded = enableOtpValidationNoLongerNeeded;
	}

	private static final long serialVersionUID = 1L;
}
