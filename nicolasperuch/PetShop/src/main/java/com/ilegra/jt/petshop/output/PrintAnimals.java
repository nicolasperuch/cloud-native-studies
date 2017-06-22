package com.ilegra.jt.petshop.output;

import com.ilegra.jt.animal.Animal;
import com.ilegra.jt.petshop.database.AnimalsManagement;

public class PrintAnimals {

    public void printAnimalList(AnimalsManagement animalsManagement){
        for(Animal animal : animalsManagement.getAnimalList())
            System.out.println(animal.toString());
    }
}
