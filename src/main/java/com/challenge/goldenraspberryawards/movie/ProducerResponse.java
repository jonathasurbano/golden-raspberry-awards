package com.challenge.goldenraspberryawards.movie;

import java.util.Objects;

public class ProducerResponse {

    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
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
    }

    @Override
    public String toString() {
        return "ProducerResponse{" +
                "producer='" + producer + '\'' +
                ", interval=" + interval +
                ", previousWin=" + previousWin +
                ", followingWin=" + followingWin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProducerResponse that = (ProducerResponse) o;
        return interval == that.interval && previousWin == that.previousWin && followingWin == that.followingWin && Objects.equals(producer, that.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, interval, previousWin, followingWin);
    }
}
