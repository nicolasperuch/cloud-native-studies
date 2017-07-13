package com.github.nicolasperuch.pojo;

public class Component {

    private String name;
    private String parent;
    private String status;
    private int number;

    public Component(String name, String parent, String status, int number) {
        this.name = name;
        this.parent = parent;
        this.status = status;
        this.number = number;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Component{" +
                "name='" + name + '\'' +
                ", parent='" + parent + '\'' +
                ", status='" + status + '\'' +
                ", number=" + number +
                '}';
    }
}
