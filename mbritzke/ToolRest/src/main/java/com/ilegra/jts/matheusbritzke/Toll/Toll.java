package com.ilegra.jts.matheusbritzke.Toll;

import com.ilegra.jts.matheusbritzke.Vehicles.*;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@Service
@ApplicationPath("toll")
public class Toll extends Application{

    private PayToll payToll;
    private Car car;
    private Bicycle bicycle;
    private Bus bus;
    private Moto moto;
    private Truck truck;

    public Toll(PayToll payToll, Car car, Bicycle bicycle, Bus bus, Moto moto, Truck truck){
        this.payToll = payToll;
        this.car = car;
        this.bicycle = bicycle;
        this.bus = bus;
        this.moto = moto;
        this.truck = truck;
    }

    @GET
    @Path("/car/{payment}")
    @Produces("text/plain")
    public Response car(@PathParam("payment") double payment){
        return payToll.payment(car,payment);
    }

    @GET
    @Path("/bicycle/{payment}")
    @Produces("text/plain")
    public Response bicycle(@PathParam("payment") double payment){
        return payToll.payment(bicycle,payment);
    }

    @GET
    @Path("/bus/{payment}")
    @Produces("text/plain")
    public Response bus(@PathParam("payment") double payment){
        return payToll.payment(bus, payment);
    }

    @GET
    @Path("/moto/{payment}")
    @Produces("text/plain")
    public Response moto(@PathParam("payment") double payment){
        return payToll.payment(moto,payment);
    }

    @GET
    @Path("/truck/{additionalAxes}/{payment}")
    @Produces("text/plain")
    public Response truck(@PathParam("additionalAxes")int additionalAxes, @PathParam("payment") double payment){
        truck.setAdditionalAxes(additionalAxes);
        return payToll.payment(truck,payment);
    }
}
