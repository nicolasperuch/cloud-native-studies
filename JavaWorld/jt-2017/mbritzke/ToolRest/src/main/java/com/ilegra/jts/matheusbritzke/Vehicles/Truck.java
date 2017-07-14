package com.ilegra.jts.matheusbritzke.Vehicles;

public class Truck implements Vehicle{

    private double price = 3.95;
    private int additionalAxes = 0;

    public void setAdditionalAxes(int additionalAxes){
        this.additionalAxes = additionalAxes;
    }

    @Override
    public double getPrice() {
        return (price + (additionalAxes * 1.00));
    }

    @Override
    public String toString() {
        return "Truck{" +
                "price=" + price +
                '}';
    }
}
