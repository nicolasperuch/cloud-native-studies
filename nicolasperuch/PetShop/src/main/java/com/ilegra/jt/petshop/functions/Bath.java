package com.ilegra.jt.petshop.functions;

import com.ilegra.jt.petshop.Activities;
import com.ilegra.jt.petshop.database.ActivitiesManagement;

public class Bath {

    public boolean doBath (int id, boolean perfume, boolean water, boolean hair,
                            ActivitiesManagement petManagement){
        try {
            Activities activity = new Activities(perfume, water, hair);
            petManagement.getListActivities().get(id).add(activity);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
