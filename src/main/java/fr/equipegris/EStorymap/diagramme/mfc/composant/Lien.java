package fr.equipegris.EStorymap.diagramme.mfc.composant;

import fr.equipegris.EStorymap.diagramme.mfc.Composant;

import java.io.Serializable;

public class Lien implements Serializable {

    private Composant entite;

    private Composant entiteFils;

    public Lien(Composant entite, Composant entiteFils) {
        this.entite = entite;
        this.entiteFils = entiteFils;
    }

    public Composant getEntite() {
        return entite;
    }

    public void setEntite(Composant entite) {
        this.entite = entite;
    }

    public Composant getEntiteFils() {
        return entiteFils;
    }

    public void setEntiteFils(Composant entiteFils) {
        this.entiteFils = entiteFils;
    }
}
