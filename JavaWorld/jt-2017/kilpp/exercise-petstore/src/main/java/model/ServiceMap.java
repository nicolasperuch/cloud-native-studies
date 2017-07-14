package model;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ServiceMap {

    private Map<Integer, List<Object>> serviceList = new LinkedHashMap<>();

    public Map<Integer, List<Object>> getServiceList() {
        return serviceList;
    }

    public void setServiceList(Map<Integer, List<Object>> serviceList) {
        this.serviceList = serviceList;
    }
}




