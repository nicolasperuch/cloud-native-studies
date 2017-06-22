package com.ilegra.jts.matheusbritzke.ConfigurationApp;

import com.ilegra.jts.matheusbritzke.Toll.PayToll;
import com.ilegra.jts.matheusbritzke.Toll.Toll;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.ilegra.jts.matheusbritzke.Vehicles.*;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

@Configuration
@ComponentScan(basePackages = "com.ilegra.jts.matheusbritzke")
public class AppConfig {

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    @DependsOn("cxf")
    public Server jaxRsServer() {
        final JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(tollInUse(), JAXRSServerFactoryBean.class);
        factory.setServiceBean(Arrays.asList((tollInUse())));
        factory.setProviders(Arrays.asList(jsonProvider()));
        return factory.create();
    }

    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }

    @Bean
    public Toll tollInUse(){
        Toll toll = new Toll(payToll(), car(), bicycle(), bus(), moto(), truck());
        return toll;
    }

    @Bean
    public PayToll payToll(){
        return new PayToll();
    }

    @Bean
    public Car car(){
        return new Car();
    }

    @Bean
    public Bicycle bicycle(){
        return new Bicycle();
    }

    @Bean
    public Bus bus(){
        return new Bus();
    }

    @Bean
    public Moto moto(){
        return new Moto();
    }

    @Bean
    public Truck truck(){
        return new Truck();
    }
}
