package com.github.nicolasperuch;

import com.espertech.esper.client.*;
import com.github.nicolasperuch.pojo.Component;

public class Esper {

    private Configuration cepConfig;
    private EPServiceProvider cep;
    private EPRuntime cepRT;
    private EPAdministrator cepAdm;

    private MyListener listener;

    public Esper() {
        cepConfig = new Configuration();
        cepConfig.addEventType("Component", Component.class.getName());
        cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
        cepRT = cep.getEPRuntime();
        cepAdm = cep.getEPAdministrator();
        listener = new MyListener("Default");
    }

    public EPRuntime getCepRT() {
        return cepRT;
    }

    public void createEPLWithListener(String query){
        cepAdm.createEPL(query).addListener(listener);
    }

    public void createWindow(String parent, String component){
        createEPLWithListener("create window "+parent+component+"Status.win:length(1) as " +
                "(name string, status string, number int)");
        createEPLWithListener("insert into "+parent+component+"Status " +
                "select name, \"good\" as status, number "+
                "from Component");
        createEPLWithListener("insert into "+parent+component+"Status " +
                "select name, \"warn\" as status, number "+
                "from Component");
        createEPLWithListener("insert into "+parent+component+"Status " +
                "select name, \"error\" as status, number "+
                "from Component");

    }

}
