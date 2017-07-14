package com.github.nicolasperuch;

import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

public class MyListener implements UpdateListener{


    public void update(EventBean[] newData, EventBean[] oldData) {
        System.out.println("- - Event received: " + newData[0].getUnderlying());
    }
}
