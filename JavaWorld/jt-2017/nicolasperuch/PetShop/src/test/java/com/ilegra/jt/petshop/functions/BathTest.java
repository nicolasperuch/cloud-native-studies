package com.ilegra.jt.petshop.functions;


import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ilegra.jt.petshop.PetShopServices;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BathTest {

    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(Bath.class);
            }
        });

    }

    @Test
    public void bathGuiceTest(){
        PetShopServices petShopServices = injector.getInstance(PetShopServices.class);
        Assert.assertFalse(petShopServices.doBath(1,true,true,true));
    }

    @Test
    public void bathGuiceTest2(){
        PetShopServices petShopServices = injector.getInstance(PetShopServices.class);
        petShopServices.addPet(1,5,"Pinscher","Fifo");
        Assert.assertTrue(petShopServices.doBath(1,true,true,false));
    }

    @After
    public void tearDown() throws Exception {
        injector = null;
    }
}
