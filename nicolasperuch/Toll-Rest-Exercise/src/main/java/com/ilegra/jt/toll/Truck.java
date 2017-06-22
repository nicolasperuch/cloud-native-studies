package com.ilegra.jt.toll;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


public class Truck extends PayToll {

    private final double cost = 3.95;
    private final double costAxis = 1;
    private ResponseBuilder response;

    public Response payToll(double payment, int axis) {
        if (payment >= calculateCost(axis)) {
            response = Response.ok("The toll was paid!\n"+payment+" - "+calculateCost(axis)+" = "+calculateToll(payment, axis));
            return response.build();
        }
        response = Response.ok("The payment was not enough\n"+payment+" - "+calculateCost(axis)+" = "+calculateToll(payment, axis));
        return response.build();
    }

    private double calculateToll(double payment, int axis) {
        return payment - calculateCost(axis);
    }

    public Response printToll(int axis) {
        response = Response.ok("Your vehicle costs: "+cost+" plus 1.00 for wich axis.\n"+
                "So your total cost is: "+calculateCost(axis));
        return response.build();
    }
    public double calculateCost(int axis) {
        return cost + (axis * costAxis);
    }

    public double getCost() {
        return cost;
    }
}