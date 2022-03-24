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
@Table(
	name = "I18N_TRANSFER_PERIODICITY", 
	uniqueConstraints={
		@UniqueConstraint(name="U_I18N_TRANSFER_PERIODICITY__LANG", columnNames={"TRANSFER_PERIODICITY_ID", "LANGUAGE_ID"}),
		@UniqueConstraint(name="U_I18N_TRANSFER_PERIODICITY__INST", columnNames={"TRANSFER_PERIODICITY_ID", "INSTITUTION_ID"})
	}
)
public class I18nTransferPeriodicity extends GenericEntity  {

	@Column(name = "ID", nullable=false, precision = 20, scale = 0)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long 								  id;

	@ManyToOne@JoinColumn(name = "TRANSFER_PERIODICITY_ID", foreignKey=@ForeignKey(name="FK_TRANSFER_PERIODICITY_ID"))
	private TransferPeriodicity 	transferPeriodicity;
	
	@ManyToOne@JoinColumn(name = "LANGUAGE_ID", foreignKey=@ForeignKey(name="FK_I18N_TRANSFER_PERIODICITY__LANG"))
	private Language 		language;

	@ManyToOne@JoinColumn(name = "INSTITUTION_ID", foreignKey=@ForeignKey(name="FK_I18N_TRANSFER_PERIODICITY__INST"))
	private Institution 		institution;

	@Column(name = "NAME", length = 140)
	private String							name;
		

	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	
	public TransferPeriodicity getTransferPeriodicity() {
		return transferPeriodicity;
	}
	public void setTransferPeriodicity(TransferPeriodicity transferPeriodicity) {
		this.transferPeriodicity = transferPeriodicity;
	}
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Institution getInstitution() {
		return institution;
	}
	public void setInstitution(Institution institution) {
		this.institution = institution;
	}

	@Override
	public void setIdToNull() {
		setId(null); 
	}

	
	
	private static final long serialVersionUID = 1L;
}
