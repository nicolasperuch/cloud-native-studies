package com.ilegra.jts.matheusbritzke.Vehicles;

public class Bus implements Vehicle{

    private double price = 1.59;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "price=" + price +
                '}';
    }
}
