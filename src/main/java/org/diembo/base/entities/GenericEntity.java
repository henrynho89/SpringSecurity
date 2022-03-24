package org.diembo.base.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.diembo.base.utils.ObjectUtils;

@MappedSuperclass
public abstract class GenericEntity implements Serializable {
	// ------------------------------------------------------- //
	// ------------------------------------------------------- //
	@Column(name = "LASTUPDATE", nullable=false)@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	// -----------------------//
	@Column(name = "USER_CODE", nullable=false, length = 30)
	private String userCode;
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	// -----------------------//
	@Column(name = "VERSION", nullable=false)
	private Long version;
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	// ------------------------------------------------------- //
	
	
	// ------------------------------------------------------- //
	// ------------------------------------------------------- //
	public abstract Long getId();
	public abstract void setIdToNull();
	// ------------------------------------------------------- //
	
	
	// ------------------------------------------------------- //
	@Transient
	private Boolean inserted = false;
	@Transient
	private Boolean updated = false;
	@Transient
	private Boolean deleted = false;
	
	public Boolean getInserted() {
		return ObjectUtils.isTrue(inserted);
	}
	public void setInserted(Boolean inserted) {
		this.inserted = inserted;
	}
	public Boolean getUpdated() {
		return ObjectUtils.isTrue(updated);
	}
	public void setUpdated(Boolean updated) {
		this.updated = updated;
	}
	public Boolean getDeleted() {
		return ObjectUtils.isTrue(deleted);
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	
	// ------------------------------------------------------- //
	private static final long serialVersionUID = 1L ;
	// ------------------------------------------------------- //
}
