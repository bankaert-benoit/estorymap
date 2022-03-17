package fr.equipegris.EStorymap.diagramme.mfc.composant;

import javax.persistence.*;

@Entity
public class Flux {

    @Id
    @GeneratedValue( strategy = GenerationType. SEQUENCE , generator =" Seq_flux ")
    @SequenceGenerator( name =" Seq_flux ", sequenceName =" Seq_flux ", allocationSize =1)
    private Long id;
    @Column
    private String libelle;
    @Column
    private String name;
    @Column
    private String value;

    public Flux(String libelle, String name, String value) {
        this.libelle = libelle;
        this.name = name;
        this.value = value;
    }

    public Flux() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
