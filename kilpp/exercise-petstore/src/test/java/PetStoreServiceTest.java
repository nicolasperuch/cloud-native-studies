
import model.PetMap;
import model.PetStoreService;
import model.ServiceMap;
import org.junit.Assert;
import org.junit.Test;
import java.util.TreeMap;


public class PetStoreServiceTest {
    PetStoreService petStoreService = new PetStoreService(new PetMap(), new ServiceMap());

    @Test
    public void addPetTest(){
        Assert.assertTrue(petStoreService.addPet(1,"Mujica", "ViraLata", 1));
        Assert.assertFalse(petStoreService.addPet(1,"Lucke", "ViraLata", 5));
    }

    @Test
    public void removePetTest(){
        Assert.assertFalse(petStoreService.removePet(1));
        petStoreService.addPet(1,"Mujica","ViraLata",3);
        Assert.assertTrue(petStoreService.removePet(1));
    }

    @Test
    public void searchPetByAgeTest(){
        Assert.assertFalse(petStoreService.searchByPetAge(3));
        petStoreService.addPet(1,"Mujica","ViraLata",3);
        Assert.assertTrue(petStoreService.searchByPetAge(3));
    }

    @Test
    public void doBathTest(){
        Assert.assertFalse(petStoreService.doBath(1,true,true));
        petStoreService.addPet(1,"Mujica","ViraLata",3);
        Assert.assertTrue(petStoreService.doBath(1, true,true));
    }

    @Test
    public void doHairCutTest(){
        Assert.assertFalse(petStoreService.doHairCut(1,true));
        petStoreService.addPet(1,"Mujica","ViraLata",3);
        Assert.assertTrue(petStoreService.doHairCut(1, true));
    }

    @Test
    public void listPetServicesTest(){
        Assert.assertEquals(new TreeMap<>(), petStoreService.listPetServices());
        petStoreService.addPet(1,"Mujica","ViraLata",3);
        petStoreService.doBath(1,true,true);
        Assert.assertNotNull(petStoreService.listPetServices());
    }

}
