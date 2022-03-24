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


@Entity
@Table( name = "DEVICE_APP_VERSION")
public class DeviceAppVersion extends GenericEntity {
		 
		@Column(name = "ID", nullable=false)
		@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
				pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
		@Id
		@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
		private Long id;

		@ManyToOne
		@JoinColumn(name="DEVICE_ID", foreignKey=@ForeignKey(name="FK_DEVICE_APP_VERSION__DEVICE"))
		private Device device;
		 
		@ManyToOne
		@JoinColumn(name="APP_VERSION_ID", foreignKey=@ForeignKey(name="FK_DEVICE_APP_VERSION__APP_VERSION"))
		private AppVersion appVersion;

		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}


		public Device getDevice() {
			return device;
		}
		public void setDevice(Device device) {
			this.device = device;
		}
		public AppVersion getAppVersion() {
			return appVersion;
		}
		public void setAppVersion(AppVersion appVersion) {
			this.appVersion = appVersion;
		}
		@Override
		public void setIdToNull() {
			// TODO Auto-generated method stub
			
		}
	
		private static final long serialVersionUID = 1L;

}