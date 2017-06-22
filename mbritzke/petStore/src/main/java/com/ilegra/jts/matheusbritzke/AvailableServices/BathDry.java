package com.ilegra.jts.matheusbritzke.AvailableServices;

import com.ilegra.jts.matheusbritzke.Pojo.Pet;

public class BathDry implements AvailableServices{

    private final double price = 15.0;

    @Override
    public boolean doService(Pet pet) {
        if(pet != null){
            pet.getServices().add(new BathDry());
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
        return "BathDry{" +
                "price=" + price +
                '}';
    }
}
