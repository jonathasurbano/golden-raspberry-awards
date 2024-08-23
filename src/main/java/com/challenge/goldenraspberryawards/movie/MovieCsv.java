package com.challenge.goldenraspberryawards.movie;

import com.opencsv.bean.CsvBindByName;


public class MovieCsv {

    @CsvBindByName
    private Integer year;

    @CsvBindByName
    private String producers;

    @CsvBindByName
    private String winner;

    public Integer getYear() {
        return year;
    }

    public String getProducers() {
        return producers;
    }

    public String getWinner() {
        return winner;
    }

}
