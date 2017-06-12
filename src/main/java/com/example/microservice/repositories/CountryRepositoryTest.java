package com.example.microservice.repositories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.microservice.data.Country;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryRepositoryTest {
    @Autowired
    private CountryRepository countryRepository;
 

	@Before
    public void setUp() throws Exception {
        Country country1= new Country("pk", "Pakistan");
        Country country2= new Country("gr", "Germany");
        //save product, verify has ID value after save
        assertNull(country1.getId());
        assertNull(country2.getId());//null before save
        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        assertNotNull(country1.getId());
        assertNotNull(country2.getId());
    }
 
    @Test
    public void testFetchData(){
        /*Test data retrieval*/
        Country countryA = countryRepository.findByName("Pakistan");
        assertNotNull(countryA);
        assertEquals("pk", countryA.getCode());
        /*Get all products, list should only have two*/
        Iterable<Country> country = countryRepository.findAll();
        int count = 0;
        for(Country p : country){
            count++;
        }
        assertEquals(count, 2);
    }
 
    @Test
    public void testDataUpdate(){
        /*Test update*/
    	Country countryB = countryRepository.findByName("Germany");
    	countryB.setCode("gr");
    	countryRepository.save(countryB);
        Country countryC= countryRepository.findByName("Pakistan");
        assertNotNull(countryC);
        assertEquals("pk", countryC.getCode());
    }
 
    @After
    public void tearDown() throws Exception {
      this.countryRepository.deleteAll();
    }
 
}
