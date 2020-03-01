package com.example.demo.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;



@EnableMongoRepositories(basePackageClasses = MovieRepository.class)
@Configuration
public class MongoDBConfiguration {


    @Bean
    CommandLineRunner commandLineRunner(MovieRepository movieRepository) {
        return strings -> {
          movieRepository.save(new Movie(1,"transformers","about robots"));
            movieRepository.save(new Movie(2,"titanic","about sinking ship"));
        };
    }

}