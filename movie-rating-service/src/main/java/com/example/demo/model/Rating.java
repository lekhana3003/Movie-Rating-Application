package com.example.demo.model;

import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Rating {
	
    
	
    private Integer movieId;
    private int rating;
    private Integer userId;

    public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Rating(Integer movieId, int rating,Integer userId) {
    	
        this.movieId = movieId;
        this.rating = rating;
        this.userId=userId;
    }
    public Rating()
    {
    	
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
