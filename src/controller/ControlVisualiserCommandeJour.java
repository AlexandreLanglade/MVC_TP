package controller;

import java.beans.PropertyChangeListener;

import model.BDCommande;
import model.ProfilUtilisateur;

/**
 * ControlVisualiserCommandeJour
 */
public class ControlVisualiserCommandeJour {

    BDCommande bdCommande = BDCommande.getInstance();
    private ControlVerifierIdentification controlVerifierIdentification;

    public ControlVisualiserCommandeJour(ControlVerifierIdentification controlVerifierIdentification) {
        this.controlVerifierIdentification = controlVerifierIdentification;
    }

    public void setListener(String propertyName, PropertyChangeListener listener) {
        bdCommande.addPropertyChangeListener(propertyName, listener);
    }

    public boolean verifierIdentification(int numeroProfil, ProfilUtilisateur profilUtilisateur) {
        return controlVerifierIdentification.verifierIdentification(profilUtilisateur, numeroProfil);
    }
}