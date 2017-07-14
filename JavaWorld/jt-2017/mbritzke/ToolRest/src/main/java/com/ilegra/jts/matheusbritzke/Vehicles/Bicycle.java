package com.ilegra.jts.matheusbritzke.Vehicles;

public class Bicycle implements Vehicle {

    private double price = 0.45;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "price=" + price +
                '}';
    }
}
