package view;

import controller.ControlCreerProfil;
import model.ProfilUtilisateur;

/**
 * BoundaryCreerProfilGerant
 */
public class BoundaryCreerProfilGerant {

    private ControlCreerProfil controlCreerProfil;

    public BoundaryCreerProfilGerant(ControlCreerProfil controlCreerProfil) {
        this.controlCreerProfil = controlCreerProfil;
    }
    
    public void creerProfilGerant() {
        System.out.println("Veuillez entrer votre nom : ");
        String nom = Clavier.entrerClavierString();
        System.out.println("Veuillez entrer votre prénom : ");
        String prenom = Clavier.entrerClavierString();
        System.out.println("Veuillez entrer votre mot de passe : ");
        String mdp = Clavier.entrerClavierString();
        controlCreerProfil.creerProfil(ProfilUtilisateur.GERANT, nom, prenom, mdp);
    }

}