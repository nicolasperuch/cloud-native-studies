package com.github.nicolasperuch;

import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.github.nicolasperuch.pojo.Component;

import java.util.Random;
import java.util.Scanner;

public class MainRunner {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Esper esper = new Esper();

        esper.addQuery("select name, avg(number), \"good\" as status\n" +
                "from Component.win:length(2)\n" +
                "where name = \"Memory\"\n" +
                "having avg(number) < 7");
        esper.addListener(new MyListener("GOOD"));
        esper.addQuery("select name, avg(number), \"warn\" as status\n" +
                "from Component.win:length(2)\n" +
                "where name = \"Memory\"\n" +
                "having avg(number) >= 7 and avg(number) < 9");
        esper.addListener(new MyListener("WARN"));
        esper.addQuery("select name, avg(number), \"error\" as status\n" +
                "from Component.win:length(2)\n" +
                "where name = \"Memory\"\n" +
                "having avg(number) >= 9");
        esper.addListener(new MyListener("ERROR"));


            for (int i = 0; i < 10; i++)
                GenerateRandomComponent(esper.getCepRT());

        System.out.printf("\n\n\n\n - DONE! ");
    }

    public static void GenerateRandomComponent(EPRuntime cepRT) {

        Random generator = new Random();

        int number = generator.nextInt(10);
        String name = "Memory";

        Component component = new Component(name, number);

        System.out.println(" - Sending component:" + component);
        cepRT.sendEvent(component);

    }
}
