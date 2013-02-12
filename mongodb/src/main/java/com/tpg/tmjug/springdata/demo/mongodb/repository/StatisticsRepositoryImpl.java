package com.tpg.tmjug.springdata.demo.mongodb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

@Repository
public class StatisticsRepositoryImpl implements StatisticsRepository {

	private final MongoOperations operations;
	
	@Autowired
	public StatisticsRepositoryImpl(MongoOperations operations) {
		Assert.notNull(operations);
		this.operations = operations;
	}
	
	/* (non-Javadoc)
	 * @see com.tpg.tmjug.springdata.demo.mongodb.repository.StatisticsRepository#getAccountsTotal()
	 */
	@Override
	public MapReduceResults<ValueObject> getAccountsTotal() {
		return operations.mapReduce("customer", "classpath:map.js", "classpath:reduce.js", ValueObject.class);
	}
}
