package com.ilegra.jt.petshop.functions;

import com.ilegra.jt.animal.Animal;
import com.ilegra.jt.petshop.database.AnimalsManagement;

import java.util.List;

public class Remove {

    public boolean removePet(int id, AnimalsManagement animalsManagement){

        List<Animal> animalList = animalsManagement.getAnimalList();

        try {
            for (Animal animal : animalList) {
                if (animal.getId() == id) {
                    animalList.remove(animal);
                    return true;
                }
            }
            return false;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
