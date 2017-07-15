package com.ilegra.jts.matheusbritzke.Vehicles;

public class Moto implements Vehicle{

    private double price = 1.00;

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "price=" + price +
                '}';
    }
}
