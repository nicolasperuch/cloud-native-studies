package com.ilegra.jt.petshop.functions;

import com.ilegra.jt.animal.Animal;
import com.ilegra.jt.petshop.database.ActivitiesManagement;
import com.ilegra.jt.petshop.database.AnimalsManagement;

import java.util.ArrayList;

public class Add {

    public boolean addPet(int id, int age, String race, String name,
                          AnimalsManagement animalsManagement,
                          ActivitiesManagement petManagement){
        try {
            Animal pet = new Animal(id, age, race, name);
            animalsManagement.getAnimalList().add(pet);
            petManagement.getListActivities().put(pet.getId(), new ArrayList<>());
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
