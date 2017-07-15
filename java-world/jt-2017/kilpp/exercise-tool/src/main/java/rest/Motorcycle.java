package rest;

public class Motorcycle extends Vehicle{

    public Motorcycle() {
        super.setName("MOTORCYCLE");
        super.setValidatePayment(1.00);
    }

    @Override
    public String toString(){
        return  "VEICULO: " + getName() +
                "\nVALOR DO VEICULO: " + getValidatePayment();
    }
}

