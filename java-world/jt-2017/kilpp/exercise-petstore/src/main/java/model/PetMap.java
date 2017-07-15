package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class PetMap {

    private Map<Integer, Pet> petMap = new LinkedHashMap<>();

    public Map<Integer, Pet> getPetMap() {
        return petMap;
    }

    public void setPetMap(Map<Integer, Pet> petMap) {
        this.petMap = petMap;
    }
}
