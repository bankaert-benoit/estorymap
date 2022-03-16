package fr.equipegris.EStorymap.diagramme.mfc.composant;

import fr.equipegris.EStorymap.diagramme.mfc.Composant;

import java.io.Serializable;

public class ActeurExterne extends Composant implements Serializable {

    private String nom;

    public ActeurExterne(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
