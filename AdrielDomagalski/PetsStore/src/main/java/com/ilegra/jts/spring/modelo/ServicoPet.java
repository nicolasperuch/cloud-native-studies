package com.ilegra.jts.spring.modelo;

import javax.inject.Inject;
import java.util.*;

/**
 * Created by Adriel on 29/05/2017.
 */
public class ServicoPet implements InterfacePet {

    private ListaPet listaPet;
    private ListaServico listaServico;

    @Inject
    public ServicoPet(ListaPet listaPet, ListaServico listaServico) {
        this.listaPet = listaPet;
        this.listaServico = listaServico;
    }


    public boolean addPet(int id, String nome, String raca, int idade) {
        try {
            listaPet.getListaPet().put(id, new Pet(id, nome, raca, idade));
            System.out.println("Pet Adicionado com sucesso");
            return true;
        } catch (Exception e) {
            System.out.println("erro: " + e);
            return false;
        }


    }

    public boolean removePet(int id) {
        for (Integer key : listaPet.getListaPet().keySet()) {
            if (listaPet.getListaPet().containsKey(id)) {
                listaPet.getListaPet().remove(id);
                System.out.println("\nPet removido com sucesso " + id);
                return true;
            } else {
                System.out.println("Pet não encontrado para remoção");
                return false;
            }
        }
        return false;
    }

    public boolean pesquisaPorIdade(int idade) {
        for (Integer key : listaPet.getListaPet().keySet()) {
            if (listaPet.getListaPet().get(key).getIdade() == idade) {
                System.out.println("\nPet Encontrado com sucesso\n" + "Idade:" + listaPet.getListaPet().get(key).getIdade() + "\nNome: " + listaPet.getListaPet().get(key).getNome() );
                return true;
            } else {
                System.out.println("Pet não encontrado");
            }
        }
        return false;
    }


    public boolean addBanho(int id, boolean seco, boolean perfume, boolean agua) {
        try {
            if(listaServico.getPetServico().containsKey(id)){
                listaServico.getPetServico().get(id).add(new Banho(id, seco, perfume, agua));
                System.out.println("\n Novo Banho adicionando com sucesso ao pet " + listaPet.getListaPet().get(id).getNome());
                return true;
            }
            else if (listaPet.getListaPet().containsKey(id)) {
                    listaServico.getPetServico().put(id, new ArrayList<Object>());
                    listaServico.getPetServico().get(id).add(new Banho(id, seco, perfume, agua));
                    System.out.println("\n Primeiro Banho adicionando com sucesso ao pet " + listaPet.getListaPet().get(id).getNome());
                    return true;
                } else {
                    System.out.println("\n Erro ao adicionar banho  adicione o Pet");
                    return false;
                }

        } catch (Exception e) {
            System.out.println("erro: " + e);
        }
        return false;
    }

    public boolean addCorte(int id, boolean peloCurto, boolean peloLongo) {
        try {
            if(listaServico.getPetServico().containsKey(id)) {
                listaServico.getPetServico().get(id).add(new CortePelo(id, peloCurto, peloLongo));
                System.out.println("\n Novo corte adicionado adicionado");
                return true;
            }
            else if(listaPet.getListaPet().containsKey(id)) {
                listaServico.getPetServico().put(id, new ArrayList<Object>());
                listaServico.getPetServico().get(id).add(new CortePelo(id, peloCurto, peloLongo));
                System.out.println("\n Primeiro corte adicionado " + listaPet.getListaPet().get(id).getNome());
                return true;
            }else {
                System.out.println("\n Adicione primeiro um Pet");
                return false;
            }

        } catch (Exception e) {
            System.out.println("erro: " + e);
        }
        return true;
    }


    public Map<Integer, List<Pet>> listaPetServicos() {
        Map<Integer, List<Pet>> listaTopDez = new TreeMap<>(Collections.reverseOrder());
        for (Integer key : listaServico.getPetServico().keySet()) {
            if (listaTopDez.containsKey(listaServico.getPetServico().get(key).size())) {
                listaTopDez.get(listaServico.getPetServico().get(key).size()).add(listaPet.getListaPet().get(key));
            } else {
                listaTopDez.put(listaServico.getPetServico().get(key).size(), new ArrayList<>());
                listaTopDez.get(listaServico.getPetServico().get(key).size()).add(listaPet.getListaPet().get(key));
            }
        }
        return listaTopDez;
    }

    public void topPets() {
        int aux = 0;
        System.out.println("Lista dos dez pets com mais seerviços");
        for (Map.Entry chave : listaPetServicos().entrySet()) {
            if (aux ++ <= 10) {
                System.out.println("Quantidade de Serviços: " + chave);
            }
        }
    }

}





