package com.ilegra.jt.petshop.functions;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ilegra.jt.animal.Animal;
import com.ilegra.jt.petshop.PetShopServices;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SearchTest {

    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(Search.class);
            }
        });
    }
    @Test
    public void searchGuiceTest(){
        PetShopServices petShopServices = injector.getInstance(PetShopServices.class);
        Animal pet = new Animal();
        Assert.assertNotEquals(pet, petShopServices.searchPet(1));
    }
    @Test
    public void searchGuiceTest2(){
        PetShopServices petShopServices = injector.getInstance(PetShopServices.class);
        Animal pet = new Animal(1, 3, "Pug", "Hooli");
        Assert.assertNotEquals(pet, petShopServices.searchPet(1));
    }

    @After
    public void tearDown() throws Exception {
        injector = null;
    }
}
