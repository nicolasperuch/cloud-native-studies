package cxf.rest.vehicles;

public class BicycleResource {

    String output;
    Double totalTax = 0.45;

    public String printTax() {
        output = "U$ "+ totalTax;
        return output;
    }

    public String payTax(Double payment){
        Double money = payment - totalTax;
        if (money < 0){
            output = "Insufficient money. U$ "+ money;
        } else {
            output = "Up to pass. You must repay U$ "+ money;
        }

        return output;
    }
}
