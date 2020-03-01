package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
@RestController
@RequestMapping("/userdata")
public class UserResource {

		@Autowired
		UserRepository userRepository;

	    @RequestMapping("/{userId}")
	    public User getRating(@PathVariable("userId") String userId) {
	        return userRepository.findByUserId(Integer.parseInt(userId));
	    }

}
