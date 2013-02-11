package com.tpg.tmjug.springdata.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.tpg.tmjug.springdata.demo.entity.User;

public interface UserRepository extends CrudRepository<User, String> {

}
