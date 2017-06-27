package com.ilegra.jt.petshop.functions;

import com.ilegra.jt.petshop.Activities;
import com.ilegra.jt.petshop.database.ActivitiesManagement;
import com.ilegra.jt.petshop.database.AnimalsManagement;

import java.util.List;
import java.util.Map;

public class Top10 {

    private final int TAMANHOTOP10 = 10;
    private Top10Helper[] top10;


    public Top10() {
        top10 = new Top10Helper[TAMANHOTOP10];
        Top10Helper top10Helper = new Top10Helper();
        for (int i = 0; i < TAMANHOTOP10; i++) {
            top10[i] = top10Helper;
        }
    }


    public void generateTop10(ActivitiesManagement activitiesManagement,
                              AnimalsManagement animalsManagement) {

        Map<Integer, List<Activities>> auxiliar = activitiesManagement.getListActivities();

        for (Map.Entry<Integer, List<Activities>> activities : auxiliar.entrySet()) {
            buildList(activities, animalsManagement);
        }
        printTop10(top10);
    }

    private void printTop10(Top10Helper[] top10) {
        for (Top10Helper top10Helper : top10)
            if (top10Helper.getCost() > 0)
                System.out.println(top10Helper.toString());
    }

    public int getPosition() {
        int aux = 0;
        for (int i = 0; i < TAMANHOTOP10; i++) {
            if (top10[i].getCost() == 0)
                return i;
            if (i == 0)
                aux = i;
            if (top10[i].getCost() < top10[aux].getCost()) {
                aux = i;
            }
        }
        return aux;
    }

    public double gastoTotalPet(Map.Entry<Integer, List<Activities>> activities) {
        double acumuladorCost = 0;

        for (Activities activity : activities.getValue())
            acumuladorCost += activity.getCost();

        return acumuladorCost;
    }

    public boolean buildList(Map.Entry<Integer, List<Activities>> activities,
                            AnimalsManagement animalsManagement) {
        try {
            for (int i = 0; i < TAMANHOTOP10; i++) {
                if (top10[getPosition()].getCost() < gastoTotalPet(activities)) {
                    Search search = new Search();

                    Top10Helper help = new Top10Helper();
                    help.setCost(gastoTotalPet(activities));
                    help.setAnimal(search.searchPet(activities.getKey(), animalsManagement));
                    top10[getPosition()] = help;
                    i = TAMANHOTOP10;
                }
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}

