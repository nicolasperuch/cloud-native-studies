package com.ilegra.jts.spring.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ilegra.jts.spring.modelo.Pet;
import com.ilegra.jts.spring.modelo.ServicoPet;
import com.ilegra.jts.spring.modulo.PetServiceModulo;

/**
 * Created by Adriel on 29/05/2017.
 */
public class Principal {
    public static void main(String [] args){
       Injector injector = Guice.createInjector(new PetServiceModulo());
       ServicoPet servicoPet = injector.getInstance(ServicoPet.class);

       servicoPet.addPet(0,"pedro", "vira-lata", 5);
       servicoPet.removePet(0);

       servicoPet.addPet(0,"pedro", "vira-lata", 5);
       servicoPet.addPet(1, "goldofredo","golden", 6);
       servicoPet.addPet(2, "cabra", "cabrito",15);


       //servicoPet.pesquisaPorIdade(5);


       servicoPet.addBanho(1,false,true, true);
       servicoPet.addBanho(2,true,false, false);

       servicoPet.addCorte(0,false,true);
       servicoPet.addCorte(1,true,false);

       servicoPet.addBanho(1,true,true, false);
       servicoPet.addCorte(1,false,true);

       servicoPet.topPets();

    }
}
