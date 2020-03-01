package com.example.demo.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	private Integer userId;
	private List<Integer> movieList;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Integer> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Integer> movieList) {
		this.movieList = movieList;
	}
	public User(Integer userId, List<Integer> movieList) {
		
		this.userId = userId;
		this.movieList = movieList;
	}
	public User()
	{
		
	}

}
