package org.diembo.base.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.UniqueConstraint;


@javax.persistence.Entity
@Table( name = "ENTITY", 
		uniqueConstraints={ @UniqueConstraint(name="U_ENTITY__ENTITYNAME", columnNames={"ENTITYNAME"})
		}
)
public class Entity extends GenericEntity
{
	
	
	@Column(name = "ENTITY_ID", nullable=false)
	@TableGenerator(name = "ControlTokenGenerator", table = "TOKENSERIE", 
			pkColumnName = "TOKENSERIE_CODE", valueColumnName = "TOKEN", pkColumnValue = "ControlSerie")
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "ControlTokenGenerator")
	private Long 					id;

	@Column(name = "ENTITYNAME" , length=120, nullable=false)
	private String					entityName;
	
	@Column(name = "DESCRIPTION" , length=256)
	private String					description;
	
	
	
	
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	// .~~~~~~~~..~~~~~~~~..~~~~~~~~. //
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

	
	
	@Override
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public void setIdToNull() {
		setId(null);
	}
	
	
	private static final long serialVersionUID = 1L;

}
