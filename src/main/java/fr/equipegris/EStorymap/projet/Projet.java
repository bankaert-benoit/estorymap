package fr.equipegris.EStorymap.projet;

import fr.equipegris.EStorymap.diagramme.mfc.Mfc;
import fr.equipegris.EStorymap.user.User;

import javax.persistence.*;

@Entity
public class Projet {

    @Id
    @GeneratedValue( strategy = GenerationType. SEQUENCE , generator =" Seq_projet ")
    @SequenceGenerator( name =" Seq_projet ", sequenceName =" Seq_projet ", allocationSize =1)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner", referencedColumnName = "idu")
    private User owner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mfc", referencedColumnName = "id_mfc")
    private Mfc mfc;

    public Projet(String name, User u) {
        this.name = name;
        this.owner = u;
    }

    public Projet() {}

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
    /*
    public Mfc getMfc() {
        return mfc;
    }

    public void setMfc(Mfc mfc) {
        this.mfc = mfc;
    }*/

    @Override
    public String toString() {
        return "Projet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                '}';
    }
}
