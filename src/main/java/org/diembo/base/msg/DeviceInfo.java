package org.diembo.base.msg;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class DeviceInfo implements Serializable {
	
	  private String deviceProtoVer;
	  private String deviceAppliVer;
	  private String deviceModel   ;
	  private String devicePlatform;
	  private String deviceUuid    ;
	  private String deviceVersion ;
	  private String deviceToken   ;
	  private String deviceBrand   ;
	  private String osVersion     ;
	  private String fcmAddress	;


	public String toString() {
		StringBuffer str = new StringBuffer() ;

		str.append("MessageInfo {")
		.append(", ").append("reference=").append(deviceProtoVer)
	
		.append("}");

		return str.toString();
	}


	public String getDeviceProtoVer() {
		return deviceProtoVer;
	}


	public void setDeviceProtoVer(String deviceProtoVer) {
		this.deviceProtoVer = deviceProtoVer;
	}


	public String getDeviceAppliVer() {
		return deviceAppliVer;
	}


	public void setDeviceAppliVer(String deviceAppliVer) {
		this.deviceAppliVer = deviceAppliVer;
	}


	public String getDeviceModel() {
		return deviceModel;
	}


	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}


	public String getDevicePlatform() {
		return devicePlatform;
	}


	public void setDevicePlatform(String devicePlatform) {
		this.devicePlatform = devicePlatform;
	}


	public String getDeviceUuid() {
		return deviceUuid;
	}


	public void setDeviceUuid(String deviceUuid) {
		this.deviceUuid = deviceUuid;
	}


	public String getDeviceVersion() {
		return deviceVersion;
	}


	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}





	public String getDeviceToken() {
		return deviceToken;
	}


	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}


	public String getDeviceBrand() {
		return deviceBrand;
	}


	public void setDeviceBrand(String deviceBrand) {
		this.deviceBrand = deviceBrand;
	}


	public String getOsVersion() {
		return osVersion;
	}


	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}


	public String getFcmAddress() {
		return fcmAddress;
	}
	public void setFcmAddress(String fcmAddress) {
		this.fcmAddress = fcmAddress;
	}



	private static final long serialVersionUID = 1L;
}
