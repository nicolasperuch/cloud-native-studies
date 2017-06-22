package com.ilegra.jts.spring.modulo;

import com.google.inject.AbstractModule;
import com.ilegra.jts.spring.modelo.ServicoPet;
import com.ilegra.jts.spring.modelo.InterfacePet;

/**
 * Created by Adriel on 31/05/2017.
 */
public class PetServiceModulo extends AbstractModule{

    @Override
    protected void configure() {
        bind(InterfacePet.class).to(ServicoPet.class);
    }
}
