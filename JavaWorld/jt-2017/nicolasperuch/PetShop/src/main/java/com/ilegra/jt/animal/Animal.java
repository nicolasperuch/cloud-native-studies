package com.ilegra.jt.animal;

public class Animal {

    private int id;
    private int age;
    private String race;
    private String name;

    public Animal() {}

    public Animal(int id, int age, String race, String name) {
        this.id = id;
        this.age = age;
        this.race = race;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getRace() {
        return race;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", age=" + age +
                ", race='" + race + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

