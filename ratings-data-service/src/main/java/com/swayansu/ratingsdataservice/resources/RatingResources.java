package com.swayansu.ratingsdataservice.resources;

import com.swayansu.ratingsdataservice.models.Rating;
import com.swayansu.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResources {

//    @RequestMapping("/{movieId}")
//    public Rating getRating(@PathVariable("movieId") String movieId){
//        return  new Rating(movieId, 4);
//    }

    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId ){
        List<Rating> ratingList = Arrays.asList(
                new Rating("1234", 5),
                new Rating("5678", 4),
                new Rating("7890", 4)
        );
        UserRating userRating = new UserRating();
        userRating.setUserRating(ratingList);
        return userRating;
    }
}
