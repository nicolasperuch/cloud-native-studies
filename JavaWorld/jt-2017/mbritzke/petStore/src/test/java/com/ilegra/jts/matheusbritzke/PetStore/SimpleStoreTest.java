package com.ilegra.jts.matheusbritzke.PetStore;

import com.ilegra.jts.matheusbritzke.MapOfServices.MapServices;
import com.ilegra.jts.matheusbritzke.Pojo.Pet;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class SimpleStoreTest {

    private SimpleStore store = new SimpleStore(new ArrayList<>(), new MapServices(), new ArrayList<>());

    @Test
    public void add(){
        Assert.assertTrue(store.addPets(new Pet(1, "cachorro", "cachorro", 10, new ArrayList<>())));
        Assert.assertFalse(store.addPets(new Pet(1, "cachorro", "cachorro", 10, new ArrayList<>())));
    }

    @Test
    public void remove(){
        store.addPets(new Pet(45, "gato", "gato", 5, new ArrayList<>()));
        Assert.assertTrue(store.removePet(45));
        Assert.assertFalse(store.removePet(78));
        Assert.assertFalse(store.removePet(45));
    }

    @Test
    public void search(){
        store.addPets(new Pet(1, "cusco", "cachorro", 10, new ArrayList<>()));
        String stringPet = "Pet{" +
                "id=" + 1 +
                ", name='" + "cusco" + '\'' +
                ", race='" + "cachorro" + '\'' +
                ", age=" + 10 +
                ", totalServices=" + 0.0+
                '}';
        Assert.assertEquals(stringPet, store.search(10));
        Assert.assertEquals("no pets found", store.search(5));
    }
}
