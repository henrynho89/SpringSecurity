package org.diembo.base.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)

@Entity
@Table(name = "ITEM", 
	uniqueConstraints={
		@UniqueConstraint(name="U_Item__PROP", columnNames={"PROP"})
	})
public class Item extends GenericEntity  {

	@Column(name = "ID", nullable=false, precision = 20, scale = 0)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long 								  id;

	
	@Column(name = "DESCRIPTION", length = 70)
	private String							description;
	
	@Column(name = "PROP", length = 70)
	private String							prop;
	
	@Transient
    private String subProp;

	@Transient
	private String							type;
	
	@Transient
	private String							style;

	@Transient
	protected Boolean readOnly ;
	
	@Transient
	protected Boolean insertOnly ;

	@Transient
	protected Boolean required;
	
	@Transient
	protected Boolean isFormField ;
	
	@Transient
	protected Boolean isListField ;
	

	@Transient
	private String name;

	
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

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public Boolean getReadOnly() {
		return readOnly;
	}
	public void setReadOnly(Boolean readOnly) {
		this.readOnly = readOnly;
	}
	public Boolean getInsertOnly() {
		return insertOnly;
	}
	public void setInsertOnly(Boolean insertOnly) {
		this.insertOnly = insertOnly;
	}
	public Boolean getRequired() {
		return required;
	}
	public void setRequired(Boolean required) {
		this.required = required;
	}
	public Boolean getIsFormField() {
		return isFormField;
	}
	public void setIsFormField(Boolean isFormField) {
		this.isFormField = isFormField;
	}
	public Boolean getIsListField() {
		return isListField;
	}
	public void setIsListField(Boolean isListField) {
		this.isListField = isListField;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getProp() {
		return prop;
	}
	public void setProp(String prop) {
		this.prop = prop;
	}

	public String getSubProp() {
		return subProp;
	}
	public void setSubProp(String subProp) {
		this.subProp = subProp;
	}

	
	//--------------------------------------------------------------
	public Item(String prop, String name) {
		this.prop = prop;
		this.name = name;
	}
	public Item(String prop, String name, String type) {
		this.prop = prop;
		this.name = name;
		this.type = type;
	}
	public Item(String prop, String name, boolean readOnly) {
		this.prop = prop;
		this.name = name;
		this.readOnly =readOnly;
	}
	public Item(String prop, String name, String type, boolean readOnly) {
		this.prop = prop;
		this.name = name;
		this.type = type;
		this.readOnly =readOnly;
	}
	
	public Item(String prop, String name, String type, boolean readOnly, boolean insertOnly) {
		this.prop 		= prop;
		this.name 		= name;
		this.type 		= type;
		this.readOnly 	= readOnly;
		this.insertOnly = insertOnly;
	}
         
	public Item() {
	}

	private static final long serialVersionUID = 1L;
}
