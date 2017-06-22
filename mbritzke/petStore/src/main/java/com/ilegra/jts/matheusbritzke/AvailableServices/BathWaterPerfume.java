package com.ilegra.jts.matheusbritzke.AvailableServices;

import com.ilegra.jts.matheusbritzke.Pojo.Pet;

public class BathWaterPerfume implements AvailableServices {

    private final double price = 30.0;

    @Override
    public boolean doService(Pet pet) {
        if(pet !=  null){
            pet.getServices().add(new BathWaterPerfume());
            return true;
        }
        return false;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "BathWaterPerfume{" +
                "price=" + price +
                '}';
    }
}
