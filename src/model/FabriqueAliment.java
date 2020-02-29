package model;

/**
 * FabriqueAliment
 */
public class FabriqueAliment {

    public static Aliment creerAliment(AlimentMenu alimentMenu, String nom) {
        Aliment aliment = null;
        switch (alimentMenu) {
            case HAMBURGER:
                aliment = new Hamburger(nom);
                break;

            case ACCOMPAGNEMENT:
                aliment = new Accompagnement(nom);
                break;

            default:
                aliment = new Boisson(nom);
                break;
        }
        return aliment;
    }
}