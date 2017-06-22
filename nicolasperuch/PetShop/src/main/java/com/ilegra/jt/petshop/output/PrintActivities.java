package com.ilegra.jt.petshop.output;

import com.ilegra.jt.petshop.Activities;
import com.ilegra.jt.petshop.database.ActivitiesManagement;

import java.util.List;
import java.util.Map;

public class PrintActivities {

    public void printActivities(ActivitiesManagement activitiesManagement){
        Map<Integer, List<Activities>> activitiesMap = activitiesManagement.getListActivities();

        for(Map.Entry<Integer, List<Activities>> activities : activitiesMap.entrySet()){
            for(Activities activity : activities.getValue())
                System.out.println(activities.getKey() + " = "+activity.toString());
        }
    }
}
