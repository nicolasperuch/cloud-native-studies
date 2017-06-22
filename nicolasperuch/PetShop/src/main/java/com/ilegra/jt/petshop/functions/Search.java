package com.ilegra.jt.petshop.functions;

import com.ilegra.jt.animal.Animal;
import com.ilegra.jt.petshop.database.AnimalsManagement;

public class Search {

    public Animal searchPet(int id, AnimalsManagement animalsManagement) {

        Animal animal2 = new Animal();

        try{
            for (Animal animal : animalsManagement.getAnimalList()) {
                if (animal.getId() == id)
                    return animal;
            }
        }catch (Exception e){
            e.printStackTrace();
            return animal2;
        }
        return animal2;
    }
}