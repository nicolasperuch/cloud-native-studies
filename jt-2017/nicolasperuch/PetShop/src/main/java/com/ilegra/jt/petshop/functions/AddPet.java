package com.ilegra.jt.petshop.functions;

import com.ilegra.jt.animal.Animal;
import com.ilegra.jt.petshop.Activities;

import java.util.Map;

public class AddPet {

    public void addPet(){
        Animal pet = new Animal(1,3,"adidas","Rex");



        Map<Animal, Activities> listActivities = getListActivities();
    }
}
