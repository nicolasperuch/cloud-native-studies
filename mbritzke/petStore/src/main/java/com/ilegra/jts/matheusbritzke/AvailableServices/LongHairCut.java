package com.ilegra.jts.matheusbritzke.AvailableServices;

import com.ilegra.jts.matheusbritzke.Pojo.Pet;

public class LongHairCut implements AvailableServices{

    private final double price = 15.0;

    @Override
    public boolean doService(Pet pet) {
        if (pet != null) {
            pet.getServices().add(new LongHairCut());
            return true;
        }
        return false;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "LongHairCut{" +
                "price=" + price +
                '}';
    }
}
