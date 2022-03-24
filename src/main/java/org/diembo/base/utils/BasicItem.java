package org.diembo.base.utils;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class BasicItem {

	private Long 			id			;
	private String 			code		;
	private String 			label		;
	private Double 			number		;
	private String 			description	;
	private Long 			rank		;
	private List<String> 	subItems	;


	public BasicItem() {
	}

	public BasicItem(String code, String label) {
		this.code = code;
		this.label = label;
	}

	public BasicItem(Long id, String label) {
		this.id = id;
		this.label = label;
	}
	
	public BasicItem(Long id, String code, String label) {
		this.id = id;
		this.code = code;
		this.label = label;
	}

	public BasicItem(Long id, String code, String label, String description) {
		this.id = id;
		this.code = code;
		this.label = label;
		this.description = description;
	}
	
	public BasicItem(Long id, String code, String label, String description, Long rank) {
		this.id = id;
		this.code = code;
		this.label = label;
		this.description = description;
		this.rank = rank;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public Long getRank() {
		return rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}
	
	
	public Double getNumber() {
		return number;
	}

	public void setNumber(Double number) {
		this.number = number;
	}

	public List<String> getSubItems() {
		return subItems;
	}

	public void setSubItems(List<String> subItems) {
		this.subItems = subItems;
	}
	

}