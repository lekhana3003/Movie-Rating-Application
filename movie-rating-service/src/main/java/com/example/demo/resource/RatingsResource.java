package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Rating;
import com.example.demo.repository.RatingRepository;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {
	@Autowired
	RatingRepository ratingRepository;

    @RequestMapping("/{movieId}/{userId}")
    public Rating getRating(@PathVariable("movieId") String movieId,@PathVariable("userId") String userId) {
        return ratingRepository.findByMovieIdandUserId(Integer.parseInt(movieId),Integer.parseInt(userId));
    }
}
