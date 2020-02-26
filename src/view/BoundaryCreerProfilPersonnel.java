package view;

import controller.ControlCreerProfil;
import model.ProfilUtilisateur;

/**
 * BoundaryCreerProfilPersonnel
 */
public class BoundaryCreerProfilPersonnel {

    private ControlCreerProfil controlCreerProfil;

    public BoundaryCreerProfilPersonnel(ControlCreerProfil controlCreerProfil) {
        this.controlCreerProfil = controlCreerProfil;
    }

    public void creerProfilPersonnel() {
        System.out.println("Veuillez entrer le nom du nouvel employé : ");
        String nom = Clavier.entrerClavierString();
        System.out.println("Veuillez entrer le prénom du nouvel employé : ");
        String prenom = Clavier.entrerClavierString();
        System.out.println("Le mot de passe est mdp a modifier a la première connexion.");
        controlCreerProfil.creerProfil(ProfilUtilisateur.PERSONNEL, nom, prenom, "mdp");
    }
}