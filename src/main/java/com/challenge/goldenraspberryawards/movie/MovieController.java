package com.challenge.goldenraspberryawards.movie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies/smallest-and-largest-interval-between-awards")
    ResponseEntity<SmallestAndLargestIntervalBetweenAwards> smallestAndLargestIntervalBetweenAwards() {

        SmallestAndLargestIntervalBetweenAwards dto = movieService.smallestAndLargestIntervalBetweenAwards();

        return ResponseEntity.ok(dto);
    }

}
