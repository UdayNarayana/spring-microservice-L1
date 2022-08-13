package com.example.demo.controlller;

import com.example.demo.entity.Movie;
import com.example.demo.entity.MovieCatalouge;
import com.example.demo.entity.MovieRating;
import com.example.demo.entity.UserRating;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieCatalougeController {

//    WebClient builder = WebClient.builder()
//            .clientConnector(new ReactorClientHttpConnector(
//                            HttpClient.create()
//                                    .resolver(DefaultAddressResolverGroup.INSTANCE)
//                    )
//            ).build();

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public List<MovieCatalouge> listMovieCatalouges(@PathVariable("userId") String userId){
        UserRating ratings = restTemplate.getForObject("http://MOVIE-RATING-SERVICE/rating/"+userId, UserRating.class);
//        UserRating ratings = builder
//                .get()
//                .uri("http://MOVIE-RATING-SERVICE/rating/"+userId)
//                .retrieve()
//                .bodyToMono(UserRating.class)
//                .block();

       return ratings.getRatings().stream().map(rating->{
            Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movie-info/"+rating.getMovieId(),Movie.class);
            return new MovieCatalouge(movie.getMovieName(), rating.getRating());
        }).collect(Collectors.toList());


    }


}
