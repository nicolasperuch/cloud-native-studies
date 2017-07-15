package rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.ResponseBuilder;

@Service
@ApplicationPath("toll")
public class TollResource extends Application implements Toll {
    private ResponseBuilder response;
    private Bike bike;
    private Bus bus;
    private Car car;
    private Motorcycle motorcycle;
    private Truck truck;

    @Autowired
    public TollResource(Bike bike, Bus bus, Car car, Motorcycle motorcycle, Truck truck) {
        this.bike = bike;
        this.bus = bus;
        this.car = car;
        this.motorcycle = motorcycle;
        this.truck = truck;
    }

    @GET
    @Path("/")
    @Produces("text/html")
    public String tollPage(){
        return "<html lang=\"en\"><body><a href=\"http://127.0.1.1:8080/rest/toll/bike\">BIKE</a> - INFO</body></html>" +
                "<html lang=\"en\"><body><br><a href=\"http://127.0.1.1:8080/rest/toll/bus\">BUS</a> - INFO</body></html>" +
                "<html lang=\"en\"><body><br><a href=\"http://127.0.1.1:8080/rest/toll/car\">CAR</a> - INFO</body></html>" +
                "<html lang=\"en\"><body><br><a href=\"http://127.0.1.1:8080/rest/toll/motorcycle\">MOTORCYCLE</a> - INFO</body></html>" +
                "<html lang=\"en\"><body><br><a href=\"http://127.0.1.1:8080/rest/toll/truck\">TRUCK</a> - INFO</body></html>";
    }

    @GET
    @Path("/bike")
    @Produces("text/plain")
    public Response bikePage(){
        response = Response.ok(bike.toString());
        return response.build();
    }

    @GET
    @Path("/bus")
    @Produces("text/plain")
    public Response busPage(){
        response = Response.ok(bus.toString());
        return response.build();
    }

    @GET
    @Path("/car")
    @Produces("text/plain")
    public Response carPage(){
        response = Response.ok(car.toString());
        return response.build();
    }

    @GET
    @Path("/motorcycle")
    @Produces("text/plain")
    public Response motorcyclePage(){
        response = Response.ok(motorcycle.toString());
        return response.build();
    }

    @GET
    @Path("/truck")
    @Produces("text/plain")
    public Response truckPage(){
        response = Response.ok(truck.toString());
        return response.build();
    }

    @GET
    @Path("/bike/{clientMoney}")
    @Produces("text/plain")
    @Override
    public Response bikePayment(@PathParam("clientMoney") double clientMoney) {
        response = Response.ok(validatePayment(bike.getValidatePayment(), clientMoney));
        return response.build();
    }

    @GET
    @Path("/bus/{clientMoney}")
    @Produces("text/plain")
    @Override
    public Response busPayment(@PathParam("clientMoney") double clientMoney) {
        response = Response.ok(validatePayment(bus.getValidatePayment(), clientMoney));
        return response.build();
    }

    @GET
    @Path("/car/{clientMoney}")
    @Produces("text/plain")
    @Override
    public Response carPayment(@PathParam("clientMoney") double clientMoney) {
        response = Response.ok(validatePayment(car.getValidatePayment(),clientMoney));
        return response.build();
    }


    @GET
    @Path("/motorcycle/{clientMoney}")
    @Produces("text/plain")
    @Override
    public Response motorcyclePayment(@PathParam("clientMoney") double clientMoney) {
        response = Response.ok(validatePayment(motorcycle.getValidatePayment(), clientMoney));
        return response.build();
    }

    @GET
    @Path("/truck/{additionalAxis}/{clientMoney}")
    @Produces("text/plain")
    @Override
    public Response truckPayment(@PathParam("additionalAxis") int additionalAxis, @PathParam("clientMoney") double clientMoney) {
        truck.setAdditionalAxis(additionalAxis);
        response = Response.ok(validatePayment(truck.getTotalValue(additionalAxis), clientMoney));
        return response.build();
    }

    @GET
    @Produces("text/plain")
    public String validatePayment(double clientMoney , double vehicleValue){
        String validatePayment;
        if((vehicleValue - clientMoney)>0){
            validatePayment = "PAGO!" + "TROCO: " + (-1*(clientMoney-vehicleValue));
            }else{
            validatePayment = "DINHEIRO INSUFICIENTE! " + "CLIENTE DEVE: " + (clientMoney-vehicleValue);
        }return validatePayment;
    }
}