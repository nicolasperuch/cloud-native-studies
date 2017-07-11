package com.github.nicolasperuch;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class MyListener implements UpdateListener{

    private String name;

    public MyListener(String name) {
        this.name = name;
    }

    public void update(EventBean[] newData, EventBean[] oldData) {
        System.out.println("- - - "+name+" - Event received: " + newData[0].getUnderlying());
    }
}
