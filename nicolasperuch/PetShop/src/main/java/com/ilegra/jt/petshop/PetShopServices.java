package com.ilegra.jt.petshop;

import com.google.inject.Inject;
import com.ilegra.jt.animal.Animal;
import com.ilegra.jt.petshop.database.ActivitiesManagement;
import com.ilegra.jt.petshop.database.AnimalsManagement;
import com.ilegra.jt.petshop.functions.*;
import com.ilegra.jt.petshop.output.PrintActivities;
import com.ilegra.jt.petshop.output.PrintAnimals;

public class PetShopServices implements PetShop {


    private AnimalsManagement animalsManagement;
    private ActivitiesManagement petManagement;
    private PrintAnimals printAnimals;
    private PrintActivities printActivities;
    private Add add;
    private Bath bath;
    private Remove remove;
    private Search search;
    private Top10 top10;

    @Inject
    public PetShopServices(AnimalsManagement animalsManagement, ActivitiesManagement petManagement,
                           PrintAnimals printAnimals, PrintActivities printActivities,
                           Add add, Bath bath, Remove remove, Search search, Top10 top10) {

        this.animalsManagement = animalsManagement;
        this.petManagement = petManagement;
        this.printAnimals = printAnimals;
        this.printActivities = printActivities;
        this.add = add;
        this.bath = bath;
        this.remove = remove;
        this.search = search;
        this.top10 = top10;
    }

    @Override
    public boolean doBath(int id, boolean perfume, boolean water, boolean hair) {
        return bath.doBath(id, perfume, water, hair, petManagement);
    }

    @Override
    public boolean addPet(int id, int age, String race, String name) {
        return add.addPet(id, age, race ,name, animalsManagement, petManagement);
    }

    @Override
    public boolean removePet(int id) {
        return remove.removePet(1, animalsManagement);
    }

    @Override
    public Animal searchPet(int id) {
        return search.searchPet(id, animalsManagement);
    }

    public void printAnimalList(){
        printAnimals.printAnimalList(animalsManagement);
    }

    public void printActivityList(){
        printActivities.printActivities(petManagement);
    }

    public void top10Revenue(){
        top10.generateTop10(petManagement, animalsManagement);
    }
}


