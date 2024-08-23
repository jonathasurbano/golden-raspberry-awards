package com.challenge.goldenraspberryawards.movie;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataLoader {

    public List<MovieCsv> loadFromCSV(Path path) throws IOException {

        try (Reader reader = Files.newBufferedReader(path)) {
            CsvToBean<MovieCsv> cb = new CsvToBeanBuilder<MovieCsv>(reader)
                    .withType(MovieCsv.class)
                    .withSkipLines(0)
                    .withSeparator(';')
                    .build();

            return cb.parse();
        }
    }

}
