package com.example.demo.resource;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	@Autowired
	MovieRepository movieRepository;
	
	    @RequestMapping("/{movieId}")
	    public Optional<Movie> getMovieInfo(@PathVariable("movieId") String movieId) {
	        return movieRepository.findById(Integer.parseInt(movieId));

	    }

	
}
