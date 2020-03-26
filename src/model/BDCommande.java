package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

/**
 * BDCommande
 */
public class BDCommande {

    private Map<Integer, Commande> mapCommandes = new HashMap<>();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    private BDCommande() {
    }

    private static class BDCommandeHolder {
        private final static BDCommande instance = new BDCommande();
    }

    public static BDCommande getInstance() {
        return BDCommandeHolder.instance;
    }

    public int enregistrerCommande(int numClient, Hamburger hamburger, Accompagnement accompagnement, Boisson boisson) {
        Commande commande = new Commande(numClient, hamburger, accompagnement, boisson);
        mapCommandes.put(commande.getNumeroCommandeAttribuee(), commande);
        String[] labels = new String[4];
        labels[0] = String.valueOf(commande.getNumeroCommandeAttribuee());
        labels[1] = hamburger.getNom();
        labels[2] = accompagnement.getNom();
        labels[3] = boisson.getNom();
        support.firePropertyChange(PropertyName.ENREGISTRER_COMMANDE.toString(), null, labels);
        return commande.getNumeroCommandeAttribuee();
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void viderCommandeJour() {
        mapCommandes.clear();
        Commande.clearNombreCommande();
        support.firePropertyChange(PropertyName.VIDER_COMMANDE_JOUR.toString(), null, null);
    }
}