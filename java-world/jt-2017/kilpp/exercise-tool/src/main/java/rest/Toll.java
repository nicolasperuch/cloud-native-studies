package rest;
import javax.ws.rs.core.Response;

public interface Toll {
    Response carPayment(double clientMoney);
    Response busPayment(double clientMoney);
    Response bikePayment(double clientMoney);
    Response motorcyclePayment(double clientMoney);
    Response truckPayment(int additionalAxis, double clientMoney);
    String validatePayment(double clientMoney , double vehicleValue);
}
