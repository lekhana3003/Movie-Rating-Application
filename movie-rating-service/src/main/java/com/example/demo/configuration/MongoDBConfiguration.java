package com.example.demo.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.model.Rating;
import com.example.demo.repository.RatingRepository;



@EnableMongoRepositories(basePackageClasses = RatingRepository.class)
@Configuration
public class MongoDBConfiguration {


    @Bean
    CommandLineRunner commandLineRunner(RatingRepository ratingRepository) {
        return strings -> {
          ratingRepository.save(new Rating(1,4,1));
            ratingRepository.save(new Rating(2,4,2));
            ratingRepository.save(new Rating(1,3,2));
            ratingRepository.save(new Rating(2,4,1));
        };
    }

}
