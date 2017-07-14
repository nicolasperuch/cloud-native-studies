package com.github.nicolasperuch;

import com.espertech.esper.client.*;
import com.github.nicolasperuch.pojo.Tick;

import java.util.Random;

public class MainRunner {

    public static void main(String[] args) {

        Esper esper = new Esper();
        esper.addQuery("select * from StockTick(symbol='AAPL').win:length(2) having avg(price) > 6.0");
        esper.addListener(new MyListener("MORE than 6"));
        esper.addQuery("select * from StockTick(symbol='AAPL').win:length(2) having avg(price) < 6.0");
        esper.addListener(new MyListener("LESS than 6"));
        for (int i = 0; i < 10; i++) {
            GenerateRandomTick(esper.getCepRT());
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
