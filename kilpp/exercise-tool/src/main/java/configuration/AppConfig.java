package configuration;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import rest.*;

import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

@Configuration
public class AppConfig {

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf(){
        return new SpringBus();
    }

    @Bean
    @DependsOn("cxf")
    public Server jaxRsServer() {
        final JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint((toolRestService()), JAXRSServerFactoryBean.class);
        factory.setServiceBeans(Arrays.asList(toolRestService()));
        return factory.create();
    }

    @Bean
    public TollResource toolRestService(){
        return new TollResource(bike(), bus(),car(),motorcycle(),truck());
    }

    @Bean
    public Bike bike(){
        return new Bike();
    }

    @Bean
    public Bus bus(){
        return new Bus();
    }

    @Bean
    public Car car(){
        return new Car();
    }

    @Bean
    public Motorcycle motorcycle(){
        return new Motorcycle();
    }

    @Bean
    public Truck truck(){
        return new Truck();
    }
}
