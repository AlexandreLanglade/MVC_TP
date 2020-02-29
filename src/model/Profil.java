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

    public boolean verifierCorrespondanceProfil(String login, String mdp) {
        return this.login.equals(login) && this.mdp.equals(mdp);
    }

    public void connexionProfil() {
        connecte = true;
    }

    public boolean isConnecte() {
        return connecte;
    }

    public String toString() {
        return "Profil [connecte=" + connecte + ", login=" + login + ", mdp=" + mdp + ", nom=" + nom + ", prenom="
                + prenom + "]";
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }
}