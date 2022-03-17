package fr.equipegris.EStorymap.diagramme.mfc.composant;

import javax.persistence.*;

@Entity
public class Acteur {

    @Id
    @GeneratedValue( strategy = GenerationType. SEQUENCE , generator =" Seq_acteur ")
    @SequenceGenerator( name =" Seq_acteur ", sequenceName =" Seq_acteur ", allocationSize =1)
    private Long id;

    @Column
    private String nom;

    public Acteur(String nom) {
        this.nom = nom;
    }

    public Acteur() {}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Acteur{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
