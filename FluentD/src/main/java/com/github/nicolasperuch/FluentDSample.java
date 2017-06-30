package com.github.nicolasperuch;

import org.fluentd.logger.FluentLogger;

import java.util.HashMap;
import java.util.Map;

public class FluentDSample {

    private static FluentLogger LOG = FluentLogger.getLogger("fluentd.test");

    public static void main(String[] args) {

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("from", "userA");
        data.put("to", "userB");
        LOG.log("follow", data);


    }

}
