package com.ilegra.jts.matheusbritzke.Pojo;

import com.ilegra.jts.matheusbritzke.AvailableServices.AvailableServices;

import java.util.ArrayList;
import java.util.List;

public class Pet {

    private int id;
    private String name;
    private String race;
    private int age;
    private List<AvailableServices> services;
    private double totalServices;

    public Pet(int id, String name, String race, int age, ArrayList<AvailableServices> services){
        this.id = id;
        this.name = name;
        this.race = race;
        this.age = age;
        this.services = services;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName(){
        return name;
    }

    public String getRace(){
        return race;
    }

    public List<AvailableServices> getServices() {
        return services;
    }

    public double getTotalServices() {
        return totalServices;
    }

    public void calculateServices() {
        double price = 0;
        for(int i = 0; i < services.size(); i++){
            price += services.get(i).getPrice();
        }
        setTotalServices(price);
    }

    public void setTotalServices(double totalServices) {
        this.totalServices = totalServices;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", age=" + age +
                ", totalServices=" + totalServices +
                '}';
    }
}
