package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.CatalogueItem;


public interface CatalogueItemRepository extends MongoRepository<CatalogueItem, Integer> {

}
