package com.ilegra.jt.petshop;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ilegra.jt.animal.Animal;
import com.ilegra.jt.injector.AppInjector;
import com.ilegra.jt.petshop.functions.*;
import com.ilegra.jt.petshop.output.PrintActivities;
import com.ilegra.jt.petshop.output.PrintAnimals;


public class Home implements PetShop {

    private Injector injector = Guice.createInjector(new AppInjector());

    @Override
    public boolean doBath(int id, boolean perfume, boolean water, boolean hair) {
        Bath bath = injector.getInstance(Bath.class);
        return bath.execute(id, perfume, water,hair);
    }

    @Override
    public boolean addPet(int id, int age, String race, String name) {
        Add add = injector.getInstance(Add.class);
        return add.addPet(id, age, race, name);
    }

    @Override
    public boolean removePet(int id) {
        Remove remove = injector.getInstance(Remove.class);
        return remove.removePet(1);
    }

    @Override
    public Animal searchPet(int id) {
        Search search = injector.getInstance(Search.class);
        return search.search(id);
    }

    public void printAnimalList(){
        PrintAnimals print = injector.getInstance(PrintAnimals.class);
        print.printAnimalList();
    }

    public void printActivityList(){
        PrintActivities print = injector.getInstance(PrintActivities.class);
        print.printActivities();
    }
    public void top10Revenue(){
        Top10 top10 = injector.getInstance(Top10.class);
        top10.generate();
    }
}


