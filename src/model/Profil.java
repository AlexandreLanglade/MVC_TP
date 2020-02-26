package model;

/**
 * Profil
 */
public abstract class Profil {

    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private boolean connecte = false;

    public Profil(String nom, String prenom, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        login = this.prenom + '.' + this.nom;
        this.mdp = mdp;
    }

    public String toString() {
        return "Profil [login=" + login + ", mdp=" + mdp + ", nom=" + nom + ", prenom=" + prenom + "]";
    }

    public boolean verifierCorrespondanceProfil(String login, String mdp) {
        return this.login.equals(login) && this.mdp.equals(mdp);
    }

    public void connexionProfil() {
        connecte = true;
    }

    public boolean isConnecte() {
        return connecte;
    }
}