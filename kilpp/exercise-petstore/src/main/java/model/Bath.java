package model;

public class Bath {
    private boolean perfume;
    private boolean dryOrWater;

    public Bath(int id, boolean perfume, boolean dryOrWater) {
        this.perfume = perfume;
        this.dryOrWater = dryOrWater;
    }

    public boolean isPerfume() {
        return perfume;
    }

    public void setPerfume(boolean perfume) {
        this.perfume = perfume;
    }

    public boolean isDryOrWater() {
        return dryOrWater;
    }

    public void setDryOrWater(boolean dryOrWater) {
        this.dryOrWater = dryOrWater;
    }


    @Override
    public String toString() {
        if (dryOrWater == true && perfume == true) {
            return "BANHO COM AGUA E PERFUME";
        }else if(dryOrWater == true && perfume == false){
            return  "BANHO COM AGUA E SEM PERFUME";
        }else if(dryOrWater == false && perfume == true){
            return "BANHO SEM AGUA E COM PERFUME";
        }else{
            return "BANHO SEM AGUA E SEM PERFUME";
        }
    }

}


