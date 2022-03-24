package org.diembo.base.utils.impl;


public class TextFileField{
	
	
	public TextFileField(String name, int start, int length) {
		this.name = name;
		this.start = start;
		this.length = length;
	}
	

	public String getName() {
		return name;
	}

	public int getStart() {
		return start;
	}

	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	private String name;
	private int start;
	private int length;
	
}
