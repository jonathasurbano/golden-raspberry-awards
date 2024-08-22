package com.challenge.goldenraspberryawards.movie;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository
    ) {
        this.movieRepository = movieRepository;
    }

    @Override
    public SmallestAndLargestIntervalBetweenAwards smallestAndLargestIntervalBetweenAwards() {

//        List<Movie> movies = movieRepository.findAwardWinners();
//
//        List<Producer> producers = extractProducers(movies);
//
//        List<Producer> awardWinningProducers = producers.stream().filter(Producer::getReceivedMoreThanOneAward).toList();
//
//        awardWinningProducers.forEach(Producer::calcIntervals);
//
//        int theShortestIntervalBetweenTheFirstTwoAwards = calcTheShortestIntervalBetweenTheFirstTwoAwards(awardWinningProducers);
//        int theLongestIntervalBetweenTwoConsecutivePrizes = calcTheLongestIntervalBetweenTwoConsecutivePrizes(awardWinningProducers);
//
//        return getSmallestAndLargestIntervalBetweenAwards(awardWinningProducers, theShortestIntervalBetweenTheFirstTwoAwards,
//                theLongestIntervalBetweenTwoConsecutivePrizes);
        return null;
    }

    private SmallestAndLargestIntervalBetweenAwards getSmallestAndLargestIntervalBetweenAwards(List<Producer> awardWinningProducers,
            int theShortestIntervalBetweenTheFirstTwoAwards, int theLongestIntervalBetweenTwoConsecutivePrizes) {

        SmallestAndLargestIntervalBetweenAwards smallestAndLargestIntervalBetweenAwards = new SmallestAndLargestIntervalBetweenAwards();

        smallestAndLargestIntervalBetweenAwards.getMin().addAll(
                awardWinningProducers.stream()
                        .filter(p -> p.getIntervalBetweenTheFirstTwoPrizes() == theShortestIntervalBetweenTheFirstTwoAwards)
                        .map(this::convertFromProducerToProducerResponseMin)
                        .toList());

        smallestAndLargestIntervalBetweenAwards.getMax().addAll(
                awardWinningProducers.stream()
                        .filter(p -> p.getTheLongestIntervalBetweenTwoConsecutivePrizes() == theLongestIntervalBetweenTwoConsecutivePrizes)
                        .map(this::convertFromProducerToProducerResponseMax)
                        .toList());

        return smallestAndLargestIntervalBetweenAwards;
    }

    private ProducerResponse convertFromProducerToProducerResponseMin(Producer producer) {
        ProducerResponse producerResponse = new ProducerResponse();
        producerResponse.setProducer(producer.getName());
        producerResponse.setPreviousWin(producer.getTheFirstTwoPrizes().get(0));
        producerResponse.setFollowingWin(producer.getTheFirstTwoPrizes().get(1));
        producerResponse.setInterval(producer.getIntervalBetweenTheFirstTwoPrizes());
        return producerResponse;
    }

    private ProducerResponse convertFromProducerToProducerResponseMax(Producer producer) {
        ProducerResponse producerResponse = new ProducerResponse();
        producerResponse.setProducer(producer.getName());
        producerResponse.setPreviousWin(producer.getConsecutivePrizes().get(0));
        producerResponse.setFollowingWin(producer.getConsecutivePrizes().get(1));
        producerResponse.setInterval(producer.getTheLongestIntervalBetweenTwoConsecutivePrizes());
        return producerResponse;
    }

    private int calcTheLongestIntervalBetweenTwoConsecutivePrizes(List<Producer> awardWinningProducers) {
        int theLongestIntervalBetweenTwoConsecutivePrizes = 0;

        for (Producer producer : awardWinningProducers) {
            if (theLongestIntervalBetweenTwoConsecutivePrizes < producer.getTheLongestIntervalBetweenTwoConsecutivePrizes()) {
                theLongestIntervalBetweenTwoConsecutivePrizes = producer.getTheLongestIntervalBetweenTwoConsecutivePrizes();
            }
        }

        return theLongestIntervalBetweenTwoConsecutivePrizes;
    }

    private int calcTheShortestIntervalBetweenTheFirstTwoAwards(List<Producer> awardWinningProducers) {

        int theShortestIntervalBetweenTheFirstTwoAwards = 9999;

        for (Producer producer : awardWinningProducers) {
            if (theShortestIntervalBetweenTheFirstTwoAwards > producer.getIntervalBetweenTheFirstTwoPrizes()) {
                theShortestIntervalBetweenTheFirstTwoAwards = producer.getIntervalBetweenTheFirstTwoPrizes();
            }
        }

        return theShortestIntervalBetweenTheFirstTwoAwards;
    }

    private List<Producer> extractProducers(List<Movie> movies) {

        Map<String, Producer> producerMap = new HashMap<>();

        for (Movie movie : movies) {

            List<String> namesOfProducers = extractNamesOfProducers(movie);

            for (String producersName : namesOfProducers) {
                Producer producer = producerMap.computeIfAbsent(producersName, Producer::new);
                producer.addYearInWhichItWonAwards(movie.getYearAward());
            }
        }

        return new ArrayList<>(producerMap.values());
    }

    private List<String> extractNamesOfProducers(Movie movie) {
        String producers = movie.getProducer().replaceAll(" and ", ",");

        return Arrays.stream(producers.split(",", 0)).map(String::trim).filter(n -> !n.isEmpty()).toList();
    }

}
