package com.ilegra.jt;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ilegra.jt.injector.AppInjector;
import com.ilegra.jt.petshop.PetShopServices;

public class Main {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new AppInjector());
        PetShopServices petShopServices = injector.getInstance(PetShopServices.class);

        petShopServices.addPet(1,3,"Cachorro", "Spock");
        petShopServices.addPet(2,3,"Golden", "Goldofredo");
        petShopServices.addPet(3,6,"Pug", "Gym");
        petShopServices.printAnimalList();
        petShopServices.doBath(1,true,true,true);
        petShopServices.doBath(1,true,true,true);
        petShopServices.doBath(2,false,true,true);
        petShopServices.doBath(1,false,true,false);
        petShopServices.doBath(3,false,false,false);
        petShopServices.searchPet(1);
        petShopServices.printActivityList();
        petShopServices.top10Revenue();
        petShopServices.removePet(1);
        petShopServices.printAnimalList();

    }

}
