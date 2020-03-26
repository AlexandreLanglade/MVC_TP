package vuegraphique;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;

import controller.ControlEnregistrerCoordonneesBancaires;

/**
 * PanEnregistrerCoordonneesBancaire
 */
public class PanEnregistrerCoordonneesBancaire extends JPanel {
    
    private static final long serialVersionUID = 1L;
    // controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
    private ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;
	private IUseEnregistrerCoordonneesBancaires panAppelant;
	// les attributs metiers (ex : numClient)
	private int numClient;
	// Les elements graphiques :
	// polices d'ecritures
	private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
	private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);
	private Font policeAremplacer = new Font("Arial", Font.ITALIC, 12);
	private Font policeChoixUtilisateur = new Font("Arial", Font.TRUETYPE_FONT, 12);
	// Les ComboBox
	// Les Button
	//TextArea
	private TextArea textAeraNumeroCarte = new TextArea();
	private TextArea textAreaDateExpiration = new TextArea();

	// Mise en page : les Box
	private Box boxMiseEnPageCoordonneesBancaires = Box.createVerticalBox();
	private Box boxNumeroCarte = Box.createHorizontalBox();
	private Box boxValiditeCarte = Box.createHorizontalBox();
	private Box boxValiderCarte = Box.createHorizontalBox();

	public PanEnregistrerCoordonneesBancaire (
			// parmetres pour l'initialisation des attributs metiers 
            // parametres correspondants au controleur du cas + panels
            ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires 
			// des cas inclus ou etendus en lien avec un acteur
		) {
		// initialisation des attributs metiers 
        // initilaisation du controleur du cas + panels 
		// des cas inclus ou etendus en lien avec un acteur
		this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
	}

	//Methode d'initialisation du panel
	public void initialisation() {
		// mise en forme du panel (couleur, ...)
		setBackground(Color.YELLOW);
		// creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)
		JLabel texteCoordonneesBancaires = new JLabel("Entrer vos coordonnées bancaires");
		texteCoordonneesBancaires.setFont(policeTitre);
		JLabel texteNumeroCarteBancaire = new JLabel("Entrer le numéro de votre carte bancaire");
		texteNumeroCarteBancaire.setFont(policeParagraphe);
		JLabel texteValiditeCarte = new JLabel("Entrer la date d’expiration de votre carte bancaire");
		texteValiditeCarte.setFont(policeParagraphe);
		
		JButton validationCoordonneeBancaire = new JButton();
		validationCoordonneeBancaire.setText("Valider");
		validationCoordonneeBancaire.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int numeroCarte = Integer.valueOf(textAeraNumeroCarte.getText());
			int dateCarte = Integer.valueOf(textAreaDateExpiration.getText());
			traitementCoordonneesBancaires(numeroCarte, dateCarte);
		}
		});

		textAeraNumeroCarte.setMaximumSize(new Dimension(120, 20));
		textAreaDateExpiration.setForeground(Color.GRAY);
		textAreaDateExpiration.setMaximumSize(new Dimension(60,20));
		textAreaDateExpiration.setFont(policeAremplacer);
		textAreaDateExpiration.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
			textAreaDateExpiration.setText(null);
			textAreaDateExpiration.setFont(policeChoixUtilisateur);
			textAreaDateExpiration.setForeground(Color.black);
			}
			});
		// mise en page : placements des differents elements graphiques dans des Box
		boxMiseEnPageCoordonneesBancaires.add(texteCoordonneesBancaires);
		boxNumeroCarte.add(texteNumeroCarteBancaire);
		boxValiderCarte.add(texteValiditeCarte);
		boxValiderCarte.add(validationCoordonneeBancaire);
		boxNumeroCarte.add(textAeraNumeroCarte);
		boxValiditeCarte.add(textAreaDateExpiration);
		// mise en page : placements des differentes box dans une box principale
		boxMiseEnPageCoordonneesBancaires.add(boxNumeroCarte);
		boxMiseEnPageCoordonneesBancaires.add(boxValiditeCarte);
		boxMiseEnPageCoordonneesBancaires.add(boxValiderCarte);
		// mise en page : ajout de la box principale dans le panel
		add(boxMiseEnPageCoordonneesBancaires);
		boxMiseEnPageCoordonneesBancaires.setVisible(true);
		setVisible(false);
	}

	// Methode correspondant au nom du cas
	public void enregistrerCoordonneesBancaire(int numClient, IUseEnregistrerCoordonneesBancaires panAppelant) {
		this.numClient = numClient;
		this.panAppelant =panAppelant;
		textAeraNumeroCarte.setText("");
		textAreaDateExpiration.setText("MMAA");
		this.setVisible(true);
		this.repaint();
	}

	// Methodes privees pour le bon deroulement du cas

	private void traitementCoordonneesBancaires(int numeroCarte, int dateCarte) {
		boolean carteValide = controlEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient, numeroCarte, dateCarte);
		panAppelant.retourEnregistrerCoordonneesBancaire(carteValide);
	}
}