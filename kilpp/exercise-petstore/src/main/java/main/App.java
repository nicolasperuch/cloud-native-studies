package main;
import com.google.inject.Guice;
import com.google.inject.Injector;
import model.PetStoreService;
import module.PetStoreServiceModule;

public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new PetStoreServiceModule());
        PetStoreService petStoreService = injector.getInstance(PetStoreService.class);

        petStoreService.addPet(1,"Mujica","Vira-Lata",3);
        System.out.println(petStoreService.getPetMap().getPetMap());

        petStoreService.removePet(1);
        System.out.println(petStoreService.getPetMap().getPetMap());

        petStoreService.addPet(1,"Mujica","Vira-Lata",3);

        petStoreService.addPet(2,"Lucke","Vira-Lata",6);
        System.out.println(petStoreService.getPetMap().getPetMap());

        petStoreService.doBath(1,true,true);

        petStoreService.doHairCut(1,true);

        petStoreService.doHairCut(1,true);

        petStoreService.searchByPetAge(3);

        System.out.println(petStoreService.getServiceMap().getServiceList());

        
        petStoreService.topRevenuePets();


    }
}
