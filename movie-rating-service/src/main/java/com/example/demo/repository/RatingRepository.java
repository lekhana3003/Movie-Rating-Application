package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.example.demo.model.Rating;

public interface RatingRepository extends MongoRepository<Rating, Integer> {
	@Query("{ 'movieId' : ?0,'userId':?1}")
	Rating findByMovieIdandUserId(Integer movieId,Integer userId);

}
