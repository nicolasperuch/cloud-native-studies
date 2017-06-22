package com.ilegra.jt.petshop;

import com.ilegra.jt.petshop.functions.AddPet;
import com.ilegra.jt.petshop.functions.Bath;
import com.ilegra.jt.petshop.functions.Hair;

public class Mid implements PetShop {


    @Override
    public Bath doBath() {
        Bath bath = new Bath();
        return bath.execute("perfume","dry");
    }

    @Override
    public Hair cutHair() {
        Hair hair = new Hair();
        return hair.execute("short");
    }

    @Override
    public String addPet() {
        AddPet addPet = new AddPet();
        addPet.addPet();
        return null;
    }

    @Override
    public String removePet(String name, String race) {
        return null;
    }

    @Override
    public String searchPet(String name) {
        return null;
    }

}


