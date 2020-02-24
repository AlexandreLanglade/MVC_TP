package controller;

import model.BDClient;
import model.BDPersonnel;
import model.Client;
import model.FabriqueProfil;
import model.Personnel;
import model.Profil;
import model.ProfilUtilisateur;

/**
 * ControlCreerProfil
 */
public class ControlCreerProfil {

    private BDClient bdClient = BDClient.getInstance();
    private BDPersonnel bdPersonnel = BDPersonnel.getInstance();

    public void creerProfil(ProfilUtilisateur profilUtilisateur, String nom, String prenom, String mdp) {
        Profil profil = FabriqueProfil.creerProfil(profilUtilisateur, nom, prenom, mdp);
        if (profilUtilisateur == ProfilUtilisateur.CLIENT) {
            bdClient.ajouterClient((Client) profil);
        } else {
            bdPersonnel.ajouterPersonnel((Personnel) profil);
        }
    }

	public String visualiserBDUtilisateur() {
		return bdPersonnel.toString() + "\n" + bdClient.toString();
	}
}