package com.tpg.tmjug.springdata.demo.mongodb.repository;

public class ValueObject {

	private String id;
	private long value;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	
}
