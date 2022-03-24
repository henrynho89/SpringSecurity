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


@Entity
@Table( name = "APP_VERSION",
uniqueConstraints={
		@UniqueConstraint(name="U_APP_VERSION__APP_ID__MAJOR__MIDDLE__MINOR", columnNames={"APP_ID", "MAJOR", "MIDDLE", "MINOR"})
})
public class AppVersion extends GenericEntity {
		 

		@Column(name = "ID", nullable=false)
		@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
				pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
		@Id
		@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
		private Long id;


		@Column(name = "HOLD" )
		private Boolean hold;
		
		@Column(name = "DEPRECATED" )
		private Boolean deprecated;


		@Column(name = "NAME")
		private String name;
	
		@Column(name = "MINOR")
		private String minor;
		
		@Column(name = "MIDDLE")
		private String middle;
		
		@Column(name = "MAJOR")
		private String major;
	 
		@ManyToOne
		@JoinColumn(name="APP_ID", foreignKey=@ForeignKey(name="FK_APP_VERSION__APP"))
		private App app;
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}

		public Boolean getHold() {
			return hold;
		}
		public void setHold(Boolean hold) {
			this.hold = hold;
		}
		
		public Boolean getDeprecated() {
			return deprecated;
		}
		public void setDeprecated(Boolean deprecated) {
			this.deprecated = deprecated;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getMinor() {
			return minor;
		}
		public void setMinor(String minor) {
			this.minor = minor;
		}
		public String getMiddle() {
			return middle;
		}
		public void setMiddle(String middle) {
			this.middle = middle;
		}
		public String getMajor() {
			return major;
		}
		public void setMajor(String major) {
			this.major = major;
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