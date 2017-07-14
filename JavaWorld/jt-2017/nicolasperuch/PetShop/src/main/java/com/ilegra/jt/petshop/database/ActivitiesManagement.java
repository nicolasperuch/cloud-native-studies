package com.ilegra.jt.petshop.database;

import com.ilegra.jt.petshop.Activities;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class ActivitiesManagement {

    Map<Integer, List<Activities>> listActivities = new HashMap<>();

    public Map<Integer, List<Activities>> getListActivities() {
        return listActivities;
    }


}
