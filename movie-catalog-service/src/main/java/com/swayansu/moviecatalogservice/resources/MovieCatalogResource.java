package com.swayansu.moviecatalogservice.resources;

import com.swayansu.moviecatalogservice.models.CatalogItem;
import com.swayansu.moviecatalogservice.models.Movie;
import com.swayansu.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.web.reactive.function.client.WebClient.*;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){


        // RestTemplate the class which helps in getting the classes

        // TODO: get all the movie IDs
        List<Rating> ratings = Arrays.asList(
                new Rating("1234", 4),
                new Rating("5678", 3)
        );

        // TODO: USING WEBCLIENT
        return ratings.stream().map(rating -> {
                  Movie movie = webClientBuilder.build()
                           .get()
                           .uri("http://localhost:8082/movies/" + rating.getMovieId())
                           .retrieve()
                           .bodyToMono(Movie.class)
                           .block();
                   return new CatalogItem(movie.getMovieName(), "Harry potter sequqel", 4);
               })
                .collect(Collectors.toList());

//        return ratings.stream().map(
//                rating -> {
//                    Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
//                   return new CatalogItem(
//                            movie.getMovieName(),
//                            "Harry potetr sequqel",
//                            4
//                    );
//                }
//        )
//                .collect(Collectors.toList());

        // TODO: For each Movie Id, call movie info service and get details

        // TODO: Put them all together

    }
}
