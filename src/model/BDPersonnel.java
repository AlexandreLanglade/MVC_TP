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

    public String toString() {
        return "BDPersonnel [listePersonnel=" + listePersonnel + "]";
    }
}