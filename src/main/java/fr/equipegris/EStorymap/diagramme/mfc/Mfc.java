package fr.equipegris.EStorymap.diagramme.mfc;

import fr.equipegris.EStorymap.diagramme.mfc.composant.Acteur;
import fr.equipegris.EStorymap.diagramme.mfc.composant.Flux;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="MFC")
public class Mfc {
	
	@Id
	@GeneratedValue ( strategy = GenerationType . SEQUENCE , generator =" Seq_mfc ")
	@SequenceGenerator ( name =" Seq_mfc ", sequenceName =" Seq_mfc ", allocationSize =1)
	private Long id_mfc;
	public void setId(Long i) {this.id_mfc=i;}
	public Long getId() {return id_mfc;}
	
	@Column
	private String titre;
	public String getTitre() {return titre;}
	public void setTitre(String t) {this.titre=t;}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	private Set<Acteur> acteurs;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	private Set<Flux> flux;
	public Set<Flux> getFlux(){
		return this.flux;
	}

	public Mfc(String titre, Set<Acteur> acteurs, Set<Flux> flux) {
		this.titre = titre;
		this.acteurs = acteurs;
		this.flux = flux;
	}

	public Mfc(){}

	@Override
	public String toString() {
		return "Mfc{" +
				"id_mfc=" + id_mfc +
				", titre='" + titre + '\'' +
				'}';
	}
}
