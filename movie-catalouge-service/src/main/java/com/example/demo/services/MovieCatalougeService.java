package com.example.demo.services;

import com.example.demo.entity.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieCatalougeService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackMovieCatalouge",
            commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value ="2000" ),
                    @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="5"),
                    @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="50"),
                    @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="5000")
            })
    public Movie getMovieCatalouge(int movieId){
        Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movie-info/"+movieId,Movie.class);
        return movie;
    }


    public Movie getFallbackMovieCatalouge(int movieId){
        return new Movie(movieId,"N/A","N/A");
    }
}
