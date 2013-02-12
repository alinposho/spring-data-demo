package com.tpg.tmjug.springdata.demo.mongodb.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.Assert;

@Document
public class EmailAddress {
	
	@Field("email")
	private final String value;
	
	public EmailAddress(String value) {
		Assert.isTrue(isValid(value), "Invalid email address!");
		
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public static boolean isValid(String source) {
		/* validate email address */
		return true;
	}
}
