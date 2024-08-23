package com.challenge.goldenraspberryawards.movie;

import java.util.ArrayList;
import java.util.List;

public class SmallestAndLargestIntervalBetweenAwards {

    private final List<ProducerResponse> min;

    private final List<ProducerResponse> max;

    public SmallestAndLargestIntervalBetweenAwards() {
        min = new ArrayList<>();
        max = new ArrayList<>();
    }

    public SmallestAndLargestIntervalBetweenAwards(List<ProducerResponse> min, List<ProducerResponse> max) {
        this.min = min;
        this.max = max;
    }

    public List<ProducerResponse> getMin() {
        return min;
    }

    public List<ProducerResponse> getMax() {
        return max;
    }

}
