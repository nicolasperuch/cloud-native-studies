package com.ilegra.jt.petshop.functions;


import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ilegra.jt.petshop.PetShopServices;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RemoveTest {

    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                bind(Remove.class);
            }
        });

    }
    @Test
    public void removePetGuiceTest(){
        PetShopServices petShopServices = injector.getInstance(PetShopServices.class);
        Assert.assertFalse(petShopServices.removePet(1));
    }
    @Test
    public void removePetGuiceTest2(){
        PetShopServices petShopServices = injector.getInstance(PetShopServices.class);
        petShopServices.addPet(1, 10, "whiskas sache", "Kxorro");
        Assert.assertTrue(petShopServices.removePet(1));
    }
    @After
    public void tearDown() throws Exception {
        injector = null;
    }

}
