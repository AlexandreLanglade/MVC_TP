package view;

import controller.ControlSIdentifier;
import model.ProfilUtilisateur;

/**
 * BoundarySIdentifierPersonnel
 */
public class BoundarySIdentifierPersonnel {

    private ControlSIdentifier controlSIdentifier;

    public BoundarySIdentifierPersonnel(ControlSIdentifier controlSIdentifier) {
        this.controlSIdentifier = controlSIdentifier;
    }

    public int sIdentifierPersonnel() {
        System.out.println("Veuillez entrer votre login : ");
        String login = Clavier.entrerClavierString();
        System.out.println("Veuillez entrer votre mot de passe : ");
        String mdp = Clavier.entrerClavierString();
        int numPersonnel = controlSIdentifier.sIdentifier(ProfilUtilisateur.PERSONNEL, login, mdp);
        return numPersonnel;
    }
}