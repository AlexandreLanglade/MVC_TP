package model;

/**
 * ProfilClient
 */
public class Client extends Profil {
    
    private static int nbClient = 0;
    private int numClient;

    public Client(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
        numClient = nbClient;
        nbClient++;
    }

    public int getNumClient() {
        return numClient;
    }
}