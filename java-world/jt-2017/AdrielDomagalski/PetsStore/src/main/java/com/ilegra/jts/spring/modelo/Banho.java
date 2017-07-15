package com.ilegra.jts.spring.modelo;

/**
 * Created by Adriel on 30/05/2017.
 */
public class Banho {
    private boolean perfume;
    private boolean seco;
    private int id;
    private boolean agua;

    public Banho(int id, boolean perfume, boolean seco, boolean agua) {
        this.perfume = perfume;
        this.seco = seco;
        this.agua = agua;
    }

    public boolean isPerfume() {
        return perfume;
    }

    public void setPerfume(boolean perfume) {
        this.perfume = perfume;
    }

    public boolean isSeco() {
        return seco;
    }

    public void setSeco(boolean seco) {
        this.seco = seco;
    }

    public boolean isAgua() {
        return agua;
    }

    public void setAgua(boolean agua) {
        this.agua = agua;
    }
}