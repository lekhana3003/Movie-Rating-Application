package com.example.demo.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;



@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfiguration {

List<Integer> movieList=Arrays.asList(1,2);
		
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return strings ->{
          userRepository.save(new User(1,movieList));
            userRepository.save(new User(2,movieList));
        };
    }

}
