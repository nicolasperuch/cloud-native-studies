package com.github.nicolasperuch;

import com.espertech.esper.client.*;
import com.github.nicolasperuch.pojo.Component;

public class Esper {

    private Configuration cepConfig;
    private EPServiceProvider cep;
    private EPRuntime cepRT;
    private EPAdministrator cepAdm;
    private EPStatement cepStatement;

    public Esper() {
        cepConfig = new Configuration();
        cepConfig.addEventType("Component", Component.class.getName());
        cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
        cepRT = cep.getEPRuntime();
        cepAdm = cep.getEPAdministrator();
    }

    public EPRuntime getCepRT() {
        return cepRT;
    }

    public void addQuery(String query){
        cepStatement = cepAdm.createEPL(query);
    }

    public void addListener(MyListener listener){
        cepStatement.addListener(listener);
    }

}
