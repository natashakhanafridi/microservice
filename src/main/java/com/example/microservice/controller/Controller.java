package com.example.microservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.microservice.data.Country;
import com.example.microservice.repositories.CountryRepository;


@RestController
@RequestMapping("/referencedataservice/countries")
public class Controller {
	private final static Logger LOGGER = Logger.getLogger(Controller.class.getName());
	
	@Autowired
	CountryRepository countryRepository;
	
	@RequestMapping("/{name}")
	public Country getCountry(@PathVariable String name) {
		Country result;
		LOGGER.log(Level.INFO, "Getting country with name" + name);
		result = countryRepository.findByName(name);
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	List<Country> getCountries(){
		List<Country> result;
		LOGGER.log(Level.INFO, "Getting all countries");
		result = new ArrayList();
		
		Iterable<Country> countryList = countryRepository.findAll();
		for (Country country : countryList){
			result.add(country);
		}
		return result;
	}
}

