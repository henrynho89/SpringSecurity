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
	name = "I18N", 
	uniqueConstraints={
		@UniqueConstraint(name="UK__I18N__CT_LANG", columnNames={"ITEM_ID", "LANGUAGE_ID","TABLE_NAME"})
	}
)
public class I18n extends GenericEntity  {

	@Column(name = "ID", nullable=false, precision = 20, scale = 0)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long							id;

	@Column(name = "ITEM_ID")
	private Long itemId;
	
	@ManyToOne@JoinColumn(name = "LANGUAGE_ID", foreignKey=@ForeignKey(name="FK_I18N_LANG"), nullable=false)
	private Language 						language;

	@Column(name = "VALUE", length = 250)
	private String							value;
	

	@Column(name = "TABLE_NAME", length = 100)
	private String							tableName;


	@Override
	public Long getId() {
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}


	
	@Override
	public void setIdToNull() {
		setId(null); 
	}

	
	public Long getItemId() {
		return itemId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Language getLanguage() {
		return language;
	}
	
	

	private static final long serialVersionUID = 1L;
}
