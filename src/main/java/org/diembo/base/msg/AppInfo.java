package org.diembo.base.msg;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AppInfo implements Serializable {
	
  private String appCode;
  private String appVersion;
  private String appInstitutionCode;

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getAppInstitutionCode() {
		return appInstitutionCode;
	}

	public void setAppInstitutionCode(String appInstitutionCode) {
		this.appInstitutionCode = appInstitutionCode;
	}

	private static final long serialVersionUID = 1L;

}
