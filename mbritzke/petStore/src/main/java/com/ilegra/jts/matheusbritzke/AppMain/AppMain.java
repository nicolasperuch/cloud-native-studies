package com.ilegra.jts.matheusbritzke.AppMain;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ilegra.jts.matheusbritzke.AppInjector.AppInjector;
import com.ilegra.jts.matheusbritzke.PetStore.SimpleStore;
import com.ilegra.jts.matheusbritzke.Pojo.Pet;

import java.util.ArrayList;

public class AppMain {

    public static void main(String[] args){
        Injector injector = Guice.createInjector(new AppInjector());
        SimpleStore simpleStore = injector.getInstance(SimpleStore.class);

        System.out.println("Add");
        simpleStore.addPets(new Pet(1, "kenai", "labrador", 10, new ArrayList<>()));
        simpleStore.addPets(new Pet(2, "bob", "pastor", 5, new ArrayList<>()));
        simpleStore.addPets(new Pet(3, "koda", "poodle", 2, new ArrayList<>()));
        simpleStore.getAllPets();
        System.out.println("finish add");

        System.out.println("Remove pet 1");
        simpleStore.removePet(1);
        simpleStore.getAllPets();
        System.out.println("finish remove");

        System.out.println("Search by age 5");
        System.out.println(simpleStore.search(5));
        System.out.println("finish search");

        System.out.println("Do service");
        simpleStore.doService(2, 2);
        simpleStore.doService(3, 1);
        simpleStore.doService(3, 4);
        System.out.println("Finish service");

        System.out.println("History Services");
        simpleStore.historyServices();
        System.out.println("Finish history services");

        System.out.println("Top 10");
        simpleStore.top10();
        System.out.println("Finish Top 10");
    }
}
