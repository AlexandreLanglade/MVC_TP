package model;

/**
 * ProfilPersonnel
 */
public class Personnel extends Profil {

    private boolean gerant = false;
    private static int nbPersonnel = 0;
    private int numPersonnel;

    public Personnel(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
        numPersonnel = nbPersonnel;
        nbPersonnel++;
    }

    public void definirGerant() {
        gerant = true;
    }

    public int getNumPersonnel() {
        return numPersonnel;
    }

    public boolean isGerant() {
        return gerant;
    }

    public String toString() {
        return "Personnel [gerant=" + gerant + ", nom=" + getNom() + ", prenom=" + getPrenom() + ", login=" + getLogin()
                + ", mdp=" + getMdp() + ", connecte=" + isConnecte() + "]";
    }
}