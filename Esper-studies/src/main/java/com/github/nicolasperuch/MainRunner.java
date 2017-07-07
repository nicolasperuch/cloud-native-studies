package com.github.nicolasperuch;

import com.espertech.esper.client.*;
import com.github.nicolasperuch.pojo.Tick;

import java.util.Random;

public class MainRunner {

    public static void main(String[] args) {

        Configuration cepConfig = new Configuration();
        cepConfig.addEventType("StockTick", Tick.class.getName());
        EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
        EPRuntime cepRT = cep.getEPRuntime();

        EPAdministrator cepAdm = cep.getEPAdministrator();
        EPStatement cepStatement = cepAdm.createEPL(
                "select * from " +
                "StockTick(symbol='AAPL').win:length(2) " +
                "having avg(price) > 6.0");

        EPStatement cepStatement2 = cepAdm.createEPL("select * from " +
                "StockTick(symbol='AAPL').win:length(2) " +
                "having avg(price) < 6.0");

        cepStatement.addListener(new MyListener("MORE than 6"));
        cepStatement2.addListener(new MyListener("LESS than 6"));
        // We generate a few ticks...
        for (int i = 0; i < 10; i++) {
            GenerateRandomTick(cepRT);
        }

    }

    public static void GenerateRandomTick(EPRuntime cepRT){

        Random generator = new Random();

        double price = (double) generator.nextInt(10);
        long timeStamp = System.currentTimeMillis();
        String symbol = "AAPL";
        Tick tick = new Tick(symbol, price, timeStamp);

        System.out.println("Sending tick:" + tick);
        cepRT.sendEvent(tick);

    }


}
