package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


import com.example.demo.model.User;

public interface UserRepository extends MongoRepository<User, Integer> {

	@Query("{ 'userId' : ?0 }")
	User findByUserId(Integer userId);
}
