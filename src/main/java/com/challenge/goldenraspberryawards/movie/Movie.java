package com.challenge.goldenraspberryawards.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movie {

    @Id
    private Integer id;
    private Integer year;
    private String producers;

    public Integer getYear() {
        return year;
    }

    public String getProducers() {
        return producers;
    }

}
