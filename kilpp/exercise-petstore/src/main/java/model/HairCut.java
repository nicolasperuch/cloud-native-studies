package model;

public class HairCut {
    private int id;
    private boolean shortOrLong;

    public HairCut(int id ,boolean shortOrLong) {
        this.shortOrLong = shortOrLong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getShortOrLong() {
        return shortOrLong;
    }

    public void setShortOrLong(boolean shortOrLong) {
        this.shortOrLong = shortOrLong;
    }


    public String toString() {
        if (shortOrLong == true) {
            return "CORTE LONGO";
        } else {
            return "CORTE CURTO";
        }
    }
}

