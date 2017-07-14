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
        listener = new MyListener();
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
                "from Component " +
                "where number < 7");
        createEPLWithListener("insert into "+parent+component+"Status " +
                "select name, \"warn\" as status, number "+
                "from Component " +
                "where number >= 7 " +
                "and number < 9");
        createEPLWithListener("insert into "+parent+component+"Status " +
                "select name, \"error\" as status, number "+
                "from Component " +
                "where number >=9");

    }
    public void createWindow(String parent, String component1, String component2) {

        createEPLWithListener("create window "+parent+"Status.win:length(1) as " +
                "(name string, status string)");
        createEPLWithListener("insert into "+parent+"Status " +
                "select '"+parent+"' as name, 'error' as status " +
                "from "+parent+component1+"Status as memory, "+parent+component2+"Status as cpu " +
                "where (memory.number >= 9 or cpu.number >= 9)");
    }

}
