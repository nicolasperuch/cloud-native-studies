package com.ilegra.jts.matheusbritzke.MapOfServices;

import com.ilegra.jts.matheusbritzke.AvailableServices.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class MapServices {

    @Inject
    Map<Integer, AvailableServices> services;

    public Map<Integer, AvailableServices> getServices() {
        return services;
    }

    public AvailableServices getSpecificService(int idService){
        AvailableServices service = null;
        for (Integer key : services.keySet()) {
            if(key == idService){
                service = services.get(idService);
            }
        }
        return service;
    }
}
