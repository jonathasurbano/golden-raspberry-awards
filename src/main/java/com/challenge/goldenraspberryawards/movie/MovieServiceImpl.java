package com.challenge.goldenraspberryawards.movie;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public SmallestAndLargestIntervalBetweenAwards smallestAndLargestIntervalBetweenAwards() {

        List<Movie> movies = movieRepository.findAwardWinners();
        Map<String, AwardsInterval> awardsIntervals = new HashMap<>();
        Response response = new Response();

        for (Movie movie : movies) {

            if (awardsIntervals.containsKey(movie.getProducer())) {

                AwardsInterval awardsInterval = awardsIntervals.get(movie.getProducer());
                awardsInterval.setFollowingWin(movie.getYearAward());

                response.updateTheShortestIntervalBetweenTheFirstTwoAwards(awardsInterval);
                response.updateTheLongestIntervalBetweenTwoConsecutivePrizes(awardsInterval);

                awardsInterval.moveToNextInterval();
            } else {
                awardsIntervals.put(movie.getProducer(), new AwardsInterval(movie.getProducer(), movie.getYearAward()));
            }
        }
        return new SmallestAndLargestIntervalBetweenAwards(response.getMin(), response.getMax());
    }

}
