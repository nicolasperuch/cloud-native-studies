package com.ilegra.jts.matheusbritzke.PetStore;

import com.ilegra.jts.matheusbritzke.AvailableServices.AvailableServices;
import com.ilegra.jts.matheusbritzke.MapOfServices.MapServices;
import com.ilegra.jts.matheusbritzke.Pojo.Pet;
import com.ilegra.jts.matheusbritzke.SortList.SortPet;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
public class SimpleStore implements ServicesPet {

    private List<Pet> allPets;
    private MapServices mapServices;
    private List<String> servicesPet;

    @Inject
    public SimpleStore(ArrayList<Pet> allPets, MapServices mapServices, ArrayList<String> servicesPet) {
        this.allPets = allPets;
        this.mapServices = mapServices;
        this.servicesPet = servicesPet;
    }

    @Override
    public boolean addPets(Pet pet) {
        if(petById(pet.getId()) != -1)
            return false;
        allPets.add(pet);
        return true;
    }

    @Override
    public boolean removePet(int id) {
        int statusPet = petById(id);
        if(statusPet == -1)
            return false;
        allPets.remove(statusPet);
        return true;
    }

    @Override
    public String search(int age) {
        boolean statusAge = validateAge(age);
        StringBuilder petsEqualToAge = new StringBuilder();
        if(!statusAge){
            petsEqualToAge.append("Incorrect age");
            return petsEqualToAge.toString();
        }
        for(Pet pet: allPets){
            if(pet.getAge() == age)
                petsEqualToAge.append(pet.toString());
        }
        if(petsEqualToAge.length() == 0)
            petsEqualToAge.append("no pets found");
        return petsEqualToAge.toString();
    }

    @Override
    public boolean doService(int idPet, int idService) {
        int position = petById(idPet);
        if(position == -1)
            return false;
        AvailableServices service = mapServices.getSpecificService(idService);
        Pet pet = allPets.get(position);
        pet.getServices().add(service);
        createService(pet, service.toString());
        return true;
    }

    @Override
    public void historyServices() {
        for(int i=0; i<servicesPet.size(); i++){
            System.out.println(servicesPet.get(i));
        }
    }

    @Override
    public void top10() {
        petCalculateServices();
        SortPet sortPet = new SortPet();
        Collections.sort(allPets, sortPet);
        for(int i = 0; i < allPets.size(); i++){
            System.out.println(allPets.get(i).toString());
        }
    }

    private int petById(int id) {
        for (int i = 0; i < allPets.size(); i++) {
            Pet auxiliaryPet = allPets.get(i);
            if (auxiliaryPet.getId() == id)
                return i;
        }
        return -1;
    }

    private boolean validateAge(int age) {
        return age >= 1 && age <= 18;
    }

    private void petCalculateServices(){
        for (Pet pet: allPets) {
            pet.calculateServices();
        }
    }

    private void createService(Pet pet, String s) {
        String service = pet.getName() + " - " + s;
        servicesPet.add(service);
    }

    public void getAllPets() {
        for(Pet pet: allPets)
            System.out.println(pet.toString());
    }
}
