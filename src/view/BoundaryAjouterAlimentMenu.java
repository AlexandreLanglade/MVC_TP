package view;

import controller.ControlAjouterAlimentMenu;
import model.AlimentMenu;
import model.ProfilUtilisateur;

/**
 * BoundaryAjouterAlimentMenu
 */
public class BoundaryAjouterAlimentMenu {

    private ControlAjouterAlimentMenu controlAjouterAlimentMenu;

    public BoundaryAjouterAlimentMenu(ControlAjouterAlimentMenu controlAjouterAlimentMenu) {
        this.controlAjouterAlimentMenu = controlAjouterAlimentMenu;
    }

    public void ajouterAlimentMenu(int numProfil) {
        boolean identificationOK = controlAjouterAlimentMenu.verifierIdentification(ProfilUtilisateur.GERANT,
                numProfil);
        if (identificationOK) {
            System.out.println("Entrer le numéro du type d'aliment que vous souhaitez ajouter");
            int choix = -1;
            while (!(choix == 1 || choix == 2 || choix == 3)) {
                System.out.println("1 : ajouter un hamburger");
                System.out.println("2 : ajouter un accompagnement");
                System.out.println("3 : ajouter une boisson");
                choix = Clavier.entrerClavierInt();
                if (!(choix == 1 || choix == 2 || choix == 3)) {
                    System.out.println("Veuillez entrer 1, 2 ou 3");
                }
            }
            System.out.println("Veuillez entrer le nom de l'aliment");
            String nomAliment = Clavier.entrerClavierString();
            switch (choix) {
                case 1:
                    controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.HAMBURGER, nomAliment);
                    break;

                case 2:
                    controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.ACCOMPAGNEMENT, nomAliment);
                    break;

                case 3:
                    controlAjouterAlimentMenu.ajouterAliment(AlimentMenu.BOISSON, nomAliment);
                    break;

                default:
                    System.out.println("Type d'aliment non reconnu");
                    break;
            }
        }
    }
}