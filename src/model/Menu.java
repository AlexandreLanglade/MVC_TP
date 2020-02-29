package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Menu
 */
public class Menu {

    private List<Hamburger> listeHamburger = new ArrayList<>();
    private List<Accompagnement> listeAccompagnement = new ArrayList<>();
    private List<Boisson> listeBoisson = new ArrayList<>();

    private Menu() {
    }

    private static class MenuHolder {
        private final static Menu instance = new Menu();
    }

    public static Menu getInstance() {
        return MenuHolder.instance;
    }

    public void ajouterAliment(Hamburger hamburger) {
        listeHamburger.add(hamburger);
    }

    public void ajouterAliment(Accompagnement accompagnement) {
        listeAccompagnement.add(accompagnement);
    }

    public void ajouterAliment(Boisson boisson) {
        listeBoisson.add(boisson);
    }

    public Hamburger choixHamburger(int numeroHamburger) {
        return listeHamburger.get(numeroHamburger);
    }

    public Accompagnement choixAccompagnement(int numeroAccompagnement) {
        return listeAccompagnement.get(numeroAccompagnement);
    }

    public Boisson choixBoisson(int numeroBoisson) {
        return listeBoisson.get(numeroBoisson);
    }

    public String toString() {
        return "Menu [listeHamburger=" + listeHamburger + ", listeBoisson=" + listeBoisson + ", listeAccompagnement="
                + listeAccompagnement + "]";
    }

    public List<Hamburger> getListeHamburger() {
        return listeHamburger;
    }

    public List<Accompagnement> getListeAccompagnement() {
        return listeAccompagnement;
    }

    public List<Boisson> getListeBoisson() {
        return listeBoisson;
    }
}