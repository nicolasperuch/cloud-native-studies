package com.github.adrielsoares.java.rest.ConfigucoesSpring;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.github.adrielsoares.java.rest.Operacoes.Operacao;
import com.github.adrielsoares.java.rest.Operacoes.Pedagio;
import com.github.adrielsoares.java.rest.Veiculos.*;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.ws.rs.ext.RuntimeDelegate;
import java.util.Arrays;

/**
 * Created by adriel on 06/06/17.
 */
@Configuration
public class ConfiguracaoApp {

    @Bean(destroyMethod = "shutdown")
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean
    @DependsOn("cxf")
    public Server jaxRsServer() {
        final JAXRSServerFactoryBean factory = RuntimeDelegate.getInstance().createEndpoint(operacao(), JAXRSServerFactoryBean.class);
        factory.setServiceBean(Arrays.asList((operacao())));
        factory.setProviders(Arrays.asList(jsonProvider()));
        return factory.create();
    }

    @Bean
    public JacksonJsonProvider jsonProvider() {
        return new JacksonJsonProvider();
    }

    @Bean
    public Operacao operacao(){
        return new Operacao(carro(), bike(), caminhao(), moto(), onibus());
    }

    @Bean
    public Carro carro(){
        return new Carro();
    }

    @Bean
    public Bicicleta bike(){
        return new Bicicleta();
    }

    @Bean
    public Caminhao caminhao(){
        return new Caminhao();
    }

    @Bean
    public Moto moto(){
        return new Moto();
    }

    @Bean
    public Onibus onibus(){
        return new Onibus();
    }
}
