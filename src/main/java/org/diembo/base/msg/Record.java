package org.diembo.base.msg;

import java.util.ArrayList;
import java.util.List;

import org.diembo.base.utils.BasicItem;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Record {

	private List<BasicItem>		fields;

	public List<BasicItem> getFields() {
		return fields;
	}

	public void setFields(List<BasicItem> fields) {
		this.fields = fields;
	}
	
	public void addItems(BasicItem BasicItem) {
		if(this.fields == null) {
			this.fields = new ArrayList<BasicItem>();
		}
		this.fields.add(BasicItem);
	}
	
}
