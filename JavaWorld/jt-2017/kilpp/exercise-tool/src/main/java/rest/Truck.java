package rest;

/**
 * Created by ilegra0318 on 02/06/17.
 */
public class Truck extends Vehicle{
    private String name = "TRUCK";
    private int additionalAxis;

    public Truck() {
        super.setName("TRUCK");
        super.setValidatePayment(getTotalValue(getAdditionalAxis()));
    }

    public int getAdditionalAxis() {
        return additionalAxis;
    }

    public void setAdditionalAxis(int additionalAxis) {
        this.additionalAxis = additionalAxis;
    }

    public double getTotalValue(int additionalAxis) {
        setValidatePayment(3.95 + (additionalAxis * 1));
        return getValidatePayment();
    }

    @Override
    public String toString(){
        return  "VEICULO: " + name +
                "\nVALOR BASE DO VEICULO: " + 3.95 +
                "\nVALOR POR EIXO AIDICIONAL: " + 1;

    }
}
