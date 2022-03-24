package org.diembo.base.entities;

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
import javax.persistence.UniqueConstraint;

import org.diembo.base.utils.GenerateTokenAction;



@Entity
@Table(
	name = "CHANNELSERVICE",
	uniqueConstraints={
		@UniqueConstraint(name="U_CHANNELSERVICE_CH_SRV", columnNames={"CHANNEL_ID", "SERVICE_ID"})
	}
)
public class ChannelService extends GenericEntity {
	@Override
	public Long getId() {
		return getChannelService_id();
	}

	@Override
	public void setIdToNull() {
		setChannelService_id(null);
	}

	@Column(name = "CHANNELSERVICE_ID", nullable = false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long channelService_id;
	public Long getChannelService_id() {
		return channelService_id;
	}
	public void setChannelService_id(Long channelService_id) {
		this.channelService_id = channelService_id;
	}


	@Column(name = "HOLD", nullable = false)
	private Long hold = 0L;
	public void setHold(Long value) {
		this.hold = value;
	}
	public boolean getHold() {
		return (this.hold == 1L);
	}

	
	@Column(name = "TOKENNEEDED", nullable = true)
	private Boolean tokenNeeded;
	public void setTokenNeeded(Boolean value) {
		this.tokenNeeded = value;
	}
	public Boolean getTokenNeeded() {
		return this.tokenNeeded ;
	}


	@Column(name = "DEFAULT_OTP_LENGTH", nullable = true)
	private Short defaultOtpLength;
	public void setDefaultOtpLength(Short defaultOtpLength) {
		this.defaultOtpLength = defaultOtpLength;
	}
	public Short getDefaultOtpLength() {
		return this.defaultOtpLength ;
	}

	
	@Column(name = "DEFAULT_ACTION", nullable = true, length = 1)@Enumerated(EnumType.STRING)
	private GenerateTokenAction defaultAction;
	public void setDefaultAction(GenerateTokenAction defaultAction) {
		this.defaultAction = defaultAction;
	}
	public GenerateTokenAction getDefaultAction() {
		return this.defaultAction ;
	}


	@Column(name = "DEFAULT_OTP_VALIDITY_PERIOD", nullable = true)
	private Integer defaultOtpValidityPeriod;
	public void setDefaultOtpValidityPeriod(Integer defaultOtpValidityPeriod) {
		this.defaultOtpValidityPeriod = defaultOtpValidityPeriod;
	}
	public Integer getDefaultOtpValidityPeriod() {
		return this.defaultOtpValidityPeriod ;
	}

	
	@Column(name = "PIN_NEEDED", nullable = true)
	private Boolean pinNeeded;
	public Boolean getPinNeeded() {
		return pinNeeded;
	}

	public void setPinNeeded(Boolean pinNeeded) {
		this.pinNeeded = pinNeeded;
	}
	
	@ManyToOne
	@JoinColumn(name="SERVICE_ID", foreignKey=@ForeignKey(name="FK_CHANNELS_TRANSTYPE_SERVICE"), nullable=false)
	
	private Service service;
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	@ManyToOne
	@JoinColumn(name="CHANNEL_ID", foreignKey=@ForeignKey(name="FK_CHANNELS_CHANNEL_C_CHANNEL"), nullable=false)
	private Channel channel;
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	private static final long serialVersionUID = 1L;
}
