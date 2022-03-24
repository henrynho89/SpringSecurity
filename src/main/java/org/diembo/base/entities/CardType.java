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
@Table(name = "CARD_TYPE",
	uniqueConstraints={
		@UniqueConstraint(name="U_CODE__INST"		, columnNames={"CODE"	, "INSTITUTION_ID"}) 
	}
)
public class CardType extends GenericEntity {
	
	@Column(name = "ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long id;
	
	@Column(name = "CODE", nullable=false)
	private String code;
	
	@Column(name = "NAME", nullable=false)
	private String name;
	
	
	@ManyToOne 
	@JoinColumn(name="INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_CARD_TYPE__INST"), nullable=false)
	private Institution institution;
	
	@Column(name = "DEFAULT_MAX_QUANTITY", nullable=false)
	private Integer defaultMaxQuantity;
	
	@Column(name = "DEFAULT_MIN_QUANTITY", nullable=false)
	private Integer defaultMinQuantity;
	
	@Column(name = "DEFAULT_OPTIMAL_QUANTITY", nullable=false)
	private Integer defaultOptimalQuantity;
	

	@Column(name = "IMAGE", nullable=true)
	private String image;
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}



	@Override
	public void setIdToNull() {
		setId(null);
	}

	

	public Long getId(){
		return this.id;
	}
	public void setId(Long value) {
		this.id = value;
	}

	


	
	

	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	public Institution getInstitution() {
		return institution;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getDefaultMaxQuantity() {
		return defaultMaxQuantity;
	}

	public void setDefaultMaxQuantity(Integer defaultMaxQuantity) {
		this.defaultMaxQuantity = defaultMaxQuantity;
	}

	public Integer getDefaultMinQuantity() {
		return defaultMinQuantity;
	}

	public void setDefaultMinQuantity(Integer defaultMinQuantity) {
		this.defaultMinQuantity = defaultMinQuantity;
	}
	
	public Integer getDefaultOptimalQuantity() {
		return defaultOptimalQuantity;
	}

	public void setDefaultOptimalQuantity(Integer defaultOptimalQuantity) {
		this.defaultOptimalQuantity = defaultOptimalQuantity;
	}
	

	private static final long serialVersionUID = 1L;
}