package com.tpg.tmjug.springdata.demo.mongodb.entity;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Location {

	private final double[] position;
	
	@PersistenceConstructor
	public Location(final double[] position) {
		this.position = position;
	}
	
	public double[] getPosition() {
		return position;
	}
}
