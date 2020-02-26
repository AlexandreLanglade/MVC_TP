package controller;

import model.BDClient;
import model.BDPersonnel;
import model.ProfilUtilisateur;

/**
 * ControlSIdentifier
 */
public class ControlSIdentifier {

    private BDPersonnel bdPersonnel = BDPersonnel.getInstance();
    private BDClient bdClient = BDClient.getInstance();

    public int sIdentifier(ProfilUtilisateur profilUtilisateur, String login, String mdp) {
        if (profilUtilisateur == ProfilUtilisateur.CLIENT) {
            return bdClient.connexionClient(login, mdp);
        } else {
            return bdPersonnel.connexionPersonnel(login, mdp);
        }
    }

    public String visualiserBDUtilisateur() {
        return bdPersonnel.toString() + "\n" + bdClient.toString();
    }
}