package com.challenge.goldenraspberryawards.movie;

public class AwardsInterval {

    private final String producer;
    private int previousWin;
    private int followingWin;
    private int interval;

    public AwardsInterval(String producer, int previousWin) {
        this.producer = producer;
        this.previousWin = previousWin;
    }

    public String getProducer() {
        return producer;
    }

    public int getPreviousWin() {
        return previousWin;
    }

    public void setPreviousWin(int previousWin) {
        this.previousWin = previousWin;
    }

    public int getFollowingWin() {
        return followingWin;
    }

    public void setFollowingWin(int followingWin) {
        this.followingWin = followingWin;
        interval = followingWin - previousWin;
    }

    public int getInterval() {
        return interval;
    }

    public void moveToNextInterval() {
        previousWin = followingWin;
        followingWin = 0;
        interval = 0;
    }
}
