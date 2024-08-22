package com.challenge.goldenraspberryawards.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer yearAward;
    private String producer;
    private String winner;

    public Movie() {
    }

    public Movie(Integer yearAward, String producer, String winner) {
        this.yearAward = yearAward;
        this.producer = producer;
        this.winner = winner;
    }

    public Integer getYearAward() {
        return yearAward;
    }

    public String getProducer() {
        return producer;
    }

}
