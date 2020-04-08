package com.example.demo.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.demo.model.CatalogueItem;
import com.example.demo.model.Movie;
import com.example.demo.model.Rating;
import com.example.demo.model.User;
import com.example.demo.repository.CatalogueItemRepository;

import reactor.core.publisher.Flux;

@RestController
public class MovieCatalogueResource {
	
	@Autowired
	CatalogueItemRepository catalogueItemRepository;
	
	@Autowired
    private RestTemplate restTemplate;
	
	@GetMapping(value="/getCatalogue/{userId}")
	 public List<CatalogueItem> getCatalog(@PathVariable("userId") String userId) {
		List<CatalogueItem> catalogueList=new ArrayList<CatalogueItem>();
		User user =restTemplate.getForObject("http://USER-INFO-SERVICE/userdata/" + userId, User.class);
		System.out.println(user.getUserId());
		for(Integer movieId:user.getMovieList())
		{
			Rating rating=restTemplate.getForObject("http://movie-rating-service/ratingsdata/"+movieId+"/"+user.getUserId(), Rating.class);
					
			Movie movie=restTemplate.getForObject("http://movie-info-service//movies/"+movieId, Movie.class);
			
			
			catalogueList.add(new CatalogueItem(movie.getName(), movie.getDesc(),rating.getRating()));
		}
		
		
		return catalogueList;
	 }
}
