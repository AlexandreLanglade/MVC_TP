package vuegraphique;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.MenuBar;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ControlCommander;
import controller.ControlEnregistrerCoordonneesBancaires;

/**
 * FrameClient
 */
public class FrameClient extends JFrame {

    private static final long serialVersionUID = 1L;
    private int numClient;

    private MenuBar barreMenu = new MenuBar();

    private JPanel panAccueil = new JPanel();
    private JPanel panContents = new JPanel();
    private PanCommander panCommander;
    private PanHistorique panHistorique = new PanHistorique();
    private PanModifierProfil panModifierProfil = new PanModifierProfil();

    private CardLayout cartes = new CardLayout();

    public FrameClient(int numClient,
    ControlCommander controlCommander,
    ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires
    ) {
        this.numClient = numClient;

        setTitle("BurgerResto");
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanEnregistrerCoordonneesBancaire panEnregistrerCoordonneesBancaire = new PanEnregistrerCoordonneesBancaire(controlEnregistrerCoordonneesBancaires);
        panCommander = new PanCommander(controlCommander, panEnregistrerCoordonneesBancaire);
        panCommander.initialisation();
        panHistorique.initialisation();
        panModifierProfil.initialisation();
        panEnregistrerCoordonneesBancaire.initialisation();
        
        panContents.setLayout(cartes);

        panContents.add(panCommander, "COMMANDER");
        panCommander.add(panEnregistrerCoordonneesBancaire, "ENREGISTRER_COORDONNEES_BANCAIRE");
        panContents.add(panModifierProfil, "MODIFIER_PROFIL");
        panContents.add(panHistorique, "HISTORIQUE");
    
        getContentPane().add(panContents);

        initialisationMenu();
        setMenuBar(barreMenu);

        initialisationAcceuil();

        setVisible(true);
    }

    private void initialisationMenu() {
        MenuItem commander = new MenuItem("Commander");
        commander.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            panCommander.commander(numClient);
            cartes.show(panContents, "COMMANDER");
            }
            });

        MenuItem modifierProfil = new MenuItem("Modifier Profil");
        modifierProfil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            cartes.show(panContents, "MODIFIER_PROFIL");
            }
            });
        
        MenuItem consulterHistorique = new MenuItem("Consulter historique");
        consulterHistorique.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            cartes.show(panContents, "HISTORIQUE");
            }
            });
        
        Menu menuMonCompte = new Menu("Mon compte ");

        menuMonCompte.add(commander);
        menuMonCompte.add(modifierProfil);
        menuMonCompte.add(consulterHistorique);

        Menu menuDeconnexion = new Menu("Deconnexion");

        barreMenu.add(menuMonCompte);
        barreMenu.add(menuDeconnexion);
    }

    private void initialisationAcceuil(){
        panAccueil.setBackground(Color.ORANGE);
        JLabel texteAccueil = new JLabel("Bienvenu à Burger Resto");
        texteAccueil.setFont(new Font("Calibri", Font.BOLD, 24));
        panAccueil.add(texteAccueil);
        panAccueil.setVisible(true);
        panContents.add(panAccueil, "ECRAN_ACCUEIL");
        cartes.show(panContents, "ECRAN_ACCUEIL");
    }
}