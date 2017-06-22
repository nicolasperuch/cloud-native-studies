package com.ilegra.jt.injector;

import com.google.inject.AbstractModule;
import com.ilegra.jt.petshop.PetShopServices;
import com.ilegra.jt.petshop.PetShop;

public class AppInjector extends AbstractModule{

    @Override
    protected void configure() {
        bind(PetShop.class).to(PetShopServices.class);
    }
}
