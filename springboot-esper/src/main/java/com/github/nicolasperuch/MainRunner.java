package com.github.nicolasperuch;

import com.espertech.esper.client.EPRuntime;
import com.github.nicolasperuch.pojo.Component;

import java.util.Random;

public class MainRunner {


    public static void main(String[] args) {

        Esper esper = new Esper();

        String parent = "PC01";
        String component1 = "Memory";
        esper.createWindow(parent, component1);
        String component2 = "CPU";
        esper.createWindow(parent, component2);


        esper.createEPLWithListener("create window "+parent+"Status.win:length(1) as " +
                "(name string, status string, number int)");
        esper.createEPLWithListener("insert into "+parent+"Status " +
                "select memory.parent as name, 'error' as status, number " +
                "from "+parent+component1+"Status as memory, "+parent+component2+"Status as cpu " +
                "where memory.parent = cpu.parent " +
                "and memory.parent = 'PC01' and (memory.status = 'error' or cpu.status = 'error')");

        for (int i = 0; i < 10; i++)
            GenerateRandomComponent(esper.getCepRT());

        System.out.printf("\n\n\n\n - DONE! ");
    }

    public static void GenerateRandomComponent(EPRuntime cepRT) {

        Random generator = new Random();

        int number = generator.nextInt(10);
        String name = "Memory";
        String parent = "PC";

        Component component = new Component(name, parent,"error", number);

        System.out.println(" Sending component:" + component);
        cepRT.sendEvent(component);

    }
}
