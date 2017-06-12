package com.example.microservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.microservice.data.Country;


public interface CountryRepository extends MongoRepository<Country, Integer> {
    Country findByName(String name);
}
