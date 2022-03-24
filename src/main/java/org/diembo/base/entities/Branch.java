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
@Table( name = "BRANCH", 
uniqueConstraints={
		@UniqueConstraint(name="UQ_BRANCH_CODE_INSTITUTION", columnNames={"BRANCH_CODE", "INSTITUTION_ID"})
	}
)
public class Branch extends GenericEntity
{

	@Column(name = "BRANCH_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long branch_id;

	@Column(name = "BRANCH_CODE", length=30, nullable=false)
	private String branch_code;

	@Column(name = "NAME", length=140, nullable=false)
	private String name;

	@Column(name = "ADDRESS_LINE_1", length=140, nullable=true)
	private String addressLine1;

	@Column(name = "ADDRESS_LINE_2", length=140, nullable=true)
	private String addressLine2;

	@Column(name = "LATITUDE", precision = 20, scale = 10, nullable=true)
	private Double latitude;

	@Column(name = "LONGITUDE", precision = 20, scale = 10, nullable=true)
	private Double longitude;

	@Column(name = "ELEVATION", precision = 20, scale = 10, nullable=true)
	private Double elevation;

	
	@Column(name = "RANK", nullable=false)
	private Long rank;

	@ManyToOne 
	@JoinColumn(name="CITY_ID", foreignKey=@ForeignKey(name="FK_BRANCH_CITYBRANC_CITY"), nullable=false)
	private City city;

	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_BRANCH_INSTBRANC_INSTITUT"), nullable=false)
	private Institution institution;


	public void setBranch_id(Long value) {
		this.branch_id = value;
	}
	public Long getBranch_id(){
		return this.branch_id;
	}

	public void setBranchCode(String value) {
		this.branch_code = value;
	}
	public String getBranchCode(){
		return this.branch_code;
	}

	public void setName(String value) {
		this.name = value;
	}
	public String getName(){
		return this.name;
	}

	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getElevation() {
		return elevation;
	}
	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}

	public void setRank(Long value) {
		this.rank = value;
	}
	public Long getRank(){
		return this.rank;
	}

	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}

	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@Override
	public Long getId() {
		return getBranch_id();
	}
	@Override
	public void setIdToNull() {
		setBranch_id(null);
	}
	

	public String getBranchDetails() {
		return getName() + " " + " [" + getBranchCode() +"]";
	}


	private static final long serialVersionUID = 1L;


}
