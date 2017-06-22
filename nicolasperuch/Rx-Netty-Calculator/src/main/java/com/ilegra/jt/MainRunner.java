package com.ilegra.jt;

import com.ilegra.jt.config.CalculatorConfig;
import com.ilegra.jt.rxnetty.CalculatorResource;
import com.ilegra.jt.rxnetty.HealthcheckResource;
import com.ilegra.jt.rxnetty.RxNettyHandler;
import netflix.adminresources.resources.KaryonWebAdminModule;
import netflix.karyon.Karyon;
import netflix.karyon.KaryonBootstrapModule;
import netflix.karyon.ShutdownModule;
import netflix.karyon.archaius.ArchaiusBootstrapModule;
import netflix.karyon.health.HealthCheckHandler;
import netflix.karyon.servo.KaryonServoModule;
import netflix.karyon.transport.http.health.HealthCheckEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainRunner {
    public static void main(String[] args) {
        System.setProperty("java.awt.headless","true");
        System.setProperty("archaius.deployment.environment","dev");


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CalculatorConfig.class);
        CalculatorResource calculatorResource = (CalculatorResource) applicationContext.getBean("calculatorResource");

        HealthCheckHandler healthCheckHandler = new HealthcheckResource();
        Karyon.forRequestHandler(8888,
                new RxNettyHandler("/healthcheck",
                        new HealthCheckEndpoint(healthCheckHandler), calculatorResource),
                new KaryonBootstrapModule(healthCheckHandler),
                new ArchaiusBootstrapModule("simplemath-netflix-oss"),
                Karyon.toBootstrapModule(KaryonWebAdminModule.class),
                ShutdownModule.asBootstrapModule(),
                KaryonServoModule.asBootstrapModule()
        ).startAndWaitTillShutdown();

    }
}