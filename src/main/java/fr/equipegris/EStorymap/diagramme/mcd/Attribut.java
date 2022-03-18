package fr.equipegris.EStorymap.diagramme.mcd;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
public class Attribut {

    @Id
    @GeneratedValue ( strategy = GenerationType. SEQUENCE , generator =" Seq_attribut ")
    @SequenceGenerator( name =" Seq_attribut ", sequenceName =" Seq_attribut ", allocationSize =1)
    private Long id;
    @Column
    private String name;
    @Column
    private String type;

    public Attribut(String name,String type){
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Attribut{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
