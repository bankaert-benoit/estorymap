package fr.equipegris.EStorymap.diagramme.mfc.composant;

public class Acteur {

    private String nom;

    public Acteur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
