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

import org.diembo.entities.Persons;


@Entity
@Table( name = "PERSON_DEVICE_APP",
uniqueConstraints={
		@UniqueConstraint(name="U_PERSON_DEVICE_APP_DEVICE__APP"		, columnNames={"DEVICE_ID"	, "APP_ID"}), 
	})	
public class PersonDeviceApp extends GenericEntity {
		 
		// ---------------------------------------------------------------------- //
		// ---------------------------------------------------------------------- //
		@Column(name = "ID", nullable=false)
		@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
				pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
		@Id
		@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
		private Long id;

		@Column(name = "HOLD" )
		private Boolean hold;

		@Column(name = "key1")
		private String key1;
		
		@Column(name = "key2")
		private String key2;

		@ManyToOne
		@JoinColumn(name="DEVICE_ID", foreignKey=@ForeignKey(name="FK_PERSON_DEVICE_APP__DEVICE"))
		private Device device;

		@ManyToOne
		@JoinColumn(name="PERSON_ID", foreignKey=@ForeignKey(name="FK_PERSON_DEVICE_APP__PERSONS"))
		private Persons person;

		@ManyToOne
		@JoinColumn(name="APP_ID", foreignKey=@ForeignKey(name="FK_PERSON_DEVICE_APP__APP"))
		private App app;

		
		// ---------------------------------------------------------------------- //
		// ---------------------------------------------------------------------- //
		
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

		
		
		public Boolean getHold() {
			return hold;
		}
		public void setHold(Boolean hold) {
			this.hold = hold;
		}
		public String getKey1() {
			return key1;
		}
		public void setKey1(String key1) {
			this.key1 = key1;
		}
		public String getKey2() {
			return key2;
		}
		public void setKey2(String key2) {
			this.key2 = key2;
		}
		public Persons getPerson() {
			return person;
		}
		public void setPerson(Persons person) {
			this.person = person;
		}
		public App getApp() {
			return app;
		}
		public void setApp(App app) {
			this.app = app;
		}
		@Override
		public void setIdToNull() {
			// TODO Auto-generated method stub
			
		}
	
		private static final long serialVersionUID = 1L;

}