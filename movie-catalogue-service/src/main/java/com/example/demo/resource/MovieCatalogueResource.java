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
	private WebClient webClientBuilder;
	
	@GetMapping(value="/getCatalogue/{userId}")
	 public List<CatalogueItem> getCatalog(@PathVariable("userId") String userId) {
		List<CatalogueItem> catalogueList=new ArrayList<CatalogueItem>();
		User user =webClientBuilder.get()
				.uri("localhost:8084/userdata/"+userId)
				.retrieve()
				.bodyToMono(User.class)
				.block();
		System.out.println(user.getUserId());
		for(Integer movieId:user.getMovieList())
		{
			Rating rating=webClientBuilder.get()
					.uri("localhost:8082/ratingsdata/"+movieId+"/"+user.getUserId())
					.retrieve()
					.bodyToMono(Rating.class)
					.block();
			Movie movie=webClientBuilder.get()
					.uri("localhost:8081/movies/"+movieId)
					.retrieve()
					.bodyToMono(Movie.class)
					.block();
			catalogueList.add(new CatalogueItem(movie.getName(), movie.getDesc(),rating.getRating()));
		}
		
		/*List<Rating> ratings=webClientBuilder.get()
							.uri("localhost:8082/ratingsdata/1")
							.retrieve()
							.bodyToMono(new ParameterizedTypeReference<List<Rating>>() {})
							.block();*/
		
		
		/*List<Rating> ratings=Arrays.asList(
				new Rating(1,3),
				new Rating(2,3)
				);
		for(Rating rating:ratings){
			Movie movie=webClientBuilder.get()
			.uri("localhost:8081/movies/"+rating.getMovieId())
			.retrieve()
			.bodyToMono(Movie.class)
			.block();
			//System.out.println(movie.getName()+rating.getRating());
		
		}
				
			*/
		
		return catalogueList;
	 }
}
