package com.ilegra.jt.petshop.functions;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ilegra.jt.petshop.PetShopServices;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddTest {

    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(Add.class);
            }
        });

    }
    @Test
    public void addPetGuiceTest(){
        PetShopServices petShopServices = injector.getInstance(PetShopServices.class);
        Assert.assertTrue(petShopServices.addPet(1,1,"Viralata","Yolo"));
    }
    @After
    public void tearDown() throws Exception {
        injector = null;
    }

}
