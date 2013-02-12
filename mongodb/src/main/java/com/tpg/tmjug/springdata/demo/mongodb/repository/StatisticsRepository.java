package com.tpg.tmjug.springdata.demo.mongodb.repository;

import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;

public interface StatisticsRepository {

	public abstract MapReduceResults<ValueObject> getAccountsTotal();

}