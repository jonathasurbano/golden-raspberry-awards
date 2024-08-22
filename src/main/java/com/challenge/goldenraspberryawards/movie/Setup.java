package com.challenge.goldenraspberryawards.movie;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

@Component
public class Setup {

    private final MovieRepository movieRepository;

    public Setup(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @PostConstruct
    private void setupData() throws URISyntaxException, IOException {
        setupMovies();
    }

    private void setupMovies() throws URISyntaxException, IOException {

        DataLoader dataLoader = new DataLoader();

        @SuppressWarnings("SpellCheckingInspection") Path path = Paths.get(
                ClassLoader.getSystemResource("csv/movielist.csv").toURI());

        List<MovieCsv> moviesCsv = dataLoader.loadFromCSV(path);

        insertMovies(moviesCsv);
    }

    private void insertMovies(List<MovieCsv> moviesCsv) {
        for (MovieCsv movieCsv : moviesCsv) {
            List<String> producers = extractNamesOfProducers(movieCsv.getProducers());

            for (String producerName : producers) {
                Movie movie = new Movie( movieCsv.getYear(), producerName, movieCsv.getWinner());
                movieRepository.save(movie);
            }
        }
    }

    private List<String> extractNamesOfProducers(String producers) {
        String producersAux = producers.replace(" and ", ",");

        return Arrays.stream(producersAux.split(",", 0)).map(String::trim).filter(n -> !n.isEmpty()).toList();
    }
}
