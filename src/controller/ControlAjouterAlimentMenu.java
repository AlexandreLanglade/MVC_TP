package controller;

import model.Accompagnement;
import model.Aliment;
import model.AlimentMenu;
import model.Boisson;
import model.FabriqueAliment;
import model.Hamburger;
import model.Menu;
import model.ProfilUtilisateur;

/**
 * ControlAjouterAlimentMenu
 */
public class ControlAjouterAlimentMenu {

    private Menu menu = Menu.getInstance();
    private ControlVerifierIdentification controlVerifierIdentification;

    public ControlAjouterAlimentMenu(ControlVerifierIdentification controlVerifierIdentification) {
        this.controlVerifierIdentification = controlVerifierIdentification;
    }

    public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numeroProfil) {
        return controlVerifierIdentification.verifierIdentification(profilUtilisateur, numeroProfil);
    }

    public void ajouterAliment(AlimentMenu alimentMenu, String nom) {
        Aliment aliment = null;
        switch (alimentMenu) {
            case HAMBURGER:
                aliment = FabriqueAliment.creerAliment(AlimentMenu.HAMBURGER, nom);
                menu.ajouterAliment((Hamburger) aliment);
                break;

            case ACCOMPAGNEMENT:
                aliment = FabriqueAliment.creerAliment(AlimentMenu.ACCOMPAGNEMENT, nom);
                menu.ajouterAliment((Accompagnement) aliment);
                break;

            case BOISSON:
                aliment = FabriqueAliment.creerAliment(AlimentMenu.BOISSON, nom);
                menu.ajouterAliment((Boisson) aliment);
                break;

            default:
                break;
        }
    }

    public String visualiserMenu() {
        return menu.toString();
    }

}