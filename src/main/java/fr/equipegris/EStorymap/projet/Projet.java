package fr.equipegris.EStorymap.projet;

import fr.equipegris.EStorymap.diagramme.bpmn.Bpmn;
import fr.equipegris.EStorymap.diagramme.mcd.Mcd;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bpmn", referencedColumnName = "id_bpmn")
    private Bpmn bpmn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mcd", referencedColumnName = "id_mcd")
    private Mcd mcd;

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

    public Mfc getMfc() {
        return mfc;
    }

    public void setMfc(Mfc mfc) {
        this.mfc = mfc;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Bpmn getBpmn() {
        return bpmn;
    }

    public void setBpmn(Bpmn bpmn) {
        this.bpmn = bpmn;
    }

    public Mcd getMcd() {
        return mcd;
    }

    public void setMcd(Mcd mcd) {
        this.mcd = mcd;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Projet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner );
        if (mfc != null){
            sb.append(", mfc=" + mfc.toString());
        }
        if (mcd != null){
            sb.append(", mcd=" + mcd.toString());
        }
        if (bpmn != null){
            sb.append(", bpmn=" + bpmn.toString());
        }
        sb.append("}");

        return sb.toString();
    }
}
