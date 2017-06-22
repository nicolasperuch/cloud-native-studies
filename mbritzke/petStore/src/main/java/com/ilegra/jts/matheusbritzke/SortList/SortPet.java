package com.ilegra.jts.matheusbritzke.SortList;

import com.ilegra.jts.matheusbritzke.Pojo.Pet;

import java.util.Comparator;

public class SortPet implements Comparator<Pet>{

    @Override
    public int compare(Pet pet, Pet t1) {
        if(pet.getTotalServices() > t1.getTotalServices())
            return -1;
        if(pet.getTotalServices() < t1.getTotalServices())
            return 1;
        return 0;
    }
}
