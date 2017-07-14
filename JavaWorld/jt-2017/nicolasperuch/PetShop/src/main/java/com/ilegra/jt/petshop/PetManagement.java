package com.ilegra.jt.petshop;

import com.ilegra.jt.animal.Animal;
import java.util.HashMap;
import java.util.Map;

public class PetManagement {

    Map<Animal, Activities> listActivities = new HashMap<>();




    public Map<Animal, Activities> getListActivities() {
        return listActivities;
    }

    public void setListActivities(Map<Animal, Activities> listActivities) {
        this.listActivities = listActivities;
    }
}
