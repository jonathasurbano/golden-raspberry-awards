package com.challenge.goldenraspberryawards.movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Producer {

    private final String name;

    private final List<Integer> yearsInWhichItWonAwards = new ArrayList<>();

    private final List<Integer> theFirstTwoPrizes = new ArrayList<>();

    private final List<Integer> consecutivePrizes = new ArrayList<>();

    private Integer intervalBetweenTheFirstTwoPrizes;

    private Integer theLongestIntervalBetweenTwoConsecutivePrizes;

    private Boolean receivedMoreThanOneAward = false;

    public Producer(String name) {
        this.name = name;
    }

    public Boolean getReceivedMoreThanOneAward() {
        return receivedMoreThanOneAward;
    }

    public Integer getIntervalBetweenTheFirstTwoPrizes() {
        return intervalBetweenTheFirstTwoPrizes;
    }

    public Integer getTheLongestIntervalBetweenTwoConsecutivePrizes() {
        return theLongestIntervalBetweenTwoConsecutivePrizes;
    }

    public List<Integer> getTheFirstTwoPrizes() {
        return theFirstTwoPrizes;
    }

    public List<Integer> getConsecutivePrizes() {
        return consecutivePrizes;
    }

    public String getName() {
        return name;
    }

    public void addYearInWhichItWonAwards(int year) {
        yearsInWhichItWonAwards.add(year);
        receivedMoreThanOneAward = yearsInWhichItWonAwards.size() > 1;
    }

    public void calcIntervals() {
        if (receivedMoreThanOneAward) {

            Collections.sort(yearsInWhichItWonAwards);

            intervalBetweenTheFirstTwoPrizes = yearsInWhichItWonAwards.get(1) - yearsInWhichItWonAwards.get(0);
            theFirstTwoPrizes.add(yearsInWhichItWonAwards.get(0));
            theFirstTwoPrizes.add(yearsInWhichItWonAwards.get(1));

            calcTheLongestIntervalBetweenTwoConsecutivePrizes();
        }
    }

    private void calcTheLongestIntervalBetweenTwoConsecutivePrizes() {

        for (int i = 1; i < yearsInWhichItWonAwards.size(); i++) {

            int aux = yearsInWhichItWonAwards.get(i) - yearsInWhichItWonAwards.get(i - 1);

            if (theLongestIntervalBetweenTwoConsecutivePrizes == null || aux < theLongestIntervalBetweenTwoConsecutivePrizes) {

                theLongestIntervalBetweenTwoConsecutivePrizes = aux;
                consecutivePrizes.clear();
                consecutivePrizes.add(yearsInWhichItWonAwards.get(i - 1));
                consecutivePrizes.add(yearsInWhichItWonAwards.get(i));
            }
        }
    }

    @Override
    public String toString() {
        return "Producer{" + "name='" + name + '\'' + ", yearsInWhichItWonAwards=" + yearsInWhichItWonAwards + ", intervalBetweenTheFirstTwoPrizes=" + intervalBetweenTheFirstTwoPrizes + ", theLongestIntervalBetweenTwoConsecutivePrizes=" + theLongestIntervalBetweenTwoConsecutivePrizes + ", receivedMoreThanOneAward=" + receivedMoreThanOneAward + '}';
    }
}
