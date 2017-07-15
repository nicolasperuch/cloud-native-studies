package com.github.nicolasperuch;

import com.espertech.esper.client.EPRuntime;
import com.github.nicolasperuch.pojo.Component;

public class MainRunner {


    public static void main(String[] args) {

        Esper esper = new Esper();

        String parent = "PC01";

        String component1 = "Memory";
        esper.createWindow(parent, component1);
        String component2 = "CPU";
        esper.createWindow(parent, component2);
        esper.createWindow(parent, component1, component2);

        EPRuntime epRuntime = esper.getCepRT();
        epRuntime.sendEvent(new Component("Memory", "PC01", "none", 9));
        epRuntime.sendEvent(new Component("CPU", "PC02", "none", 10));

        System.out.printf("\n\n - DONE! ");
    }

}
