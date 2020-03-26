package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import controller.ControlVisualiserCommandeJour;
import model.ProfilUtilisateur;
import model.PropertyName;

/**
 * BoundaryVisualiserCommandeJour
 */
public class BoundaryVisualiserCommandeJour implements PropertyChangeListener {

    private ControlVisualiserCommandeJour control;

    public BoundaryVisualiserCommandeJour(ControlVisualiserCommandeJour control) {
        this.control = control;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        PropertyName choix = PropertyName.valueOf(propertyName);
        switch(choix) {
            case ENREGISTRER_COMMANDE:
                Object objet = evt.getNewValue();
                String[] labels = (String[]) objet;
                String numCommande = labels[0];
                String nomHamburger = labels[1];
                String nomAccompagnement = labels[2];
                String nomBoisson = labels[3];
                Fichier.ecrire("Commande no "+ numCommande + " : " + nomHamburger + ", " + nomAccompagnement + ", "
                        + nomBoisson);
                break;
            case VIDER_COMMANDE_JOUR:
                Fichier.effacer();
                break;
            default:
                System.out.println("Numéro d'affichage non reconnu");
                break;
        }
    }

    public void visualiserCommandeJour(int numeroProfil) {
        if (control.verifierIdentification(numeroProfil, ProfilUtilisateur.PERSONNEL)) {
            control.setListener(PropertyName.ENREGISTRER_COMMANDE.toString(), this);
            control.setListener(PropertyName.VIDER_COMMANDE_JOUR.toString(), this);
        }
    }
}