package rest;

public class Car extends Vehicle{

    public Car() {
        super.setName("CAR");
        super.setValidatePayment(2.11);
    }

    @Override
    public String toString(){
        return  "VEICULO: " + getName() +
                "\nVALOR DO VEICULO: " + getValidatePayment();
    }
}
