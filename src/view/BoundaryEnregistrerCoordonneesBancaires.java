package view;

import controller.ControlEnregistrerCoordonneesBancaires;

/**
 * BoundaryEnregistrerCoordonneesBancaires
 */
public class BoundaryEnregistrerCoordonneesBancaires {

    private ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;

    public BoundaryEnregistrerCoordonneesBancaires(
            ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires) {
        this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
    }

    public boolean enregistrerCoordonneesBancaires(int numClient) {
        System.out.println("Veuillez saisir votre numero de carte bancaire");
        int numeroCarte = Clavier.entrerClavierInt();
        System.out.println("Veuillez saisir la date d'expiration de votre carte bancaire (MMAA)");
        int dateCarte = Clavier.entrerClavierInt();
        boolean carteValide = controlEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient,
                numeroCarte, dateCarte);
        if (!carteValide) {
            System.out.println("Votre carte n'est pas valide, votre commande ne peut aboutir");
        }
        return carteValide;
    }

}