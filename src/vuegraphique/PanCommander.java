package vuegraphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControlCommander;

/**
 * PanCommander
 */
public class PanCommander extends JPanel {

    private static final long serialVersionUID = 1L;
    private ControlCommander controlCommande;
    private PanEnregistrerCoordonneesBancaire panEnregistrerCoordonneesBancaire;

    private int numeroClient;
    private int numeroHamburger = 0;
    private int numeroAccompagnement = 0;
    private int numeroBoisson = 0;

    private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
    private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);

    private JComboBox<String> comboBoxHamburger = new JComboBox<>();

    Box boxMiseEnPageCommande = Box.createVerticalBox();
    Box boxChoixHamburger = Box.createHorizontalBox();

    public PanCommander(
        // parametres pour l'initialisation des attributs metiers
        // parametres correspondants au controleur du cas + panels
        // des cas inclus ou etendus en lien avec un acteur
        ControlCommander controlCommande, PanEnregistrerCoordonneesBancaire
        panEnregistrerCoordonneesBancaire) {
        // initialisation des attributs metiers
        // initilaisation du controleur du cas + panels
        // des cas inclus ou etendus en lien avec un acteur
        this.controlCommande = controlCommande;
        this.panEnregistrerCoordonneesBancaire = panEnregistrerCoordonneesBancaire;
    }

    public void initialisation() {
        setBackground(Color.YELLOW);

        JLabel texteCommander = new JLabel("Votre menu");
        texteCommander.setFont(policeTitre);
        JLabel texteHamburger = new JLabel("Choisissez votre hamburger");
        texteHamburger.setFont(policeParagraphe);

        comboBoxHamburger.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        numeroHamburger = comboBoxHamburger.getSelectedIndex();
        }
        });

        boxMiseEnPageCommande.add(texteCommander);
        boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0, 30)));
        boxChoixHamburger.add(texteHamburger);

        boxChoixHamburger.add(comboBoxHamburger);

        boxMiseEnPageCommande.add(boxChoixHamburger);

        add(boxMiseEnPageCommande);
    }

    public void commander(int numClient) {
        numeroClient = numClient;
        boolean identif = controlCommande.verifierIdentification(numeroClient);
        if (identif) {
            affichageMenu();
        }
    }

    private void affichageMenu() {
        List<String> listeHamburger = controlCommande.donnerListeHamburger();
        comboBoxHamburger.removeAllItems();
        comboBoxHamburger.addItem("");
        for (String hamburger : listeHamburger) {
            comboBoxHamburger.addItem(hamburger);
        }
    }
}