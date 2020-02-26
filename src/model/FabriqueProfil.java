package model;

/**
 * FabriqueProfil
 */
public class FabriqueProfil {

    public static Profil creerProfil(ProfilUtilisateur profilUtilisateur, String nom, String prenom, String mdp) {
        Profil profil = null;
        switch (profilUtilisateur) {
            case PERSONNEL:
                profil = new Personnel(nom, prenom, mdp);
                break;

            case GERANT:
                profil = new Personnel(nom, prenom, mdp);
                ((Personnel) profil).definirGerant();
                break;

            default:
                profil = new Client(nom, prenom, mdp);
                break;
        }
        return profil;
    }
}