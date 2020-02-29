package controller;

import model.BDClient;
import model.Client;

/**
 * ControlEnregistrerCoordonneesBancaires
 */
public class ControlEnregistrerCoordonneesBancaires {

    private BDClient bdClient = BDClient.getInstance();
    private ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires;

    public ControlEnregistrerCoordonneesBancaires(
            ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires) {
        this.controlVerifierCoordonneesBancaires = controlVerifierCoordonneesBancaires;
    }

    public boolean enregistrerCoordonneesBancaires(int numeroClient, int numeroCarte, int dateCarte) {
        boolean carteValide = controlVerifierCoordonneesBancaires.verifierCoordonneesBancaires(numeroCarte, dateCarte);
        if (carteValide) {
            Client client = bdClient.trouverClient(numeroClient);
            client.enregistrerCoordonneesBancaires(numeroCarte, dateCarte);
        }
        return carteValide;
    }

}