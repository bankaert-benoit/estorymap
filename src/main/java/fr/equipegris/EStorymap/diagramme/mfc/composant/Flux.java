package fr.equipegris.EStorymap.diagramme.mfc.composant;

public class Flux {

    private String libelle;
    private String name;
    private String value;

    public Flux(String libelle, String name, String value) {
        this.libelle = libelle;
        this.name = name;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Flux{" +
                "libelle='" + libelle + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
