package model;

/**
 * ProfilClient
 */
public class Client extends Profil {

    private static int nbClient = 0;
    private int numClient;
    private CarteBancaire carteBancaire;

    public Client(String nom, String prenom, String mdp) {
        super(nom, prenom, mdp);
        numClient = nbClient;
        nbClient++;
    }

    public int getNumClient() {
        return numClient;
    }

    public void enregistrerCoordonneesBancaires(int numeroCarte, int dateCarte) {
        carteBancaire = new CarteBancaire(numeroCarte, dateCarte);
    }

    public String toString() {
        return "Client [nom=" + getNom() + ", prenom=" + getPrenom() + ", login=" + getLogin() + ", mdp=" + getMdp()
                + ", connecte=" + isConnecte() + ", carteBancaire=" + carteBancaire + "]";
    }
}