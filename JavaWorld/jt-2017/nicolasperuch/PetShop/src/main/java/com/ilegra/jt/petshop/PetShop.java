package com.ilegra.jt.petshop;

import com.ilegra.jt.animal.Animal;

public interface PetShop {
    boolean doBath(int id, boolean perfume, boolean water, boolean hair);
    boolean addPet(int id, int age, String race, String name);
    boolean removePet(int id);
    Animal searchPet(int id);

}
