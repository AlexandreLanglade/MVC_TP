package vuegraphique;

import javax.swing.JPanel;

import controller.ControlEnregistrerCoordonneesBancaires;

/**
 * PanEnregistrerCoordonneesBancaire
 */
public class PanEnregistrerCoordonneesBancaire extends JPanel {
    
    private static final long serialVersionUID = 1L;
    // controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
    private ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;
	// les attributs metiers (ex : numClient)

	// Les elements graphiques :
	// polices d'ecritures
	// Les ComboBox
	// Les Button

	// Mise en page : les Box

	public PanEnregistrerCoordonneesBancaire (
			// parmetres pour l'initialisation des attributs metiers 
            // parametres correspondants au controleur du cas + panels
            ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires 
			// des cas inclus ou etendus en lien avec un acteur
		) {
		// initialisation des attributs metiers 
        // initilaisation du controleur du cas + panels 
        this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
		// des cas inclus ou etendus en lien avec un acteur
	}

	//Methode d'initialisation du panel
	public void initialisation() {
		// mise en forme du panel (couleur, ...)
		// creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)

		// mise en page : placements des differents elements graphiques dans des Box
		// mise en page : placements des differentes box dans une box principale
		// mise en page : ajout de la box principale dans le panel
	}

	// Methode correspondant au nom du cas
	public void enregistrerCoordonneesBancaire( /*parametres metiers*/ ) {
	}

	// Methodes privees pour le bon deroulement du cas
}