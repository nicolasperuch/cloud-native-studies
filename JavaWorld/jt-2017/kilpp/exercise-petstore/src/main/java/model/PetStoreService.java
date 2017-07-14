package model;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.*;


public class PetStoreService implements PetStore {
    private PetMap petMap;
    private ServiceMap serviceMap;

    @Inject
    public PetStoreService(PetMap petMap, ServiceMap serviceMap) {
        this.petMap = petMap;
        this.serviceMap = serviceMap;
    }

    public PetMap getPetMap() {
        return petMap;
    }

    public void setPetMap(PetMap petMap) {
        this.petMap = petMap;
    }

    public ServiceMap getServiceMap() {
        return serviceMap;
    }

    public void setServiceMap(ServiceMap serviceMap) {
        this.serviceMap = serviceMap;
    }

    public boolean addPet(int id, String name, String race, int age) {
        boolean addPet;
        if (!petMap.getPetMap().containsKey(id)){
            petMap.getPetMap().put(id, new Pet(id, name, race, age));
            serviceMap.getServiceList().put(id, new ArrayList<>());
            addPet = true;
            System.out.println("PET ADICIONADO COM SUCESSO");
        }else {
            addPet = false;
            System.out.println("PET NÃO PODE SER ADICIONADO");
        }
        return addPet;
    }

    public boolean removePet(int id) {
        boolean removePet;
        if (petMap.getPetMap().containsKey(id)) {
            petMap.getPetMap().remove(id);
            removePet = true;
            System.out.println("PET REMOVIDO COM SUCESSO");
        } else {
            removePet = false;
            System.out.println("PET NAO ENCONTRADO");
        }
        return removePet;
    }

    public boolean searchByPetAge(int age) {
        boolean searchpet = false;
        List<Pet> listPetByAge = new ArrayList<>();
        for (Integer key : petMap.getPetMap().keySet()) {
            if (petMap.getPetMap().get(key).getAge() == age) {
                Pet pet = petMap.getPetMap().get(key);
                if(listPetByAge.add(pet) == true){
                    System.out.println(listPetByAge);
                searchpet = true;
                }else{
                    searchpet = false;
                    System.out.println("NENHUM PET COM A IDADE INDICADA FOI ENCONTRADO");
                }
            }
        }
        return searchpet;
    }

    @Override
    public boolean doBath(int id, boolean perfume, boolean water) {
        boolean doBath;
        if (petMap.getPetMap().containsKey(id)) {
            serviceMap.getServiceList().get(id).add(new Bath(id, perfume, water));
            doBath = true;
            System.out.println("SERVIÇO DE BANHO ADICIONADO COM SUCESSO");
        } else {
            doBath = false;
            System.out.println("SERVIÇO DE BANHO NÃO PODE SER CADASTRADO - CADASTRE UM PET");
        }
        return doBath;
    }


    @Override
    public boolean doHairCut(int id, boolean shortOrLong) {
        boolean doHairCut;
        if (petMap.getPetMap().containsKey(id)) {
            serviceMap.getServiceList().get(id).add(new HairCut(id, shortOrLong));
            doHairCut = true;
            System.out.println("SERVIÇO DE CORTE ADICIONADO COM SUCESSO");
        } else {
            doHairCut = false;
            System.out.println("SERVIÇO DE BANHO NÃO PODE SER CADASTRADO - CADASTRE UM PET");
        }
        return doHairCut;
    }


    public Map<Integer, List<Pet>> listPetServices() {
        Map<Integer, List<Pet>> listTopRevenue = new TreeMap<>(Collections.reverseOrder());
        for (Integer key : serviceMap.getServiceList().keySet()) {
            if (listTopRevenue.containsKey(serviceMap.getServiceList().get(key).size())) {
                listTopRevenue.get(serviceMap.getServiceList().get(key).size()).add(petMap.getPetMap().get(key));
            } else {
                listTopRevenue.put(serviceMap.getServiceList().get(key).size(), new ArrayList<>());
                listTopRevenue.get(serviceMap.getServiceList().get(key).size()).add(petMap.getPetMap().get(key));
            }
        }return listTopRevenue;
    }

    public void topRevenuePets() {
        int i = 0;
        System.out.println("LIST OF THE TEN PET TOP REVENUE");
        for (Map.Entry entry : listPetServices().entrySet()) {
            if (i++ < 10) System.out.println("Quantidade de Serviços: " + entry);
        }
    }
}









