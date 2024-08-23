package com.challenge.goldenraspberryawards.movie;

import java.util.ArrayList;
import java.util.List;

public class Response {

    private final List<ProducerResponse> min = new ArrayList<>();
    private final List<ProducerResponse> max = new ArrayList<>();
    private int minInterval = 999;
    private int maxInterval = 0;

    public List<ProducerResponse> getMin() {
        return min;
    }

    public List<ProducerResponse> getMax() {
        return max;
    }

    public void updateTheShortestIntervalBetweenTheFirstTwoAwards(AwardsInterval awardsInterval) {
        if (awardsInterval.getInterval() < minInterval) {
            minInterval = awardsInterval.getInterval();
            min.clear();
        }

        if (awardsInterval.getInterval() == minInterval) {
            min.add(convertFromAwardsIntervalToProducerResponse(awardsInterval));
        }
    }

    public void updateTheLongestIntervalBetweenTwoConsecutivePrizes(AwardsInterval awardsInterval) {
        if (awardsInterval.getInterval() > maxInterval) {
            maxInterval = awardsInterval.getInterval();
            max.clear();
        }

        if (awardsInterval.getInterval() == maxInterval) {
            max.add(convertFromAwardsIntervalToProducerResponse(awardsInterval));
        }
    }

    private ProducerResponse convertFromAwardsIntervalToProducerResponse(AwardsInterval awardsInterval) {
        return new ProducerResponse(awardsInterval.getProducer(), awardsInterval.getInterval(),
                awardsInterval.getPreviousWin(), awardsInterval.getFollowingWin());
    }

}
