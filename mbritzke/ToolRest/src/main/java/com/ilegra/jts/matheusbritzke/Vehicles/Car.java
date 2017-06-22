package com.ilegra.jts.matheusbritzke.Vehicles;

public class Car implements Vehicle{

    private double price = 2.11;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                '}';
    }
}
