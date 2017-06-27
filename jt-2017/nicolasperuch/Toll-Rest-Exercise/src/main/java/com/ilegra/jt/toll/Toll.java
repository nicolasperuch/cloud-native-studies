package com.ilegra.jt.toll;

import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@Service
@ApplicationPath("toll")
public class Toll extends Application {

    private Car car;
    private Bus bus;
    private Bicycle bicycle;
    private Bike bike;
    private Truck truck;
    private Response.ResponseBuilder response;

    @GET
    @Path("/car/{payment}")
    @Produces("text/plain")
    public Response carPayment(@PathParam("payment") double payment) {
        return car.payToll(payment, car.getCost());
    }
    @GET
    @Path("/car")
    @Produces("text/plain")
    public Response carPrint() {
        return car.printToll(car.getCost());
    }
    @GET
    @Path("/bus/{payment}")
    @Produces("text/plain")
    public Response busPayment(@PathParam("payment") double payment) {
        return bus.payToll(payment, bus.getCost());
    }
    @GET
    @Path("/bus")
    @Produces("text/plain")
    public Response busPrint() {
        return bus.printToll(bus.getCost());
    }
    @GET
    @Path("/bicycle/{payment}")
    @Produces("text/plain")
    public Response bicyclePayment(@PathParam("payment") double payment) {
        return bicycle.payToll(payment, bicycle.getCost());
    }
    @GET
    @Path("/bicycle")
    @Produces("text/plain")
    public Response bicyclePrint() {
        return bicycle.printToll(bicycle.getCost());
    }
    @GET
    @Path("/bike/{payment}")
    @Produces("text/plain")
    public Response bikePayment(@PathParam("payment") double payment) {
        return bike.payToll(payment, bike.getCost());
    }
    @GET
    @Path("/bike")
    @Produces("text/plain")
    public Response bikePrint() {
        return bike.printToll(bike.getCost());
    }
    @GET
    @Path("/truck/{axis}/{payment}")
    @Produces("text/plain")
    public Response truckPayment(@PathParam("payment") double payment, @PathParam("axis") int axis) {
        return truck.payToll(payment, axis);
    }
    @GET
    @Path("/truck/{axis}")
    @Produces("text/plain")
    public Response truckPrint(@PathParam("axis") int axis) {
        return truck.printToll(axis);
    }

    public void setCar(Car car) {
        this.car = car;
    }
    public void setBus(Bus bus) {
        this.bus = bus;
    }
    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }
    public void setBike(Bike bike) {
        this.bike = bike;
    }
    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}
