package model;
import java.util.List;
import java.util.Map;

public interface PetStore {
    boolean addPet(int id, String name, String race, int age);
    boolean removePet(int id);
    boolean searchByPetAge(int age);
    boolean doBath(int id, boolean perfume, boolean water);
    boolean doHairCut(int id, boolean shortOrLong);
    Map<Integer,List<Pet>> listPetServices();
}
