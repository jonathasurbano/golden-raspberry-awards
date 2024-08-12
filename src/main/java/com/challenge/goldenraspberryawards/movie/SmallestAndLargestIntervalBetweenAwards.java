package com.challenge.goldenraspberryawards.movie;

import java.util.ArrayList;
import java.util.List;

public class SmallestAndLargestIntervalBetweenAwards {

    private final List<ProducerResponse> min = new ArrayList<>();

    private final List<ProducerResponse> max = new ArrayList<>();

    public List<ProducerResponse> getMin() {
        return min;
    }

    public List<ProducerResponse> getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "SmallestAndLargestIntervalBetweenAwards{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
