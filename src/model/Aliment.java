package model;

/**
 * Aliment
 */
public abstract class Aliment {

    private String nom;

    public Aliment(String nom) {
        this.nom = nom;
    }

    public String toString() {
        return "Aliment [nom=" + nom + "]";
    }

    public String getNom() {
        return nom;
    }

}