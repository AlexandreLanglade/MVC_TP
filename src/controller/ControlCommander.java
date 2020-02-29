package controller;

import java.util.ArrayList;
import java.util.List;

import model.Accompagnement;
import model.BDClient;
import model.BDCommande;
import model.Boisson;
import model.Client;
import model.Hamburger;
import model.Menu;
import model.ProfilUtilisateur;

/**
 * ControlCommander
 */
public class ControlCommander {

    private ControlVerifierIdentification controlVerifierIdentification;
    private Menu menu = Menu.getInstance();
    private BDClient bdClient = BDClient.getInstance();
    private BDCommande bdCommande = BDCommande.getInstance();

    public ControlCommander(ControlVerifierIdentification controlVerifierIdentification) {
        this.controlVerifierIdentification = controlVerifierIdentification;
    }

    public boolean verifierIdentification(int numClient) {
        return controlVerifierIdentification.verifierIdentification(ProfilUtilisateur.CLIENT, numClient);
    }

    public List<String> donnerListeHamburger() {
        List<String> listeNomHamburger = new ArrayList<>();
        List<Hamburger> listeHamburger = menu.getListeHamburger();
        for (Hamburger hamburger : listeHamburger) {
            listeNomHamburger.add(hamburger.getNom());
        }
        return listeNomHamburger;
    }

    public List<String> donnerListeAccompagnement() {
        List<String> listeNomAccompagnement = new ArrayList<>();
        List<Accompagnement> listeAccompagnement = menu.getListeAccompagnement();
        for (Accompagnement accompagnement : listeAccompagnement) {
            listeNomAccompagnement.add(accompagnement.getNom());
        }
        return listeNomAccompagnement;
    }

    public List<String> donnerListeBoisson() {
        List<String> listeNomBoisson = new ArrayList<>();
        List<Boisson> listeBoisson = menu.getListeBoisson();
        for (Boisson boisson : listeBoisson) {
            listeNomBoisson.add(boisson.getNom());
        }
        return listeNomBoisson;
    }

    public boolean verifierExistanceCarteBancaire(int numClient) {
        Client client = bdClient.trouverClient(numClient);
        return client.verifierExistanceCarteBancaire();
    }

    public int enregistrerCommande(int numClient, int numeroHamburger, int numeroAccompagnement, int numeroBoisson) {
        Hamburger hamburger = menu.choixHamburger(numeroHamburger);
        Accompagnement accompagnement = menu.choixAccompagnement(numeroAccompagnement);
        Boisson boisson = menu.choixBoisson(numeroBoisson);
        int numeroCommande = bdCommande.enregistrerCommande(numClient, hamburger, accompagnement, boisson);
        return numeroCommande;
    }
}