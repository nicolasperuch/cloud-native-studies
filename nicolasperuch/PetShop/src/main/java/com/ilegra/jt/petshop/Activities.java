package com.ilegra.jt.petshop;

public class Activities {
    private boolean withPerfume;
    private boolean withWater;
    private boolean shortHair;
    private double cost;

    public Activities(boolean withPerfume, boolean withWater, boolean shortHair) {
        this.withPerfume = withPerfume;
        this.withWater = withWater;
        this.shortHair = shortHair;
        calculateCost();
    }

    private void calculateCost(){
        cost = 0;
        if(withPerfume)
            cost += 20;
        if(withWater)
            cost += 20;
        else
            cost += 10;
        if(shortHair)
            cost += 10;
        else
            cost += 5;
    }

    public boolean isWithPerfume() {
        return withPerfume;
    }
    public void setWithPerfume(boolean withPerfume) {
        this.withPerfume = withPerfume;
    }
    public boolean isWithWater() {
        return withWater;
    }
    public void setWithWater(boolean withWater) {
        this.withWater = withWater;
    }
    public boolean isShortHair() {
        return shortHair;
    }
    public void setShortHair(boolean shortHair) {
        this.shortHair = shortHair;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Activities{" +
                "withPerfume=" + withPerfume +
                ", withWater=" + withWater +
                ", shortHair=" + shortHair +
                ", cost=" + cost +
                '}';
    }
}


