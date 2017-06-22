package com.ilegra.jts.matheusbritzke.AvailableServices;

import com.ilegra.jts.matheusbritzke.Pojo.Pet;

public class BathDryPerfume implements AvailableServices{

    private final double price = 20.0;

    @Override
    public boolean doService(Pet pet) {
        if(pet != null){
            pet.getServices().add(new BathDryPerfume());
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
        return "BathDryPerfume{" +
                "price=" + price +
                '}';
    }
}
