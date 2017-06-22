package com.ilegra.jts.matheusbritzke.PetStore;

import com.ilegra.jts.matheusbritzke.Pojo.Pet;

import java.util.List;

public interface ServicesPet {

    boolean addPets(Pet pet);

    boolean removePet(int id);

    String search(int age);

    boolean doService(int idPet, int idService);

    void historyServices();

    void top10();

}
