package model;

import java.util.HashMap;
import java.util.Map;

/**
 * BDPersonnel
 */
public class BDPersonnel {

    private Map<Integer, Personnel> listePersonnel = new HashMap<>();

    private BDPersonnel() {
    }

    private static class BDPersonnelHolder {
        private final static BDPersonnel instance = new BDPersonnel();
    }

    public static BDPersonnel getInstance() {
        return BDPersonnelHolder.instance;
    }

    public void ajouterPersonnel(Personnel personnel) {
        listePersonnel.put(personnel.getNumPersonnel(), personnel);
    }

    public int connexionPersonnel(String login, String mdp) {
        boolean profilExistant;
        for (Personnel personnel : listePersonnel.values()) {
            profilExistant = personnel.verifierCorrespondanceProfil(login, mdp);
            if (profilExistant) {
                personnel.connexionProfil();
                return personnel.getNumPersonnel();
            }
        }
        return -1;
    }

    public Personnel trouverPersonnel(int numeroPersonnel) {
        return listePersonnel.get(numeroPersonnel);
    }

    public String toString() {
        return "BDPersonnel [listePersonnel=" + listePersonnel + "]";
    }
}