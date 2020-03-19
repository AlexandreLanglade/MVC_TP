package vuegraphique;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
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
    private JComboBox<String> comboBoxAccompagnement = new JComboBox<>();
    private JComboBox<String> comboBoxBoisson = new JComboBox<>();

    private JButton validerCommande = new JButton();

    private Box boxValiderChoix = Box.createHorizontalBox();

    private Box boxMiseEnPageCommande = Box.createVerticalBox();
    private Box boxChoixHamburger = Box.createHorizontalBox();
    private Box boxChoixAccompagnement = Box.createHorizontalBox();
    private Box boxChoixBoisson = Box.createHorizontalBox();

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
        JLabel texteAccompagnement = new JLabel("Choisissez votre accompagnement");
        texteAccompagnement.setFont(policeParagraphe);
        JLabel texteBoisson = new JLabel("Choisissez votre boisson");
        texteBoisson.setFont(policeParagraphe);

        comboBoxHamburger.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        numeroHamburger = comboBoxHamburger.getSelectedIndex();
        }
        });

        comboBoxAccompagnement.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        numeroAccompagnement = comboBoxAccompagnement.getSelectedIndex();
        }
        });

        comboBoxBoisson.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        numeroBoisson = comboBoxBoisson.getSelectedIndex();
        }
        });

        validerCommande.setText("Valider");
            validerCommande.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            if (
            numeroHamburger != 0 && numeroAccompagnement != 0
            && numeroBoisson != 0) {
            System.out.println("OK");;
            }
            }
            });

        boxMiseEnPageCommande.add(texteCommander);
        boxMiseEnPageCommande.add(Box.createRigidArea(new Dimension(0, 30)));
        
        boxChoixHamburger.add(texteHamburger);
        boxChoixHamburger.add(comboBoxHamburger);
        boxChoixAccompagnement.add(texteAccompagnement);
        boxChoixAccompagnement.add(comboBoxAccompagnement);
        boxChoixBoisson.add(texteBoisson);
        boxChoixBoisson.add(comboBoxBoisson);

        boxValiderChoix.add(validerCommande);

        boxMiseEnPageCommande.add(boxChoixHamburger);
        boxMiseEnPageCommande.add(boxChoixAccompagnement);
        boxMiseEnPageCommande.add(boxChoixBoisson);
        boxMiseEnPageCommande.add(boxValiderChoix);

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

        List<String> listeAccompagnement = controlCommande.donnerListeAccompagnement();
        comboBoxAccompagnement.removeAllItems();
        comboBoxAccompagnement.addItem("");
        for (String accompagnement : listeAccompagnement) {
            comboBoxAccompagnement.addItem(accompagnement);
        }

        List<String> listeBoisson = controlCommande.donnerListeBoisson();
        comboBoxBoisson.removeAllItems();
        comboBoxBoisson.addItem("");
        for (String boisson : listeBoisson) {
            comboBoxBoisson.addItem(boisson);
        }
    }
}