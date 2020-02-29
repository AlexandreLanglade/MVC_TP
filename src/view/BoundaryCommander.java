package view;

import java.util.List;

import controller.ControlCommander;

/**
 * BoundaryCommander
 */
public class BoundaryCommander {

    private BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires;
    private ControlCommander controlCommander;

    public BoundaryCommander(ControlCommander controlCommander,
            BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires) {
        this.boundaryEnregistrerCoordonneesBancaires = boundaryEnregistrerCoordonneesBancaires;
        this.controlCommander = controlCommander;
    }

    public void commander(int numClient) {
        boolean clientConnecte = controlCommander.verifierIdentification(numClient);
        if (clientConnecte) {
            int numeroHamburger = selectionnerBurger() - 1;
            int numeroAccompagnement = selectionnerAccompagnement() - 1;
            int numeroBoisson = selectionnerBoisson() - 1;
            boolean carteRenseignee = controlCommander.verifierExistanceCarteBancaire(numClient);
            if (!carteRenseignee) {
                carteRenseignee = boundaryEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient);
            }
            if (carteRenseignee) {
                int numeroCommande = controlCommander.enregistrerCommande(numClient, numeroHamburger,
                        numeroAccompagnement, numeroBoisson);
                System.out.println("Votre numero de commande est le : " + numeroCommande);
            }
        }
    }

    private int selectionnerBurger() {
        List<String> listeHamburger = controlCommander.donnerListeHamburger();
        int chiffre = 1;
        System.out.println("Veuillez selectionner le numéro de votre hamburger");
        for (String hamburger : listeHamburger) {
            System.out.println(chiffre + " : " + hamburger);
            chiffre++;
        }
        int numeroHamburger = Clavier.entrerClavierInt();
        return numeroHamburger;
    }

    private int selectionnerAccompagnement() {
        List<String> listeAccompagnement = controlCommander.donnerListeAccompagnement();
        int chiffre = 1;
        System.out.println("Veuillez selectionner le numéro de votre accompagnement");
        for (String accompagnement : listeAccompagnement) {
            System.out.println(chiffre + " : " + accompagnement);
            chiffre++;
        }
        int numeroAccompagnement = Clavier.entrerClavierInt();
        return numeroAccompagnement;
    }

    private int selectionnerBoisson() {
        List<String> listeBoisson = controlCommander.donnerListeBoisson();
        int chiffre = 1;
        System.out.println("Veuillez selectionner le numéro de votre boisson");
        for (String boisson : listeBoisson) {
            System.out.println(chiffre + " : " + boisson);
            chiffre++;
        }
        int numeroBoisson = Clavier.entrerClavierInt();
        return numeroBoisson;
    }
}