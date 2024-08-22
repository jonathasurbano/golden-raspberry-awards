package com.challenge.goldenraspberryawards.movie;

import com.opencsv.bean.CsvBindByName;


public class MovieCsv extends CsvBean {

    @CsvBindByName
    private Integer year;

    @CsvBindByName
    private String title;

    @CsvBindByName
    private String studios;

    @CsvBindByName
    private String producers;

    @CsvBindByName
    private String winner;

    public Integer getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getStudios() {
        return studios;
    }

    public String getProducers() {
        return producers;
    }

    public String getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return "MovieCsv{" + "year=" + year + ", title='" + title + '\'' + ", studios='" + studios + '\''
                + ", producers='" + producers + '\'' + ", winner='" + winner + '\'' + '}';
    }
}
