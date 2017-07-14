package com.ilegra.jt.spring;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.ilegra.jt.toll.*;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

public class AppConfig {

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    @DependsOn("cxf")
    public Server jaxRsServer() {
        final JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(payToll(), JAXRSServerFactoryBean.class);
        factory.setServiceBean(Arrays.asList((payToll())));
        factory.setProviders(Arrays.asList(jsonProvider()));
        return factory.create();
    }

    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }

    @Bean
    public Toll payToll(){
        Toll toll = new Toll();
        toll.setCar(car());
        toll.setBus(bus());
        toll.setBicycle(bicycle());
        toll.setBike(bike());
        toll.setTruck(truck());
        return toll;
    }

    @Bean
    public Car car(){
        return new Car();
    }
    @Bean
    public Bus bus(){
        return new Bus();
    }
    @Bean
    public Bicycle bicycle(){
        return new Bicycle();
    }
    @Bean
    public Bike bike(){
        return new Bike();
    }
    @Bean
    public Truck truck(){
        return new Truck();
    }
}