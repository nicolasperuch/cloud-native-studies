package com.ilegra.jt.toll;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;


public class PayToll extends Application {

    Response.ResponseBuilder response;

    public Response payToll(double payment, double cost) {

        if (payment >= cost) {
            response = Response.ok("The toll was paid!\n" + payment + " - " + cost + " = " + calculateToll(payment, cost));
            return response.build();
        } else {
            response = Response.ok("The payment was not enough\n" + payment + " - " + cost + " = " + calculateToll(payment, cost));
            return response.build();
        }
    }

    public Response printToll(double cost) {
            response = Response.ok("Your vehicle costs: "+cost);
            return response.build();
    }

    public double calculateToll(double payment, double cost){
        return payment - cost;
    }
}