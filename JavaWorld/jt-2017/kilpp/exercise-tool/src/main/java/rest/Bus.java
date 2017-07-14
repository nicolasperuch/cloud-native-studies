package rest;

public class Bus extends Vehicle{
    public Bus() {
        super.setName("BUS");
        super.setValidatePayment(1.59);
    }

    @Override
    public String toString(){
        return  "VEICULO: " + getName() +
                "\nVALOR DO VEICULO: " + getValidatePayment();
    }
}
