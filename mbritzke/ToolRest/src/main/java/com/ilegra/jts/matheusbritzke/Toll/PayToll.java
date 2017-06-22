package com.ilegra.jts.matheusbritzke.Toll;

import com.ilegra.jts.matheusbritzke.Vehicles.Vehicle;

import javax.ws.rs.core.Response;

public class PayToll {

    Response.ResponseBuilder response;

    public Response payment(Vehicle vehicle, double payment){
        boolean validate = validatePayment(payment);
        if(validate){
            response = Response.ok(vehicle.toString() + "\nInvalid payment\n");
        }
        try {
            double cash = cashChange(vehicle, payment);
            if(cash < 0)
                response = Response.ok(vehicle.toString() + "\nPayment: " + payment + "\nChange: " + cash + "\nInsufficient payment\n");
            else
                response = Response.ok(vehicle.toString() + "\nPayment: " + payment + "\nChange: " + cash + "\nPayment made\n");
        } catch (Exception e){
            response = Response.serverError();
        }
        return response.build();
    }

    private boolean validatePayment(double payment){
        boolean validate = false;
        if(payment <= 0)
            validate = true;
        return validate;
    }

    private double cashChange(Vehicle vehicle, double payment){
        return payment - vehicle.getPrice();
    }

}
