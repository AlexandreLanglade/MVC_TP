package controller;

import model.BDClient;
import model.BDPersonnel;
import model.Client;
import model.Personnel;
import model.ProfilUtilisateur;

/**
 * ControlVerifierIdentification
 */
public class ControlVerifierIdentification {

    private BDClient bdClient = BDClient.getInstance();
    private BDPersonnel bdPersonnel = BDPersonnel.getInstance();

    public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numeroProfil) {
        if (profilUtilisateur == ProfilUtilisateur.CLIENT) {
            Client client = bdClient.trouverClient(numeroProfil);
            if (client != null) {
                return client.isConnecte();
            }
        } else if (profilUtilisateur == ProfilUtilisateur.PERSONNEL) {
            Personnel personnel = bdPersonnel.trouverPersonnel(numeroProfil);
            if (personnel != null) {
                return personnel.isConnecte();
            }
        } else {
            Personnel personnel = bdPersonnel.trouverPersonnel(numeroProfil);
            if (personnel != null) {
                boolean identificationOK = personnel.isGerant();
                if (identificationOK) {
                    return personnel.isConnecte();
                }
            }
        }
        return false;
    }
}