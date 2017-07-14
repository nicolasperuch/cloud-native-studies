package com.ilegra.jt.petshop.database;

import com.ilegra.jt.animal.Animal;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class AnimalsManagement {

    private List<Animal> animalList = new ArrayList<>();

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
