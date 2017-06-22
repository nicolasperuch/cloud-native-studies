package rest;

public class Bike extends Vehicle {
    public Bike() {
        super.setName("BIKE");
        super.setValidatePayment(0.45);
    }

    @Override
    public String toString(){
        return  "VEICULO: " + getName() +
                "\nVALOR DO VEICULO: " + getValidatePayment();
    }
}
