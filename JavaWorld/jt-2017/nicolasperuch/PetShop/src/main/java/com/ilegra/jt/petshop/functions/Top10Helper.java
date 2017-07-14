package com.ilegra.jt.petshop.functions;

import com.ilegra.jt.animal.Animal;

public class Top10Helper {

    private Animal animal;
    private double cost;

    public Top10Helper() {
        this.animal = new Animal();
        this.cost = 0;
    }

    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    @Override
    public String toString() {
        return "Top10Helper{" +
                "animal=" + animal +
                ", cost=" + cost +
                '}';
    }
}
