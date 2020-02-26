package view;

import controller.ControlSIdentifier;
import model.ProfilUtilisateur;

/**
 * BoundarySIdentifierClient
 */
public class BoundarySIdentifierClient {

    private ControlSIdentifier controlSIdentifier;

    public BoundarySIdentifierClient(ControlSIdentifier controlSIdentifier) {
        this.controlSIdentifier = controlSIdentifier;
    }

    public int sIdentifierClient() {
        System.out.println("Veuillez entrer votre login : ");
        String login = Clavier.entrerClavierString();
        System.out.println("Veuillez entrer votre mot de passe : ");
        String mdp = Clavier.entrerClavierString();
        int numClient = controlSIdentifier.sIdentifier(ProfilUtilisateur.CLIENT, login, mdp);
        return numClient;
    }
}